package joaquinthiogo.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static Logger log = LoggerFactory.getLogger("cli");
    private static Socket socket;
    private static String line;

    public Server(Integer port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            log.info("Server started");

            log.info("Waiting for client..");

            while (true) {
                socket = serverSocket.accept();
                log.info("Client Accepted");

                ExecutorService executorService = Executors.newFixedThreadPool(10);
                executorService.execute(() -> {
                    try {
                        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        while ((line = bufferedReader.readLine()) != null) {
                            log.info("Message from \"" + socket.getInetAddress().getHostName() + "\" : " + line);
                        }

                    } catch (IOException e) {
                        log.info("{} is exit", socket.getInetAddress().getHostName());
                    }
                });
            }
        } catch (IOException e) {
            log.info("No one client in this room");
        }
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
    }

}
