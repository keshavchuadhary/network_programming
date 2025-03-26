//WAP to find the IP address and MAC address of your local machine. ( Hint: Use getter or factory method.
import java.net.*;

class pratical1 {
    
    public String getIpAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            return ip.getHostAddress();
        } catch (Exception e) {
            return "IP Address not found!";
        }
    }

    
    public String getMacAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network != null && network.getHardwareAddress() != null) {
                byte[] mac = network.getHardwareAddress();
                StringBuilder macAddress = new StringBuilder();
                for (byte b : mac) {
                    macAddress.append(String.format("%02X:", b));
                }
                return macAddress.substring(0, macAddress.length() - 1);
            } else {
                return "MAC Address not found!";
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

// Main class
public class practical1 {
    public static void main(String[] args) {
      pratical1 network = new pratical1();  // Creating object of NetworkInfo

        // Using getter methods
        System.out.println("Local IP Address of Sameer PC: " + network.getIpAddress());
        System.out.println("MAC Address of Sameer PC: " + network.getMacAddress());
    }
}