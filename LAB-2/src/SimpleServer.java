import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;



public class SimpleServer {
    private static Protocol protocol = new Protocol();
    public SimpleServer(){}

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        Selector selector = Selector.open();
        serverSocket.bind(new InetSocketAddress("localhost", 1234));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(512);
        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) { configure(selector, serverSocket); }
                if (key.isReadable()) {
                    try {
                        answerWithEcho(buffer, key);
                    }catch (IOException e) {
                    }
                }
                iterator.remove();
                buffer = ByteBuffer.allocate(512);
            }
        }
    }

    private static void answerWithEcho(ByteBuffer buffer, SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        client.read(buffer);
        System.out.println(new String(buffer.array()));
        String response = protocol.handleRequest(buffer);
        buffer.flip();
        client.write(ByteBuffer.wrap(response.getBytes()));
        buffer.clear();
    }
    private static void configure(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel client = serverSocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

}
