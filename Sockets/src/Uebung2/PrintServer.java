package Uebung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class PrintServer {
    public static void main(String[] args) throws IOException {
        LocalDateTime date;
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket clientSocket= serverSocket.accept();
        BufferedReader inFromClient= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = inFromClient.readLine();
        System.out.println(message);


        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        date= LocalDateTime.now();
        out.println(message+" "+date+"\n");

        serverSocket.close();
        clientSocket.close();
    }
}
