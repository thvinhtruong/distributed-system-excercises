package udp;
import java.io.*;
import java.net.*;

public class serverUDP extends Thread {
    private DatagramSocket socketServer;
    private String message_from_user;
    private byte[] buf = new byte[256];

    public serverUDP(int port) throws SocketException {
        socketServer = new DatagramSocket(8000);
        socketServer.setSoTimeout(100000);
    }

    public void run() {
        boolean running = false;
        while (!running) {
            try {
                System.out.println("on port " + socketServer.getPort());
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socketServer.receive(packet);
                
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                message_from_user = new String(packet.getData(), 0, packet.getLength());
                running = message_from_user.equals("quit");
                socketServer.send(packet);
            } 
            catch (SocketException e) {
                e.printStackTrace();
                break;
            }
            catch (SocketTimeoutException e) {
                System.out.println("server time out: " + e);
                break;
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        socketServer.close();
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new serverUDP(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
