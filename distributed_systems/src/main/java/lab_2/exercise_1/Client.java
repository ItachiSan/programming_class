package lab_2.exercise_1;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws Exception {
        /* Get the information about the server */
        Socket server = new Socket(args[0],
            Integer.parseInt(args[1])
        );

        /* Set up input/output channels of the server */
        Scanner inFromServer = new Scanner(server.getInputStream());
        DataOutputStream outToServer = new DataOutputStream(
            server.getOutputStream()
        );

        /*
        Send our ID to the server.
        For now it is a random UUID
        */
        UUID myUUID = UUID.randomUUID();
        outToServer.writeBytes(myUUID.toString() + "\n");

        /* Let's fetch the server reply! */
        Thread.sleep(100);
        System.out.println(inFromServer.nextLine().trim());
 
        /* Close data channels */
        outToServer.close();
        inFromServer.close();
        server.close();
   }
}