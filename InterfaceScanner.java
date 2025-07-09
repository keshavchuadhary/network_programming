import java.net.*;
import java.util.Enumeration;

public class InterfaceScanner {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            
            System.out.println("\nInterface: " + ni.getName());
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                System.out.println("- " + addr.getHostAddress() + 
                                 " (" + (addr instanceof Inet4Address ? "IPv4" : "IPv6") + ")");
            }
        }
    }
}