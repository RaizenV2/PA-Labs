import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;

    private Socket socket = null ;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public Client() throws IOException {
        socket = new Socket(SERVER_ADDRESS, PORT);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            }
            if(request.equals("stop")){

                break;
            }
            if(request.equalsIgnoreCase("login")){
                client.sendRequestToServer(request);
            }
            if(request.equalsIgnoreCase("send")){
                client.sendRequestToServer(request);
            }else {
                client.sendRequestToServer(request);
            }
        }
    }

    private void sendRequestToServer(String request) throws IOException {
        try {
            out.println(request);
            out.flush();
            String response = in.readLine();
            System.out.println(response);
        }catch(IOException e) {
            System.err.println("No server listening... " + e);
        }
    }
    //Implement the sendRequestToServer method

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}