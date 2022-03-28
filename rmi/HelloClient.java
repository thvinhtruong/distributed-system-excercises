import java.rmi.*;

class HelloClient {
    public static void main (String[] args) {
        HelloInterface hello;
        String name = "rmi://localhost/HelloServer";
        try {
            hello = (HelloInterface)Naming.lookup(name);
            System.out.println(hello.say());
        }
        catch (Exception e) {
            System.out.println("HelloClient exception: " + e);
        }
    }
}