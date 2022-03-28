import java.rmi.*;
import java.rmi.server.*;

public class AddTemp extends UnicastRemoteObject implements Add {

    private String message; // Strings are serializable

    public AddTemp (String msg) throws RemoteException {
        message = msg;
    }

    public String say() throws RemoteException {
        return message;
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}