import java.io.Serializable;

public final class EchoRequest implements Serializable {
    public final String message;
    public EchoRequest(String message) {
        this.message = message;
    }
}
