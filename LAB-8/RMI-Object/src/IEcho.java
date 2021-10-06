import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEcho extends Remote {
    EchoResponse echo(EchoRequest request) throws RemoteException;
        Message echo(Message message) throws RemoteException;
}