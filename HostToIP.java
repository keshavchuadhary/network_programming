import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostToIP {
     public static void main(String[] args) {
        String hostname = "www.google.com"; // Replace with your target host

        try {
            InetAddress inetAddress = InetAddress.getByName(hostname);
            String ip = inetAddress.getHostAddress();
            System.out.println("IP Address of " + hostname + ": " + ip);
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve host: " + hostname);
            e.printStackTrace();
        }
    }
}