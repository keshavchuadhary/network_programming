import java.io.*;
import java.net.*;

public class socket {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(8080);
            System.out.println("Server started. Waiting for client...");
            Socket s = ss.accept();
            System.out.println("Client connected.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                System.out.println("Waiting for client to reply...");
                str = din.readUTF();
                System.out.println("Client: " + str);
                if (str.equals("stop")) break;
                
                System.out.print("Enter message: ");
                str2 = reader.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }

            din.close();
            dout.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
