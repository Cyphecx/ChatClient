import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket remote = new Socket("127.0.0.1", 25565);
        BufferedReader in = new BufferedReader(new InputStreamReader(remote.getInputStream()));
        PrintWriter out = new PrintWriter(remote.getOutputStream());
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while (run) {
            String outgoing = scan.nextLine();
            out.println(outgoing);
            out.flush();
        }

        remote.close();
        scan.close();
    }

}