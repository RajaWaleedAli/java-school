/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Speichert den aktuellen Spielstand
                  (Daten die in Spieler Gespeeichert wurden, werden hier aufgerufen)
*/

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Save {
    private static String path="C:\\Users\\39339\\IdeaProjects\\java\\Text_Adventure\\test.txt";
    private static final FileWriter fw;

    static {
        try {
            fw = new FileWriter(path,false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final PrintWriter pw = new PrintWriter(fw);

    public Save() throws IOException {
    }

    public static boolean saveGame(Player player) {
        try {
            // Spielername und Beschreibung speichern
            pw.println("Player Name: " + player.getName());
            pw.println("Player Description: " + player.getDescription());

            // Aktuelle Position speichern
            Location currentLocation = player.getCurrentLocation();
            pw.println("Current Location: " + (currentLocation != null ? currentLocation.getName() : "null"));

            // Inventar speichern
            Container inventory = player.getInventory();
            pw.println("Inventory: " + inventory.getName());

            // Gegenstände im Inventar speichern
            ArrayList<Thing> items = inventory.getThings();
            pw.println("Items: " + (items.isEmpty() ? "none" : ""));
            for (Thing item : items) {
                pw.println(item.getName() + " - " + item.getDescription());
            }

            pw.flush();
            return true;
        } catch (Exception e) {
            System.err.println("Fehler beim Speichern des Spiels: " + e.getMessage());
            return false;
        }
    }
}