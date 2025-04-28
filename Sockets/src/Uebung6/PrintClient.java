package Uebung6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class PrintClient extends Thread {
    private String index;

    public PrintClient(String index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name:");
            String s = scanner.nextLine();
            new PrintClient(s).start();
        }
    }

    public void run() {
        try (
                Socket socket = new Socket("localhost", 12345);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            AtomicReference<String> userInput = new AtomicReference<>("");
            //System.out.println("Client " + index + " verbunden.");
            out.println("Hallo von " + index);
            new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    if (scanner.hasNextLine()) {
                        try {
                            userInput.set(scanner.nextLine());
                        }catch(Exception e) {
                            //ignorieren
                        }
                    }
                }
            }).start();
            while(true){
                String response;
                if (!userInput.get().isEmpty()) {
                    out.println(userInput.get());
                    userInput.set(""); // Reset nach Senden
                }
                if(in.ready()){
                    if ((response = in.readLine()) != null) {
                        System.out.println("Client " + index + " empfängt: " + response);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Client " + index + " Verbindung verloren.");
        }
    }
}
