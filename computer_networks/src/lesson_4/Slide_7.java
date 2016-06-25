package lesson_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Resolving the IP address of a certain online resource.
 */
class Slide_7 {
	public static void main(String[] args){
		// The URL to resolve
		String url =  "giovannisantini.tk";
		
		// Try to actually resolve the url
		try {
			System.out.println("Cerco di risolvere l'URL " + url + " ...");
			InetAddress address = InetAddress.getByName(url);
			byte[] ipAddress = address.getAddress();
			System.out.println("L'indirizzo IP di " + url + " e' " +
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