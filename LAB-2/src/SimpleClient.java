import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;



public class SimpleClient {
    private static Protocol protocol;
    private static SocketChannel simpleClient;
    private static ByteBuffer buffer;


    public static void main(String[] args) throws Exception {
        new SimpleClient();
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter ECHO or ADD command:");
            String input = scanner.nextLine();

            if(protocol.validateInput(input) == 1){
                System.out.println(sendMessage(input));

            }else {
                System.out.println("Invalid request");
                continue;
            }
        }
    }
    public static String sendMessage(String message) {
        buffer = ByteBuffer.wrap(message.getBytes());
        String response = null;
        try {
            simpleClient.write(buffer);
            buffer.clear();
            buffer = ByteBuffer.allocate(512);
            simpleClient.read(buffer);
            response = new String(buffer.array());
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    private SimpleClient() {
        try {
            protocol = new Protocol();
            simpleClient = SocketChannel.open(new InetSocketAddress("localhost", 1234));
            buffer = ByteBuffer.allocate(512);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}