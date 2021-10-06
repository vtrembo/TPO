
import java.math.BigInteger;
import java.rmi.Naming;

@SuppressWarnings("deprecation")
public final class Client {
    public static void main(String[] args) {
        try {
            IEcho echo = (IEcho) Naming.lookup("echo");
            EchoRequest echoRequest = new EchoRequest("here we go");
            EchoResponse echoResponse = echo.echo(echoRequest);
            System.out.printf("request: '%s'\nresponse: '%s'\n", echoRequest.message, echoResponse.message);
            IAddition addition = (IAddition) Naming.lookup("addition");
            BigInteger parameter1 = new BigInteger("300000");
            BigInteger parameter2 = new BigInteger("300000");
            AddRequest addRequest = new AddRequest(parameter1, parameter2);
            AddResponse addResponse = addition.add(addRequest);
            System.out.printf("parameter1: '%d', parameter2: '%d'\nsum: '%d'\n", addRequest.parameter1, addRequest.parameter2, addResponse.sum);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
