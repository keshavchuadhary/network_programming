import java.io.*;
import java.net.*;

public class Samir {
    public static void main(String[] args) {

connectToServer("Samir");
}

private static void connectToServer(String clientName) {
    String serverAddress = "127.16.29.76";
    int port = 9000;

    try {
        Socket socket = new Socket(serverAddress, port);
        System.out.println(clientName + " connected to server");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Server: " + input.readLine());

        String message;
        while (true) {
            System.out.print(clientName + ": ");
            message = userInput.readLine();
            output.println(message);

            System.out.println("Server: " + input.readLine());

            if (message.equalsIgnoreCase("stop")) {
                break;
            }
        }

        socket.close();
        input.close();
        output.close();
        userInput.close();
        System.out.println(clientName + " disconnected");

    } catch (IOException e) {
        System.out.println(clientName + " Error: " + e.getMessage());
    }
}
}
