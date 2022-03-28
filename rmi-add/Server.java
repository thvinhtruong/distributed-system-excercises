import java.rmi.*;

class Server {
    public static void main (String[] argv) {
        try {
            Naming.rebind("rmi://localhost/HelloServer", new AddTemp("Hello, world!"));
            System.out.println("Server is ready");
        }
        catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }
}