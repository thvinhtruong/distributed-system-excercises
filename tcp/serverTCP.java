package tcp;
import java.io.*;
import java.net.*;

public class serverTCP extends Thread {
    private ServerSocket serverSocket;
    private String request_from_user;
    private String message_to_user;

    public serverTCP(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(100000);
    }

    public void run() {
        boolean done = false;
        while (!done) {
            try {
                System.out.println("On port " + this.serverSocket.getLocalPort());
                Socket connectionSocket = this.serverSocket.accept();

                // take input from client
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
    
                // processing input from client
                request_from_user = inFromClient.readLine();
                done = request_from_user.equals("quit");
                message_to_user =  request_from_user.toUpperCase() + " (accepted!)" + '\n';
                outToClient.writeBytes(message_to_user); 
                connectionSocket.close();
            } 
            catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]) throws Exception {
        // run by using the command line: "javac serverTCP.java", and then "java serverTCP 8000"
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new serverTCP(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}