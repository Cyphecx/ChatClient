import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.util.PriorityQueue;
import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;

public class MessageManager extends Thread {

    BufferedReader in;
    Socket client;

    public MessageManager(Socket client) throws IOException {
        this.client = client;
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.start();

    }

    public void run() {

        while (!client.isClosed()) {
            try {
                String message = in.readLine();
                // System.out.println(message);
                Server.send(message);
            } catch (IOException e) {

            }

        }
    }
}