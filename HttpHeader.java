import java.net.*;
import java.io.*;
import java.util.*;

public class HttpHeader {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://sagarmatha.edu.np/wp-content/uploads/2024/07/IMG_9116-scaled-e1722396795347.jpg");
            URL u = uri.toURL();
            
            // Open connection
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            
            // Print the request method, response code, message, etc.
            System.out.println("Request Method: " + con.getRequestMethod());
            System.out.println("Response Code: " + con.getResponseCode());
            System.out.println("Response Message: " + con.getResponseMessage());
            System.out.println("Content Type: " + con.getContentType());
            System.out.println("Content Length: " + con.getContentLength());
            System.out.println("Date: " + new Date(con.getDate()));  
            System.out.println("Last Modified: " + new Date(con.getLastModified()));  
        } catch (IOException | URISyntaxException ex) {
            System.err.println("Error: " + ex);
        }
    }
}
