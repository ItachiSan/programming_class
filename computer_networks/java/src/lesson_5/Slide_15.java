package lesson_5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/*
The usual TCP and UDP server, but multithreaded!
 */


class Slide_15_server_TCP {
    /*
    The thread used to reverse the strings
     */
    private static class ReverseString implements Runnable {
        // Socket to handle the client.
        Socket client;
        // Set to true when running.
        boolean running;

        ReverseString(Socket clientSocket){
            // The client served by this thread
            client = clientSocket;
            running = true;
        }

        public void run(){
            // Attempt of reverse server
            try {
                byte[] message = new byte[1024];
                int messageLength;
                String messageString, reply;
                InputStream clientOut = client.getInputStream();
                OutputStream clientIn = client.getOutputStream();
                // While we don't send our close message to the server...
                while(running) {
                    // Read the client message
                    messageLength = clientOut.read(message);
                    messageString = new String(message, 0, messageLength);
                    // Reverse the string!
                    if (messageString.equals("bye")) {
                        reply = "bye";
                        running = false;
                    }
                    else
                        reply = new StringBuilder(messageString).reverse().toString();
                    System.out.println("server: client " +
                            client.getRemoteSocketAddress() +
                            " sent '" +
                            messageString + "', we send back '" +
                            reply + "'");
                    // Send back the result sentence
                    clientIn.write(reply.getBytes(), 0, reply.length());
                }
                System.out.println("server thread for "
                        + client.getRemoteSocketAddress()
                        +" :shut down...");
                client.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Actually, use the server
    public static void main(String[] args){
        // The sockets needed by the server
        ServerSocket serverSocket;
        Socket clientSocket;
        // Thread pool, used to keep the threads used for handling connections with the clients
        // Allow up to 1024 clients!
        ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(1024);

        // Attempt of reverse server
        try {
            serverSocket = new ServerSocket(0);
            System.out.println("server: starting with address " +
                    serverSocket.getInetAddress() +
                    " port " +
                    serverSocket.getLocalPort());
            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("server: client connected with address " +
                        clientSocket.getInetAddress() +
                        " and port " +
                        clientSocket.getPort());
                threadPool.execute(new ReverseString(clientSocket));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Slide_15_client {
    public static void main(String[] args){
        // The server IP.
        InetAddress serverAddress;
        // The socket address used to keep the connection with the server.
        InetSocketAddress serverSocketAddress;
        // The socket used by the client.
        Socket clientSocket = new Socket();
        // Ask for the port
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // Ask for the port
        System.out.print("client: server port number: ");

        // Try to actually connect to the server
        try {
            // Get the host (in this case, localhost)
            serverAddress = InetAddress.getLocalHost();
            // Create a socket address to the server, get the port from user input
            serverSocketAddress = new InetSocketAddress(serverAddress,
                    Integer.parseInt(bufferedReader.readLine()));
            // Start the connection
            clientSocket.connect(serverSocketAddress);
            System.out.println("client: connecting with port " +
                    clientSocket.getLocalPort());
            System.out.println("client: connected to server with address " +
                    clientSocket.getInetAddress() +
                    " and port " +
                    clientSocket.getPort());
            // Easy case...
            //Thread.sleep(120 * 1000);

            // Pro case!
            byte[] message = new byte[1024];
            int messageLength;
            String input, serverReply;
            boolean closed = false;
            OutputStream serverIn = clientSocket.getOutputStream();
            InputStream serverOut = clientSocket.getInputStream();
            // While we don't send our close message to the server...
            while(!closed) {
                // Send the sentence to the server
                System.out.print("client: type a sentence to send: ");
                input = bufferedReader.readLine();
                serverIn.write(input.getBytes(), 0, input.length());
                messageLength = serverOut.read(message);
                serverReply = new String(message, 0, messageLength);
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