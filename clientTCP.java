
import java.io.*;
import java.net.*;

public class clientTCP {
    public static void main(String args[]) throws Exception {
        String request_to_server = "";
        String message_to_user;
        while (!request_to_server.equals("quit")) {
            try {
                System.out.print("Input from client: ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                request_to_server = inFromUser.readLine();

                Socket clientSocket = new Socket("127.0.0.1", 8000);
            
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                outToServer.writeBytes(request_to_server + '\n');
            
                message_to_user = inFromServer.readLine();
                System.out.println("Sent from server: " + message_to_user);
                clientSocket.close(); 

            } catch (SocketException e) {
                e.printStackTrace();
                System.out.println("socket error, server may be disconnected: ");
                break;
            }
        }
    } 
}