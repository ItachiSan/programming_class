package lab_1.exercise_1bis;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        int a, b, sum;
        byte[] receiveData, sendData;
        DatagramPacket receivePacket, sendPacket;

        /* Crea una "listening socket" sulla porta specificata */
        DatagramSocket serverSocket = new DatagramSocket(
            Integer.parseInt(args[0])
        );
        /* Stampa la porta per potersi connettere */
        System.out.println("DATA NEEDED FOR CLIENT CONNECTION ARE\n" +
            "IP:   \t" + serverSocket.getLocalAddress() + "\n" +
            "PORT: \t" + serverSocket.getLocalPort());

        while (true) {
            /* Prepara la struttura dati usata per contenere il pacchetto
            in ricezione.
            E' molto importante ripulire tale buffer...
            In maniera molto banale, reinstanziandolo abbiamo un buffer pulito
            ad ogni "cliente servito"; il garbage collector pulirà la memoria
            per noi.
            */
            receiveData = new byte[4096];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            /* Riceve il primo numero da un client */
            serverSocket.receive(receivePacket);
            /*
            Qui bisogna eseguire la trim(), altrimenti ci sono problemi
            nel parsing del numero... Boh. 
            */
            a = Integer.parseInt(new String(receivePacket.getData()).trim());


            /* Prepara la struttura dati usata per contenere il pacchetto
            in ricezione */
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            /* Riceve il secondo numero da un client */
            serverSocket.receive(receivePacket);
            b = Integer.parseInt(new String(receivePacket.getData()).trim());


            /* Invia la risposta */
            /* Prepara i dati da inviare */
            sum = a + b;
            sendData = new String(sum + "").getBytes();
            /* Stampiamo informazioni sul client */
            System.out.println("SENDING TO CLIENT : " +
                "IP " + receivePacket.getAddress() + " " +
                "PORT " + receivePacket.getPort()
            );
            /* Prepariamo il datagramma da inviare */
            sendPacket = new DatagramPacket(sendData, sendData.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
            );
            /* Inviamo il tutto */
            serverSocket.send(sendPacket);

        }
    }
}