import java.io.*;
import java.net.*;

public class clientUDP {


    public static void main(String[] args){ 
        String request_to_server = "";
        String message_to_user = "";
        while (!request_to_server.equals("quit")) {
            try {
                // input from user
                System.out.print("Input from client: ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                request_to_server = inFromUser.readLine();

                byte[] buf = new byte[1024];
                DatagramSocket socketServer = new DatagramSocket();
                InetAddress address = InetAddress.getByName("localhost");
                buf = request_to_server.getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8000);

                socketServer.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socketServer.receive(packet);
                message_to_user = new String(packet.getData(), 0, packet.getLength());

                System.out.println("Sent from server: " + message_to_user);
                socketServer.close();
                
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
