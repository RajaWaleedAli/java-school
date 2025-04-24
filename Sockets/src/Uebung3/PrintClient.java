package Uebung3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class PrintClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 12345);
        String message = "5 + 3";
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(message+"\n");

        System.out.println(message);
    }
}
