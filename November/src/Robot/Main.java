package Robot;

public class Main {
    public static void main(String[] args) {
        // Erstelle einen Roboter mit einem Index von 2 (oder wähle eine andere Zahl)
        Roboter roboter = new Roboter(1);
        // Erstelle eine Fernbedienung für den Roboter
        RemoteControl remoteControl = new RemoteControl(roboter);

        // Beispielbefehle: "aapraa" -> Bewegen, Position drucken, nach rechts drehen, bewegen
        String commands = "paallrapaarrap";

        // Steuerung des Roboters ausführen
        remoteControl.controls(commands);
    }
}