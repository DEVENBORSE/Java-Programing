import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) {
        try {
            System.out.println("\nWelcome to Chat Room\n");
            System.out.println("Initialising....\n");
            Thread.sleep(1000);

            Scanner sc = new Scanner(System.in);
            String host = InetAddress.getLocalHost().getHostName();
            String ip = InetAddress.getLocalHost().getHostAddress();
            System.out.println(host + " (" + ip + ")\n");

            System.out.print("Enter server address: ");
            String serverAddress = sc.nextLine();

            System.out.print("\nEnter your name: ");
            String name = sc.nextLine();

            int port = 1234;
            System.out.println("\nTrying to connect to " + serverAddress + " (" + port + ")\n");
            Thread.sleep(1000);

            Socket socket = new Socket(serverAddress, port);
            System.out.println("Connected...\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(name);
            String senderName = in.readLine();
            System.out.println(senderName + " has joined the chat room\nYou will receive messages from " + senderName);

            Random rand = new Random();

            while (true) {
                String m = in.readLine();
                if (m == null || m.equals("[e]")) {
                    System.out.println("Sender left the chat room.");
                    break;
                }

                String kStr = in.readLine();
                if (kStr == null) break;
                int k = Integer.parseInt(kStr);

                StringBuilder receivedBits = new StringBuilder();
                int i = 0;
                while (i < k) {
                    String bit = in.readLine();
                    if (bit == null) break;

                    int ackDecision = rand.nextInt(2); // 0 or 1
                    if (ackDecision == 0) {
                        out.println("ACK Lost");
                    } else {
                        out.println("ACK " + i);
                        receivedBits.append(bit);
                        i++;
                    }
                }
                System.out.println("The message received is : " + m);
            }
            sc.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
