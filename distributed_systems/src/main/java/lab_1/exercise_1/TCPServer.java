package lab_1.exercise_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.ServerSocket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        int a, b, sum;
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

            /* Inizializza lo stream di input dalla socket */
            BufferedReader inFromClient =
            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            /* Inizializza lo stream di output verso la socket */
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            /* Legge due interi dal client */
            a = Integer.parseInt(inFromClient.readLine());
            b = Integer.parseInt(inFromClient.readLine());
            sum = a + b;

            /* Invia la risposta al client */
            outToClient.writeBytes(sum + "\n");
            connectionSocket.close();
        }

    }
}