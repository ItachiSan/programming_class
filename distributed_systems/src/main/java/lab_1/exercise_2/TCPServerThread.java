package lab_1.exercise_2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


class TCPServerThread implements Runnable {
    private Socket socket;

    TCPServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() throws RuntimeException {
        /* Creazione delle variabili */
        int a = -1, b = -1, result = -1;
        String operator = "";

        /* Inizializza lo stream di input dalla socket */
        BufferedReader inFromClient = null;
        while (inFromClient == null) {
            try {
                inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException ioe) {
                System.out.println("Exception while getting socket input stream");
                inFromClient = null;
            }
        }

        /* Inizializza lo stream di output verso la socket */
        DataOutputStream outToClient = null;
        while (outToClient == null) {
            try {
                outToClient = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ioe) {
                System.out.println("Exception while getting socket input stream");
                outToClient = null;
            }
        }

        System.out.println("Asking for 1st integer to client " + socket.getInetAddress() + " " + socket.getPort());
        /* Legge due interi dal client */
        while (a == -1) {
            boolean hadAnError = false;
            try {
                if (hadAnError)
                    outToClient.writeBytes("An error happened while reading the first number. Enter it again: ");
                else
                    outToClient.writeBytes("Please enter the first number: ");
                a = Integer.parseInt(inFromClient.readLine());
                outToClient.writeBytes("OK\n");
            } catch (IOException ioe) {
                System.out.println("Error detecting the first integer");
            }
        }

        System.out.println("Asking for 2nd integer to client " + socket.getInetAddress() + " " + socket.getPort());
        while (b == -1) {
            boolean hadAnError = false;
            try {
                if (hadAnError)
                    outToClient.writeBytes("An error happened while reading the second number. Please enter it again: ");
                else
                    outToClient.writeBytes("Please enter the second number: ");
                b = Integer.parseInt(inFromClient.readLine());
                outToClient.writeBytes("OK\n");
            } catch (IOException ioe) {
                System.out.println("Error detecting the second integer");
            }
        }

        System.out.println("Asking for operator to client " + socket.getInetAddress() + " " + socket.getPort());
        while (operator.equals("")) {
            boolean hadAnError = false;
            try {
                if (hadAnError)
                    outToClient.writeBytes("An error happened while reading the operation. Please enter it again");
                else
                    outToClient.writeBytes("Please enter the operator: ");
                operator = inFromClient.readLine();
                if (operator.length() != 1)
                    operator = "";
                else {
                    outToClient.writeBytes("OK\n");
                    switch (operator) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                        default:
                            operator = "";
                    }
                }
            } catch (IOException ioe) {
                System.out.println("Error detecting the operation");
            }
        }

        /* Invia la risposta al client */
        boolean replySent = false;
        while (!replySent) {
            try {
                outToClient.writeBytes(result + "\n");
                replySent = true;
            } catch (IOException e) {
                System.out.println("Error sending the reply, resending...");
            }
        }

        /* Cliente servito! Chiudo il socket */
        while (!socket.isClosed()) {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Error closing the socket, trying again...");
            }
        }
    }

}