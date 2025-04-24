package Uebung5;

import java.io.*;
import java.net.*;
import java.util.*;

public class PrintServer {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server gestartet auf Port 12345");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            clientSockets.add(clientSocket);
            System.out.println("Neuer Client verbunden: " + clientSocket);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message = in.readLine();

            if (message != null) {
                System.out.println("Empfangen: " + message);

                for (Socket socket : clientSockets) {
                    if (!socket.equals(clientSocket)) {
                        try {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println("Broadcast: " + message);
                        } catch (IOException e) {
                            System.out.println("Fehler beim Senden an " + socket);
                        }
                    }
                }
            }
        }
    }
}
