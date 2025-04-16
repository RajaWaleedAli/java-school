package Uebung1;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

public class PrintClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 12345);
        String message = "Hello World";
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(message+"\n");

        System.out.println(message);
    }
}
