import java.rmi.*;

public interface Add extends Remote {
    String say() throws RemoteException;
    int add(int a, int b) throws RemoteException;
}
