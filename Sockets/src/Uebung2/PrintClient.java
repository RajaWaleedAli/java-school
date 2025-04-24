package Uebung2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class PrintClient {
    public static void main(String[] args) throws IOException {
        LocalDateTime date;
        Socket s = new Socket("localhost", 12345);
        String message = "Hello World";
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        date=LocalDateTime.now();
        out.println(message+" "+date+"\n");

        BufferedReader inFromClient= new BufferedReader(new InputStreamReader(s.getInputStream()));
        message = inFromClient.readLine();

        System.out.println(message);
    }
}
