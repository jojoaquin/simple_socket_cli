package joaquinthiogo.cli;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("joaquin", 8080);

        Scanner scanner = new Scanner(System.in);

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        while (true) {
            System.out.print("Enter the chat ('x' for exit): ");
            String value = scanner.nextLine();

            if (!value.equals("x")) {
                printWriter.println(value);
                printWriter.flush();
            } else {
                break;
            }
        }
    }
}
