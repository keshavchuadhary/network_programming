import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) {
        String filename = "abc.jpg";
        String serverAddress = "localhost"; // Change to your server IP or hostname
        int port = 12345; // Change to the correct port

        try (Socket socket = new Socket(serverAddress, port);
             FileInputStream fileInputStream = new FileInputStream(filename);
             OutputStream outputStream = socket.getOutputStream()) {

            // Read file and write to output stream
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
