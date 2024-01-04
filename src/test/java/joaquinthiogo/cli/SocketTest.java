package joaquinthiogo.cli;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class SocketTest {
    @Test
    void clientTest() throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        System.out.println("connected");
    }
}
