package Uebung6;

import java.io.*;
import java.net.*;
import java.util.*;

public class PrintServer {
    private static List<Socket> clientSockets = new ArrayList<>();
    private static HashMap<String,Socket> nameToSocket = new HashMap<String,Socket>();
    private static HashMap<Socket,String> socketToName = new HashMap<Socket,String>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server gestartet auf Port 12345");

        while (true) {
            if (serverSocket.isBound() && !serverSocket.isClosed()) {
                serverSocket.setSoTimeout(100);
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientSockets.add(clientSocket);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    String response;
                    while(!in.ready());
                    response = in.readLine();
                    nameToSocket.put(response,clientSocket);
                    socketToName.put(clientSocket,response);
                    System.out.println("Neuer Client verbunden: " + response);
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
        if(message.startsWith("@")){
            String s2 = message.substring(1); // "Simon geht es dir gut"
            int spaceIndex = s2.indexOf(' ');

            String name="";
            if (spaceIndex != -1) {
                name = s2.substring(0, spaceIndex);
            }
            try{
                Socket s=nameToSocket.get(name);
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                out.println("Broadcast von " + socketToName.get(s) + ": " + message);
                return;
            }catch (Exception e){
                System.err.println("Client "+name+" gibt es nicht");
            }
        }
        for (Socket socket : clientSockets) {
            if (!socket.equals(sender)) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(socketToName.get(sender) + ": " + message);
                } catch (IOException e) {
                    System.out.println("Fehler beim Senden an " + socket);
                }
            }
        }
    }
}
