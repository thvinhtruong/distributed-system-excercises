import java.rmi.*;
import java.io.*;
import java.net.*;
import java.lang.NumberFormatException;

class Client {
    public static void main (String[] args) {
        String a = "";
        String b = "";
        Add addition;
        String name = "rmi://localhost/HelloServer";
        while (!request_to_server.equals("quit")) {
            try {
                System.out.print("Input a: ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                a = inFromUser.readLine();
                b = inFromUser.readLine();
                addition = (Add)Naming.lookup(name);
                System.out.println(addition.add(Integer.parseInt(a), Integer.parseInt(b)));
            }
            catch (RemoteException e) {
                System.out.println("RemoteException: " + e.getMessage());
            }
            catch (NotBoundException e) {
                System.out.println("NotBoundException: " + e.getMessage());
            }
            catch (MalformedURLException e) {
                System.out.println("MalformedURLException: " + e.getMessage());
            }
            catch (NumberFormatException e) {
                if (e.getMessage().contains("quit")) {
                    System.out.println("terminate using quit");
                } else {
                    System.out.println("NumberFormatException: " + e.getMessage());
                }
                
            }
            catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }
        }
    }
}