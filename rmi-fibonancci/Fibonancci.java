import java.rmi.*;

public interface Fibonancci extends Remote {
    String say() throws RemoteException;
    int fibbonancci(int a) throws RemoteException;
}
