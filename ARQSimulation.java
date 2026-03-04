import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ARQSimulation {
    // --- Common Helper ---
    enum ChannelStatus { LOST, CORRUPTED, SENT }

    static Random random = new Random();

    static ChannelStatus simulateChannel(int frameNum, boolean isAck, double lossProb, double corruptProb) {
        if (random.nextDouble() < lossProb) {
            System.out.println("  " + (isAck ? "ACK " : "Frame ") + frameNum + " LOST!");
            return ChannelStatus.LOST;
        }
        if (!isAck && random.nextDouble() < corruptProb) { // only data frames can be corrupted
            System.out.println("  Frame " + frameNum + " CORRUPTED!");
            return ChannelStatus.CORRUPTED;
        }
        System.out.println("  " + (isAck ? "ACK " : "Frame ") + frameNum + " SENT successfully.");
        return ChannelStatus.SENT;
    }

    // --- Go-Back-N Simulation ---
    static void simulateGoBackN(int windowSize, int totalFrames, double lossProb, double corruptProb) {
        System.out.println("\n--- Simulating Go-Back-N ARQ ---");
        int senderWindowBase = 0;
        int nextSeqNum = 0;
        Map<Integer, String> senderBuffer = new HashMap<>();
        int receiverExpectedSeqNum = 0;

        int transmittedFramesCount = 0;
        int retransmittedFramesCount = 0;
        int successfulDeliveries = 0;

        System.out.println("Window Size: " + windowSize + ", Total Frames: " + totalFrames);

        while (successfulDeliveries < totalFrames) {
            // Sender: send frames within window
            while (nextSeqNum < totalFrames && (nextSeqNum - senderWindowBase) < windowSize) {
                String frameData = "DATA_" + nextSeqNum;
                senderBuffer.put(nextSeqNum, frameData);
                ChannelStatus status = simulateChannel(nextSeqNum, false, lossProb, corruptProb);
                transmittedFramesCount++;
                if (status == ChannelStatus.SENT) {
                    System.out.println("Sender: Sent Frame " + nextSeqNum);
                    // If receiver was expecting this frame and it was sent successfully we simulate receiver advancing
                    // but let ack logic below handle ack arrival/loss.
                }
                nextSeqNum++;
            }

            // Simulate receiver processing and sending ACK if it has progressed beyond senderWindowBase
            boolean ackReceived = false;
            if (receiverExpectedSeqNum > senderWindowBase) {
                ChannelStatus ackStatus = simulateChannel(receiverExpectedSeqNum, true, lossProb, 0.0);
                if (ackStatus == ChannelStatus.SENT) {
                    System.out.println("Sender: Received ACK for " + receiverExpectedSeqNum +
                            " (meaning frames up to " + (receiverExpectedSeqNum - 1) + " are acknowledged)");
                    senderWindowBase = receiverExpectedSeqNum;
                    ackReceived = true;
                    successfulDeliveries = receiverExpectedSeqNum;
                    // clear acknowledged frames
                    int baseToRemove = senderWindowBase; // copy to an effectively-final variable for lambda
                    senderBuffer.keySet().removeIf(k -> k < baseToRemove);
                }
            }

            // If no ack received and base hasn't advanced, timeout & retransmit from base
            if (!ackReceived && senderWindowBase < nextSeqNum && senderWindowBase < totalFrames) {
                System.out.println("Sender: Timeout for Frame " + senderWindowBase + " (or prior ACK lost). Retransmitting from " + senderWindowBase + "...");
                retransmittedFramesCount += (nextSeqNum - senderWindowBase);
                // reset nextSeqNum to base to retransmit
                nextSeqNum = senderWindowBase;
            }

            // Simplistic receiver logic:
            // We assume receiver_expected_seq_num follows sender_window_base when those frames were successfully sent.
            // We'll try to simulate that if frames in [senderWindowBase, nextSeqNum) were sent successfully (not lost/corrupted)
            // the receiverExpectedSeqNum increases accordingly. This is a crude model similar to the Python version.
            int advancedTo = senderWindowBase;
            for (int i = senderWindowBase; i < nextSeqNum && i < totalFrames; i++) {
                // Simulate that the receiver receives the frame successfully if it was SENT previously (we assume it was sent),
                // but also account for loss/corruption separately by randomly deciding.
                // For simplicity: consider it received if random says not lost and not corrupted on receiver path.
                double r = random.nextDouble();
                if (r > lossProb && r > corruptProb) { // rough check
                    advancedTo = i + 1;
                } else {
                    break; // receiver stops at first missing/corrupt frame (GBN)
                }
            }
            // receiverExpectedSeqNum follows the contiguous frames it has.
            receiverExpectedSeqNum = Math.max(receiverExpectedSeqNum, advancedTo);

            // brief sleep to simulate network delay
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
        }

        System.out.println("\n--- Go-Back-N Simulation Complete ---");
        System.out.println("Total frames delivered successfully: " + totalFrames);
        System.out.println("Total frames transmitted (including retransmissions): " + transmittedFramesCount);
        System.out.println("Total frames retransmitted: " + retransmittedFramesCount);
    }

    // --- Selective Repeat Simulation ---
    static class Frame {
        int seqNum;
        String data;
        Long timerStartMillis; // null when timer not running
        boolean acked;

        Frame(int s, String d) {
            seqNum = s;
            data = d;
            timerStartMillis = null;
            acked = false;
        }

        void startTimer() { timerStartMillis = System.currentTimeMillis(); }
        void resetTimer() { timerStartMillis = null; }
        boolean isTimeout(long timeoutDurationMillis) {
            if (timerStartMillis == null) return false;
            return (System.currentTimeMillis() - timerStartMillis) > timeoutDurationMillis;
        }
    }

    static void simulateSelectiveRepeat(int windowSize, int totalFrames, double lossProb, double corruptProb, long timeoutMillis) {
        System.out.println("\n--- Simulating Selective Repeat ARQ ---");
        int senderWindowBase = 0;
        int nextSeqNumToSend = 0;
        Map<Integer, Frame> senderBuffer = new TreeMap<>();

        int receiverWindowBase = 0;
        Set<Integer> receiverBuffer = new HashSet<>(); // store seq nums received out-of-order

        int transmittedFramesCount = 0;
        int retransmittedFramesCount = 0;

        System.out.println("Window Size: " + windowSize + ", Total Frames: " + totalFrames);

        while (receiverWindowBase < totalFrames) {
            // Sender: send frames within window
            while (nextSeqNumToSend < totalFrames && (nextSeqNumToSend - senderWindowBase) < windowSize) {
                if (!senderBuffer.containsKey(nextSeqNumToSend)) {
                    Frame frame = new Frame(nextSeqNumToSend, "DATA_" + nextSeqNumToSend);
                    senderBuffer.put(nextSeqNumToSend, frame);
                    ChannelStatus status = simulateChannel(frame.seqNum, false, lossProb, corruptProb);
                    transmittedFramesCount++;
                    if (status == ChannelStatus.SENT) {
                        frame.startTimer();
                        System.out.println("Sender: Sent Frame " + frame.seqNum);
                    }
                }
                nextSeqNumToSend++;
            }

            // Simulate ACK reception for some frames (randomly)
            List<Integer> acksToProcess = new ArrayList<>();
            for (Map.Entry<Integer, Frame> entry : new ArrayList<>(senderBuffer.entrySet())) {
                Frame frame = entry.getValue();
                int seq = frame.seqNum;
                // Randomly decide if ACK arrives (simulate network)
                if (!frame.acked && random.nextDouble() > lossProb) {
                    frame.acked = true;
                    acksToProcess.add(seq);
                    System.out.println("Sender: Received ACK for Frame " + seq);
                }
                // Check for timeouts
                if (frame.isTimeout(timeoutMillis) && !frame.acked) {
                    System.out.println("Sender: Timeout for Frame " + seq + ". Retransmitting...");
                    ChannelStatus status = simulateChannel(seq, false, lossProb, corruptProb);
                    transmittedFramesCount++;
                    retransmittedFramesCount++;
                    if (status == ChannelStatus.SENT) {
                        frame.startTimer();
                    } else {
                        // allow timer to remain running so we can retry later
                    }
                }
            }

            // Advance sender window for consecutive acked frames from base
            Collections.sort(acksToProcess);
            for (int ackSeq : acksToProcess) {
                // sliding window: remove consecutive acked frames starting from base
                while (senderBuffer.containsKey(senderWindowBase) && senderBuffer.get(senderWindowBase).acked) {
                    senderBuffer.remove(senderWindowBase);
                    senderWindowBase++;
                }
            }

            // Receiver: simulate receiving frames from senderBuffer that were sent successfully and not yet acked
            // For each frame in senderBuffer that is not acked we may simulate the receiver receiving it (or not)
            for (int i = senderWindowBase; i < nextSeqNumToSend && i < totalFrames; i++) {
                Frame sentFrame = senderBuffer.get(i);
                if (sentFrame == null) continue; // maybe already acked/removed
                // Simulate whether the receiver receives this frame successfully now
                double r = random.nextDouble();
                if (r > lossProb && r > corruptProb) { // frame arrives and is not corrupted
                    int frameRcvdSeq = sentFrame.seqNum;
                    System.out.println("Receiver: Received Frame " + frameRcvdSeq);
                    // If within receiver window
                    if (frameRcvdSeq >= receiverWindowBase && frameRcvdSeq < receiverWindowBase + windowSize) {
                        receiverBuffer.add(frameRcvdSeq);
                        // Receiver sends ACK (which may be lost)
                        simulateChannel(frameRcvdSeq, true, lossProb, 0.0);
                        // Advance receiver base for consecutive frames
                        while (receiverBuffer.contains(receiverWindowBase)) {
                            receiverBuffer.remove(receiverWindowBase);
                            receiverWindowBase++;
                        }
                    } else {
                        System.out.println("Receiver: Discarded out-of-window Frame " + frameRcvdSeq);
                    }
                } else {
                    // frame lost or corrupted in receiver path; nothing happens (sender will timeout and retransmit)
                }
            }

            // Small delay to simulate network/time passing
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
        }

        System.out.println("\n--- Selective Repeat Simulation Complete ---");
        System.out.println("Total frames delivered successfully (based on receiver window base): " + totalFrames);
        System.out.println("Total frames transmitted (including retransmissions): " + transmittedFramesCount);
        System.out.println("Total frames retransmitted: " + retransmittedFramesCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter window size (N): ");
        int winSize = Math.max(1, scanner.nextInt());
        System.out.print("Enter total number of frames to send: ");
        int numFrames = Math.max(1, scanner.nextInt());

        // Random probabilities for loss/corruption
        double lossProb = 0.2;
        double corruptProb = 0.1; // used only for data frames
        long srTimeoutMillis = 500; // 0.5 seconds for selective repeat
        // Run GBN then SR
        simulateGoBackN(winSize, numFrames, lossProb, corruptProb);
        simulateSelectiveRepeat(winSize, numFrames, lossProb, corruptProb, srTimeoutMillis);

        scanner.close();
    }
}
