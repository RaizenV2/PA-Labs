import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    private ArrayList<ClientThread> clientThreads = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.init();
        server.waitForClients(); //... handle the exceptions!
    }

    // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.
    private void waitForClients() throws IOException {
        try {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                System.out.println("Connection established");
                // Execute the client's request in a new thread
                ClientThread cT = new ClientThread(socket);
                cT.start();
                clientThreads.add(cT);
            }

        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }

    // Implement the init() method: create the serverSocket and set running to true
    private void init() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }

    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}