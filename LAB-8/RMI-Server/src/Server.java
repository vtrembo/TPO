import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public final class Server {

    public static void main(String... args) {
        try {
            LocateRegistry.createRegistry(1099);
            RemoteObject obj = new RemoteObject();
            Naming.bind("echo", obj);
            Naming.bind("addition", obj);
            System.out.println("Server has started");
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
    }
}