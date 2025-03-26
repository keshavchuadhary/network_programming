import java.net.*;

public class pratical5 {

    public static void main(String[] args) {
        // Test IP addresses
        String[] ipAddresses = {
            "127.0.0.1",    // IPv4 loopback address
            "::1"           // IPv6 loopback address
        };

        for (String ipAddress : ipAddresses) {
            checkIpCharacteristics(ipAddress);
        }
    }

    public static void checkIpCharacteristics(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            
            // Checking if the given address is a loopback address
            if (address.isLoopbackAddress()) {
                System.out.println(ipAddress + " is a loopback address.");
            } else {
                System.out.println(ipAddress + " is not a loopback address.");
            }
            
            // Check if it's IPv4 or IPv6
            if (address instanceof Inet4Address) {
                System.out.println(ipAddress + " is an IPv4 address.");
                
                // Check if it is a private IPv4 address
                if (ipAddress.startsWith("10.") || ipAddress.startsWith("172.") || ipAddress.startsWith("192.")) {
                    System.out.println(ipAddress + " is a private IPv4 address.");
                } else {
                    System.out.println(ipAddress + " is a public IPv4 address.");
                }
            } else if (address instanceof Inet6Address) {
                System.out.println(ipAddress + " is an IPv6 address.");
                
                // Check if it is a loopback address in IPv6
                if (address.isLoopbackAddress()) {
                    System.out.println(ipAddress + " is a loopback address in IPv6.");
                }

                // Check if it's a global IPv6 address
                Inet6Address inet6Address = (Inet6Address) address;
                if (inet6Address.isLinkLocalAddress()) {
                    System.out.println(ipAddress + " is a link-local IPv6 address.");
                } else if (inet6Address.isSiteLocalAddress()) {
                    System.out.println(ipAddress + " is a site-local IPv6 address.");
                } else {
                    System.out.println(ipAddress + " is a global IPv6 address.");
                }
            }

            System.out.println("-----------------------------");
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + ipAddress);
        }
    }
}