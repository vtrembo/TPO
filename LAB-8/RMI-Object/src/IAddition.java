import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAddition extends Remote {
    AddResponse add(AddRequest request) throws RemoteException;
}
