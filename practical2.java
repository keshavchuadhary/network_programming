//WAP that lists all the network interfaces of your machine ( i.e localhost ).
import java.net.*;
import java.util.Enumeration;

public class practical2 {
    public static void main(String[] args) {
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface network = interfaces.nextElement();
                System.out.println("Interface Name: " + network.getName());
                System.out.println("Display Name: " + network.getDisplayName());

                // Get all IP addresses associated with this interface
                Enumeration<InetAddress> addresses = network.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();
                    System.out.println("IP Address: " + ip.getHostAddress());
                }
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}