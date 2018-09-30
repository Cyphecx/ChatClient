import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Server {

    final static ArrayList<Socket> clientList = new ArrayList<Socket>();
    static PriorityQueue<String> messageBuffer = new PriorityQueue<String>();

    public static void main(String[] args) {
        int port = 25565;

        ServerSocket socket = null;

        System.out.println("Server starting...");

        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Failed to bind server socket.\n Try another port.");
            System.exit(22);
        }

        ClientManager manager = new ClientManager(socket, clientList);

        boolean temp = true;
        while (temp) {
            if (messageBuffer.size() > 0) {
                System.out.println(messageBuffer.poll());
            }

        }
        manager.AcceptClients = true;
    }

    public static synchronized void send(String message) {
        messageBuffer.add(message);
    }

    public static synchronized void broadcast(String message) throws IOException {
        for (Socket s : clientList) {
            BufferedWriter in = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            in.write(message);
            in.newLine();
            in.flush();
        }
    }

    public static synchronized void broadcast(String message, ArrayList<Socket> blacklist) throws IOException {
        for (Socket s : clientList) {
            BufferedWriter in = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            in.write(message);
            in.newLine();
            in.flush();
        }
    }
}