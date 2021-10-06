import java.io.Serializable;

public final class EchoResponse implements Serializable {
    public final String message;
    public EchoResponse(String message) {
        this.message = message;
    }
}
