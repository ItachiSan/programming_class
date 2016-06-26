package lesson_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/*
Same of client/server of lesson 4, slide 21, but here using UDP instead of TCP.
 */

class Slide_10_server {
    public static void main(String[] args){
        // The sockets needed by the server
        DatagramSocket serverSocket;

        // Attempt of reverse server
        try {
            serverSocket = new DatagramSocket();
            System.out.println("server: starting with address " +
                    serverSocket.getLocalAddress() +
                    " port " +
                    serverSocket.getLocalPort());
            // Easy case...
            //Thread.sleep(125 * 1000);
            // Pro case...!
            // Set up needed variables
            byte[] message = new byte[1024];
            String messageString, reply;
            boolean closed = false;
            // While we don't send our close message to the server...
            while(!closed) {
                // Read the client message
                DatagramPacket clientMessage = new DatagramPacket(
                        message, 1024
                );
                serverSocket.receive(clientMessage);
                messageString = new String(message, 0, clientMessage.getLength());
                // Reverse the string!
                if (messageString.equals("bye")) {
                    reply = "bye";
                    closed = true;
                }
                else
                    reply = new StringBuilder(messageString).reverse().toString();
                System.out.println("server: client sent '" +
                        messageString + "', we send back '" +
                        reply + "'");
                // Send back the result sentence
                DatagramPacket replyPacket = new DatagramPacket(
                        reply.getBytes(), 0, reply.length()
                );
                replyPacket.setSocketAddress(
                        clientMessage.getSocketAddress()
                );
                serverSocket.send(replyPacket);
            }
            System.out.println("server: shut down...");
            serverSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Slide_10_client {
    public static void main(String[] args){
        // The server IP.
        InetAddress serverAddress;
        // The server socket address.
        InetSocketAddress serverSocketAddress;
        // The socket used by the client.
        DatagramSocket clientSocket;
        // Ask for the port
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // Ask for the port
        System.out.print("client: server port number: ");

        // Try to actually connect to the server
        try {
            // Get the server address (in this case, localhost)
            serverAddress = InetAddress.getLocalHost();
            // Create a socket for the client.
            clientSocket = new DatagramSocket();
            // Create a socket address to the server, get the port from user input
            serverSocketAddress = new InetSocketAddress(
                    serverAddress,
                    Integer.parseInt(bufferedReader.readLine())
            );
            // Start the connection
            System.out.println("client: connecting with port " +
                    clientSocket.getLocalPort());
            System.out.println("client: sending messages to server with " +
                    "address " +
                    serverSocketAddress.getAddress() +
                    " and port " +
                    serverSocketAddress.getPort());
            // Easy case...
            //Thread.sleep(120 * 1000);

            // Pro case!
            byte[] message = new byte[1024];
            String input, serverReply;
            boolean closed = false;
            // While we don't send our close message to the server...
            while(!closed) {
                // Send the sentence to the server
                System.out.print("client: type a sentence to send: ");
                input = bufferedReader.readLine();
                DatagramPacket packet = new DatagramPacket(
                        input.getBytes(), 0, input.length()
                );
                // Build the packet and send it
                packet.setSocketAddress(serverSocketAddress);
                clientSocket.send(packet);
                // Receive the reply from the server
                DatagramPacket reply = new DatagramPacket(message, 1024);
                clientSocket.receive(reply);
                serverReply = new String(message, 0, reply.getLength());
                if (serverReply.equals("bye"))
                    closed = true;
                else
                    System.out.println("client: server returned us '" + serverReply + "'");
            }
            System.out.println("client: shut down...");
            clientSocket.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}