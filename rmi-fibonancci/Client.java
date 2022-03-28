import java.rmi.*;
import java.io.*;
import java.net.*;
import java.lang.NumberFormatException;

class Client {
    public static void main (String[] args) {
        String request_to_server = "";
        Fibonancci fibo;
        String name = "rmi://localhost/HelloServer";
        while (!request_to_server.equals("quit")) {
            try {
                System.out.print("Input length of fibbonancci: ");
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                request_to_server = inFromUser.readLine();
                fibo = (Fibonancci)Naming.lookup(name);
                for (int i=0; i<Integer.parseInt(request_to_server); i++){
                    System.out.println(hello.fibbonancci(i));   
                }
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