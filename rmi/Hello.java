import java.rmi.*;
import java.rmi.server.*;

public class Hello extends UnicastRemoteObject implements HelloInterface {

    private String message; // Strings are serializable

    public Hello (String msg) throws RemoteException {
        message = msg;
    }

    public String say() throws RemoteException {
        return message;
    }

    public int fibbonancci(int a) throws RemoteException {
        if (a == 0) {
            return 0;
        } else if (a == 1) {
            return 1;
        } else {
            return fibbonancci(a - 1) + fibbonancci(a - 2);
        }
    }
}
