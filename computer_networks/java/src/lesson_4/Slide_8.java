package lesson_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Solving local host IP.
 */
class Slide_8_es1 {
    public static void main(String[] args){
        // We try to work on localhost
        try {
            System.out.println("Cerco di risolvere l'IP locale...");
            InetAddress address = InetAddress.getLocalHost();
            byte[] ipAddress = address.getAddress();
            System.out.println("L'indirizzo IP locale e' " +
                    (ipAddress[0] & 0xff) + "." +
                    (ipAddress[1] & 0xff) + "." +
                    (ipAddress[2] & 0xff) + "." +
                    (ipAddress[3] & 0xff));
        }
        catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
    }
}

/**
 * Resolving IP addresses for domain names with multiple names.
 */
class Slide_8_es2 {
    public static void main(String[] args){
        // The URL to resolve
        String url =  "www.google.com";

        // Try to actually resolve the url
        try {
            System.out.println("Cerco di risolvere l'URL " + url + " ...");
            InetAddress[] addresses = InetAddress.getAllByName(url);
            for (InetAddress address: addresses) {
                byte[] ipAddress = address.getAddress();
                System.out.println("L'indirizzo IP di " + url + " e' " +
                        (ipAddress[0] & 0xff) + "." +
                        (ipAddress[1] & 0xff)  + "." +
                        (ipAddress[2] & 0xff) + "." +
                        (ipAddress[3] & 0xff));
            }
        }
        catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
    }
}