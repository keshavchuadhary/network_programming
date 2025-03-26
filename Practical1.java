import java.net.*;
import java.util.Enumeration;

class NetworkInfo {
    
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
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            while (networks.hasMoreElements()) {
                NetworkInterface network = networks.nextElement();
                byte[] mac = network.getHardwareAddress();
                
                if (mac != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (byte b : mac) {
                        macAddress.append(String.format("%02X:", b));
                    }
                    return macAddress.substring(0, macAddress.length() - 1);
                }
            }
            return "MAC Address not found!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}

// Main class
public class Practical1 {
    public static void main(String[] args) {
        NetworkInfo network = new NetworkInfo();  

        System.out.println("Local IP Address: " + network.getIpAddress());
        System.out.println("MAC Address: " + network.getMacAddress());
    }
}
