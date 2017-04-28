package lab_1.exercise_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws Exception {
        int a, b, result;
        String operator, reply = "";

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
        Thread.sleep(100);
        while (!reply.equals("OK")) {
            while (inFromServer.ready())
                System.out.print((char) inFromServer.read());
            a = Integer.parseInt(inFromUser.readLine());
            outToServer.writeBytes(a + "\n");
            while (!inFromServer.ready());
            reply = inFromServer.readLine();
        }

        Thread.sleep(100);
        reply = "";
        while (!reply.equals("OK")) {
            while (inFromServer.ready())
                System.out.print((char )inFromServer.read());
            b = Integer.parseInt(inFromUser.readLine());
            outToServer.writeBytes(b + "\n");
            reply = inFromServer.readLine();
        }

        Thread.sleep(100);
        reply = "";
        while (!reply.equals("OK")) {
            while (inFromServer.ready())
                System.out.print((char) inFromServer.read());
            operator = inFromUser.readLine();
            outToServer.writeBytes(operator + "\n");
            reply = inFromServer.readLine();
        }

        /* Legge la risposta inviata dal server (linea terminata da \n) */
        result = Integer.parseInt(inFromServer.readLine());

        System.out.println("Result from server: " + result);
        clientSocket.close();
    }

}