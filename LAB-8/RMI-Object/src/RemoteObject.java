import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public final class RemoteObject extends UnicastRemoteObject implements  IEcho, IAddition {
    public RemoteObject() throws RemoteException { }

    public Message echo(Message message) throws RemoteException {
        return message;
    }
    @Override
    public EchoResponse echo(EchoRequest request) throws RemoteException {
        return new EchoResponse(request.message);
    }

    @Override
    public AddResponse add(AddRequest request) throws RemoteException {
        return new AddResponse(request.parameter1, request.parameter2);
    }
}
