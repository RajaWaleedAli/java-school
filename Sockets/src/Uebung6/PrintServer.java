package Uebung6;

import java.io.*;
import java.net.*;
import java.util.*;


public class PrintServer extends Thread {
    private static List<Socket> clientSockets = new ArrayList<>();
    private static HashMap<String,Socket> nameToSocket = new HashMap<String,Socket>();
    private static HashMap<Socket,String> socketToName = new HashMap<Socket,String>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(20014);
        System.out.println("Server gestartet auf Port 20014");
        
        new Thread(()->{
            serverList();
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    String helpMessage = "Verfügbare Commands:\n" +
                            "  NEWUSER;name          → Username setzen\n" +
                            "  BC;nachricht          → Nachricht an alle senden\n" +
                            "  @name;nachricht       → Nachricht an einen bestimmten User\n" +
                            "  close;                → Verbindung beenden";

                    broadcastSystemMessage(helpMessage);

                    Thread.sleep(15000); // 10 Sekunden
                } catch (InterruptedException e) {
                    break;
                }
            }
        }).start();
        
        while (true) {
            if (serverSocket.isBound() && !serverSocket.isClosed()) {
                serverSocket.setSoTimeout(100);
                try {
                    Socket clientSocket = serverSocket.accept();
                    clientSockets.add(clientSocket);
                    System.out.println("Neuer Client verbunden: " + clientSocket);
                } catch (SocketTimeoutException e) {}
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
    private static void serverList(){
        try (
                Socket socket = new Socket("localhost", 20000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            out.println("Server gestartet auf Port 20014\n");
            if(in.ready()){
                if ((in.readLine()) != null) {
                    System.out.println(in.readLine());
                }
            }
        }catch (Exception e) {}
        new Thread(()->{
            while(true) {
                try (
                        Socket socket = new Socket("localhost", 20000);
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ) {
                    if (in.ready()) {
                        if ((in.readLine()) != null) {
                            System.out.println(in.readLine());
                        }
                    }
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        }).start();
    }

    private static void broadcastMessage(Socket sender, String message) {
        int semicolonIndex = -1;
        if (message.startsWith("@")) {
            String s2 = message.substring(1);
            semicolonIndex = s2.indexOf(';');
            String actualMsg = s2.substring(semicolonIndex + 1);

            String name = "";
            if (semicolonIndex != -1) {
                name = s2.substring(0, semicolonIndex);
            }
            try {
                Socket s = nameToSocket.get(name);
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                out.println(socketToName.get(sender) + " (privat): " + actualMsg);;
            } catch (Exception e) {
                try {
                    PrintWriter out = new PrintWriter(sender.getOutputStream(), true);
                    out.println("Client " + name + " gibt es nicht\n");
                } catch (Exception ee) {}
            }
        }else if(message.equalsIgnoreCase("close;")){
            try {
                sender.close();
                nameToSocket.remove(socketToName.get(sender));
                socketToName.remove(sender);
            }catch (Exception e){}
        }else if(message.startsWith("NEWUSER")) {
            semicolonIndex = message.indexOf(';');
            if(socketToName.containsKey(sender)){
                try {
                    PrintWriter out = new PrintWriter(sender.getOutputStream(), true);
                    out.println("Sie besitzen bereits einen UserName. Ihr username lautet: "
                            + socketToName.get(sender)+"\n");
                } catch (Exception ee) {}
                return;
            }
            String name = "";
            if (semicolonIndex != -1) {
                name = message.substring(semicolonIndex + 1);
                socketToName.put(sender,name);
                nameToSocket.put(name,sender);
                System.out.println(name+" ist dem Chat beigetreten");
                broadcastSystemMessage(name+" ist dem Chat beigetreten");
            }else {
                try {
                    PrintWriter out = new PrintWriter(sender.getOutputStream(), true);
                    out.println("Fehler aufgetreten!\n");
                } catch (Exception ee) {}
            }
        }else if(message.startsWith("BC")) {
            semicolonIndex = message.indexOf(';');

            String msg="";
            if (semicolonIndex != -1) {
                msg = message.substring(semicolonIndex + 1);
            }
            for (Socket socket : clientSockets) {
                if(socketToName.containsKey(socket)){
                    if (!socket.equals(sender)) {
                        try {
                            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                            out.println(socketToName.get(sender) + ": " + msg+"\n");
                        } catch (IOException e) {
                            System.out.println("Fehler beim Senden an " + socketToName.get(socket));
                        }
                    }
                }
            }
        }
    }

    private static void broadcastSystemMessage(String message) {
        for (Socket socket : clientSockets) {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("[System] " + message + "\n");
            } catch (IOException e) {
                System.out.println("Fehler beim Senden an " + socket);
            }
        }
    }

}
