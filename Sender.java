import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Sender {
    public static String toBinary(String s) {
        StringBuilder binary = new StringBuilder();
        for (char c : s.toCharArray()) {
            String bin = Integer.toBinaryString(c);
            binary.append(bin);
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println("\nWelcome to Chat Room");
            System.out.println("Initialising....\n");
            Thread.sleep(1000);

            ServerSocket serverSocket = new ServerSocket(1234);
            String host = InetAddress.getLocalHost().getHostName();
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(host + " (" + ip + ")\n");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.println("\nWaiting for incoming connections...\n");
            Socket socket = serverSocket.accept();
            System.out.println("Received connection from " + socket.getInetAddress().getHostAddress() +
                    " (" + socket.getPort() + ")\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String sName = in.readLine();
            System.out.println(sName + " has connected to the chat room\nEnter [e] to exit chat room\n");
            out.println(name);

            while (true) {
                System.out.print("Me: ");
                String message = sc.nextLine();

                if (message.equals("[e]")) {
                    out.println("[e]");
                    System.out.println("\nYou left the chat room.");
                    break;
                }

                String binaryMessage = toBinary(message);
                int totalBits = binaryMessage.length();

                // Send original message
                out.println(message);
                // Send length of binary data
                out.println(totalBits);

                System.out.print("Enter the window size -> ");
                int windowSize = Integer.parseInt(sc.nextLine());
                int i = 0;
                int k = windowSize - 1;

                while (i < totalBits) {
                    out.println(binaryMessage.charAt(i)); // send bit
                    String ack = in.readLine(); // wait for ACK
                    System.out.println(ack);

                    if (!ack.equals("ACK Lost")) {
                        System.out.println("Acknowledgement Received! The sliding window is in the range " +
                                (i + 1) + " to " + (java.lang.Math.min(k + 1, totalBits)) +
                                " Now sending the next packet");
                        i++;
                        k++;
                    } else {
                        System.out.println("Acknowledgement of the data bit is LOST! The sliding window remains in the range " +
                                (i + 1) + " to " + (java.lang.Math.min(k + 1, totalBits)) +
                                " Now Resending the same packet");
                    }
                    Thread.sleep(500);
                }
                System.out.println("Message sent successfully!\n");
            }
            sc.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
