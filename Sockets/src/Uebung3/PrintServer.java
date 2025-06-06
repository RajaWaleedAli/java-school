package Uebung3;

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
        char operator = ' ';
        int opIndex = -1;
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                opIndex = i;
                break;
            }
        }
        if(opIndex==-1){
            System.out.println("No operator found");
        }
        String rechnung = message.replaceAll("\\s+", "");
        String regex = "[+--/*]";
        String[] myArray = rechnung.split(regex);
        int value1=Integer.parseInt(myArray[0]);
        int value2=Integer.parseInt(myArray[1]);
        int result=value1+value2;
        System.out.println(message+" = "+result);
        serverSocket.close();
        clientSocket.close();
    }
}
