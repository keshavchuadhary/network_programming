import java.net.*;

public class Practical4 {

    // Method to determine if the IP address is IPv4 or IPv6
    public static String checkIPAddressType(String ipAddress) {
        try {
            // Try to parse the IP address using InetAddress
            InetAddress address = InetAddress.getByName(ipAddress);

            if (address instanceof Inet4Address) {
                return "IPv4";
            } else if (address instanceof Inet6Address) {
                return "IPv6";
            }
        } catch (UnknownHostException e) {
            return "Invalid IP Address";
        }

        return "Unknown Type";
    }

    public static void main(String[] args) {
        // Check if an IP address is provided as an argument
        if (args.length != 1) {
            System.out.println("Please provide an IP address as a command-line argument.");
            return;
        }

        String ipAddress = args[0];
        String result = checkIPAddressType(ipAddress);
        System.out.println("The IP address " + ipAddress + " is " + result);
    }
}
