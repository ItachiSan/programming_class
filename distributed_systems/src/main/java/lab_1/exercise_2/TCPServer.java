package lab_1.exercise_2;

import java.net.Socket;
import java.net.ServerSocket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        /* Crea una "listening socket" sulla porta specificata */
        ServerSocket welcomeSocket = new ServerSocket(
            Integer.parseInt(args[0])
        );
        /* Stampa la porta per potersi connettere */
        System.out.println("DATA NEEDED FOR CLIENT CONNECTION ARE\n" +
            "IP:   \t" + welcomeSocket.getInetAddress() + "\n" +
            "PORT: \t" + welcomeSocket.getLocalPort()
        );

        while (true) {
            /*
            * Viene chiamata accept (bloccante).
            * All’arrivo di una nuova connessione crea una nuova
            * "established socket"
            */
            Socket connectionSocket = welcomeSocket.accept();
            System.out.println("CLIENT CONNECTED: " +
                "IP " + connectionSocket.getInetAddress() + " " +
                "PORT " + connectionSocket.getPort()
            );

            /* Passa il cliente al thread desiderato */
            Thread customerCare = new Thread(
                new TCPServerThread(connectionSocket)
            );
            customerCare.start();
            System.out.println("Waiting for next client...");
        }

    }
}