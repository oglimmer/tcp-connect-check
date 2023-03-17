import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpConnectCheck {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("2 args required.");
            System.exit(1);
        }
        try {
            try (Socket clientSocket = new Socket(args[0], Integer.parseInt(args[1]))) {
                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out.println("QUIT");
                    in.readLine();
                }
            }
        } catch (Throwable e) {
            System.exit(1);
        }
    }
}
