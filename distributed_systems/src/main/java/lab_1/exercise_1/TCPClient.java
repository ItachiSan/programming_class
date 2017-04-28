package lab_1.exercise_1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        int a, b, sum;

        /* Inizializza l’input stream (da tastiera) */
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /* Inizializza una socket client, connessa al server */
        Socket clientSocket = new Socket(args[0], Integer.parseInt(args[1]));

        /* Inizializza lo stream di output verso la socket */
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer =
        new BufferedReader(new
        InputStreamReader(clientSocket.getInputStream()));

        /* Legge due interi da tastiera */
        System.out.print("ENTER FIRST INTEGER:  ");
        a = Integer.parseInt(inFromUser.readLine());
        System.out.print("ENTER SECOND INTEGER: ");
        b = Integer.parseInt(inFromUser.readLine());

        /* Invia i due interi al server */
        outToServer.writeBytes(a + "\n");
        outToServer.writeBytes(b + "\n");

        /* Legge la risposta inviata dal server (linea terminata da \n) */
        sum = Integer.parseInt(inFromServer.readLine());

        System.out.println("SUM FROM SERVER: " + sum);
        clientSocket.close();
    }

}