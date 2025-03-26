import java.net.*;

public class networking {

    public static void main(String[] args) throws UnknownHostException {
     InetAddress obj1 = InetAddress.getByName("mywebsite.com");
     InetAddress obj2 = InetAddress.getByName("www.mywebsite**.com");
     boolean x = obj1.equals(obj2);
     System.out.println(x);   
    }
}
