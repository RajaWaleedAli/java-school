package Uebung4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class PrintClient extends Thread {
    public static void main(String[] args) throws IOException {
        PrintClient thread = new PrintClient();
        PrintClient thread2 = new PrintClient();
        thread.start();
        thread2.start();
    }
    public void run() {
        try {
            Socket s = new Socket("localhost", 12345);
            String message = "Hello World";
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println(message + "\n");

            System.out.println(message);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
