package lab_2.exercise_1;

import java.net.Socket;
import java.net.ServerSocket;

public class Server {
    private static Reservations reservations;

    /* Gestirò le eccezioni bene poi */
    public static void main(String[] args) throws Exception {
        /* Creo il socket per ricevere i clienti */
        ServerSocket client_queue = new ServerSocket(
            Integer.parseInt(args[0])
        );
        /* Imposto il numero di biglietti */
        reservations = new Reservations(
            Integer.parseInt(args[1])
        );

        while (true) {
            Socket client = client_queue.accept();
            Thread customer_care = new Thread(
                new ServerThread (
                    client, reservations
                )
            );
            customer_care.start();
        }
    }

}