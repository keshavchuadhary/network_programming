import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class client {
        public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                System.out.print("Enter response: ");
                str = reader.readLine();
                dout.writeUTF(str);
                dout.flush();
                if (str.equals("stop")) break;
                
                System.out.println("Waiting for server reply...");
                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }

            din.close();
            dout.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
