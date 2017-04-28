package lab_2.exercise_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class ServerThread implements Runnable {
    private Socket client;
    private Reservations reservations;

    ServerThread(Socket client, Reservations reservations) {
        this.client = client;
        this.reservations = reservations;
    }

    public void run() {
        try {
            /* Get data from user, to get its UID */
            Scanner inFromClient = new Scanner(client.getInputStream());

            /* Try to reserve */
            Thread.sleep(100); // Get the 
            String client_id = inFromClient.nextLine().trim();
            System.out.println("Serving client " + client_id);
            int reservation_number = reservations.book(client_id);

            /*
            Return the reservation number to the client
            or an error message
            */
            DataOutputStream outToClient = new DataOutputStream(
                client.getOutputStream()
            );
            String messageForClient =
                reservation_number != 0
                ? "The client " + client_id +
                  " has reserved the place " + reservation_number
                : "The client was not able to reserve a place, " +
                  "as there are no spots";
            System.out.println(messageForClient);
            outToClient.writeBytes(messageForClient + "\n");

            /* Close variables */
            inFromClient.close();
            outToClient.close();
            client.close();
        } catch (IOException ioe) {
            System.out.println("Client "
                + client.getInetAddress() + " : " + client.getPort()
                + ", retry, you'll be luckier!");
            System.out.println(ioe.getMessage());
        } catch (InterruptedException ie ) {
            this.run();
        }
    }
}