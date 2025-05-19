package Uebung6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class PrintClient extends Thread {
    private int index;

    public PrintClient(int index) {
        this.index = index;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Port: ");
        System.out.flush();
        String s = scanner.nextLine();
        new PrintClient(Integer.parseInt(s)).start();
    }

    public void run() {
        try (
                Socket socket = new Socket("10.10.30.138", index);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            AtomicReference<String> userInput = new AtomicReference<>("");
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
            while (true) {
                if (!userInput.get().isEmpty()) {
                    out.println(userInput.get());
                    userInput.set("");
                }
                if (in.ready()) {
                    String response = in.readLine();
                    if (response != null) {
                        System.out.println(response);
                    }
                }
                Thread.sleep(100);
            }

        } catch (IOException e) {
            System.out.println("Verbindung verloren.");
        } catch (InterruptedException e) {}
    }
}