package Robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Erstelle einen Roboter mit einem Index von 2 (oder wähle eine andere Zahl)
        Roboter90 robot90 = new Roboter90(1);
        Roboter45 robot45 = new Roboter45(1);
        // Erstelle eine Fernbedienung für den Roboter
        RemoteControl remoteControl = new RemoteControl(robot90,robot45);

        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();

        // Steuerung des Roboters ausführen
        remoteControl.controls(commands);
    }
}