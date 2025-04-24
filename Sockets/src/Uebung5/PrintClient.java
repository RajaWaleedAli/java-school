package Uebung5;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;

public class PrintClient extends Thread {
    private int index;

    public PrintClient(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new PrintClient(i).start();
        }
    }

    public void run() {
        try (
                Socket socket = new Socket("localhost", 12345);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            //System.out.println("Client " + index + " verbunden.");
            out.println("Hallo vom Client " + index);

            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Client " + index + " empfängt: " + response);
            }

        } catch (IOException e) {
            System.out.println("Client " + index + " Verbindung verloren.");
        }
    }
}
