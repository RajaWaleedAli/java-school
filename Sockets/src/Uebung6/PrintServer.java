package Uebung6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrintServer {
    private static List<Socket> clientSockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server gestartet auf Port 12345");

        while (true) {
            if (serverSocket.isBound() && !serverSocket.isClosed()) {
                serverSocket.setSoTimeout(100);
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientSockets.add(clientSocket);
                    System.out.println("Neuer Client verbunden: " + clientSocket);
                } catch (SocketTimeoutException e) {
                    // kein neuer Client -> ignorieren
                }
            }
            Iterator<Socket> iterator = clientSockets.iterator();
            while (iterator.hasNext()) {
                Socket socket = iterator.next();
                try {
                    InputStream inputStream = socket.getInputStream();
                    if (inputStream.available() > 0) {
                        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                        String message = in.readLine();
                        if (message != null) {
                            System.out.println("Empfangen von " + socket.getRemoteSocketAddress() + ": " + message);
                            broadcastMessage(socket, message);
                        } else {
                            // Client hat Verbindung getrennt
                            System.out.println("Client getrennt: " + socket);
                            socket.close();
                            iterator.remove();
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Fehler bei Client: " + socket);
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        // Ignorieren
                    }
                    iterator.remove();
                }
            }
        }
    }
    private static void broadcastMessage(Socket sender, String message) {
        for (Socket socket : clientSockets) {
            if (!socket.equals(sender)) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Broadcast von " + sender.getRemoteSocketAddress() + ": " + message);
                } catch (IOException e) {
                    System.out.println("Fehler beim Senden an " + socket);
                }
            }
        }
    }
}
