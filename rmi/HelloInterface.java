import java.rmi.*;

public interface HelloInterface extends Remote {
    String say() throws RemoteException;
    int fibbonancci(int a) throws RemoteException;
}
