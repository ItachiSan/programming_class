package lab_1.exercise_1bis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        int a, b, sum;
        byte[] sendData, receiveData = new byte[1024];
        DatagramPacket sendPacket, receivePacket;

        /* Inizializza l’input stream (da tastiera) */
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        /* Inizializza una socket client, connessa al server */
        InetAddress IPAddress = InetAddress.getByName(args[0]);
        int port = Integer.parseInt(args[1]);
        DatagramSocket clientSocket = new DatagramSocket();

        /* Legge due interi da tastiera */
        System.out.print("ENTER FIRST INTEGER:  ");
        a = Integer.parseInt(inFromUser.readLine());
        System.out.print("ENTER SECOND INTEGER: ");
        b = Integer.parseInt(inFromUser.readLine());

        /* Inviamo A... */
        /* Prepara il pacchetto da spedire specificando
        * contenuto, indirizzo e porta del server */
        sendData = new String(a + "").getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        /* Invia il pacchetto attraverso la socket */
        clientSocket.send(sendPacket);

        /* Idem per B */
        /* Prepara il pacchetto da spedire specificando
        * contenuto, indirizzo e porta del server */
        sendData = new String(b + "").getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
        /* Invia il pacchetto attraverso la socket */
        clientSocket.send(sendPacket);

        /* Prepara la struttura dati usata per contenere il pacchetto in ricezione */
        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        /* Riceve il pacchetto dal server */
        clientSocket.receive(receivePacket);

        /* Legge la risposta inviata dal server (linea terminata da \n) */
        sum = Integer.parseInt(new String(receivePacket.getData()).trim());

        System.out.println("SUM FROM SERVER: " + sum);
        clientSocket.close();
    }

}