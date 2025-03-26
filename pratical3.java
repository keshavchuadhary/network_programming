import java.net.InetAddress;
import java.net.UnknownHostException;

public class pratical3 {
    public static void main(String[] args) {
        // List of domain names to resolve
        String[] hostnames = {"sagarmatha.edu.np", "www.google.com", "www.facebook.com"};
        
        for (String hostname : hostnames) {
            try {
                // Get the IP address of the given host
                InetAddress address = InetAddress.getByName(hostname);
                System.out.println("IP Address of " + hostname + ": " + address.getHostAddress());
            } catch (UnknownHostException e) {
                System.out.println("Unable to resolve hostname: " + hostname);
            }
        }
    } }