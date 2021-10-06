import java.io.Serializable;
import java.math.BigInteger;

public final class AddResponse implements Serializable {
    private static BigInteger sum(BigInteger parameter1, BigInteger parameter2) {
        if (parameter1 != null && parameter2 != null) {
            return parameter1.add(parameter2);
        }
        if (parameter1 != null) {
            return parameter1;
        }
        if (parameter2 != null) {
            return parameter2;
        }
        return null;
    }
    public final BigInteger sum;
    public AddResponse(BigInteger parameter1, BigInteger parameter2) { sum = sum(parameter1, parameter2);}
}
