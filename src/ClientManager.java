import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ClientManager extends Thread {

    boolean AcceptClients = true;
    ArrayList<Socket> clients;
    ServerSocket server;

    public ClientManager(ServerSocket server, ArrayList<Socket> clients) {

        this.clients = clients;
        this.server = server;
        this.start();

    }

    public void run() {

        while (AcceptClients) {
            Socket newClient = null;
            try {
                newClient = server.accept();
                new MessageManager(newClient);

            } catch (IOException e) {
            }
            System.out.println("I got a client" + newClient);
            clients.add(newClient);
        }
    }

    public void StopAcceptingClients() {
        AcceptClients = false;
    }

}