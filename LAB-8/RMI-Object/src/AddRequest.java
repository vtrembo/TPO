import java.io.Serializable;
import java.math.BigInteger;

public final class AddRequest implements Serializable {
    public final BigInteger parameter1;
    public final BigInteger parameter2;

    public AddRequest(BigInteger parameter1, BigInteger parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }
}
