import java.net.*;

public class ipAddress {

    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName("127.0.0.1");
            System.out.println("IP Address:" + address.getCanonicalHostName());
            System.out.println("Host Address:" + address.getHostName());
        }catch(UnknownHostException e){
        }
    }
}  