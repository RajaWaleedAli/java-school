/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Spielstand laden.
    Fehler: Beim laden des Spielstands werden die Gegenstände dupliziert
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LoadGame {
    private static String path = "test.txt";

    public static Player loadGame() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Spielername und Beschreibung auslesen
            String playerName = br.readLine().split(": ")[1];
            String playerDescription = br.readLine().split(": ")[1];

            // Spielerobjekt erstellen
            Player player = new Player(playerName, playerDescription);

            // Aktuelle Position auslesen
            String locationName = br.readLine().split(": ")[1];
            if (!locationName.equals("null")) {
                Location location = new Location(locationName, "", null); // Beschreibung und Ausgänge hier leer
                player.setCurrentLocation(location);
            }

            // Inventar auslesen
            String inventoryName = br.readLine().split(": ")[1];
            Container inventory = new Container(inventoryName, "Spieler-Inventar", player.getInventoryLocation());

            // Gegenstände auslesen
            String itemsLine = br.readLine(); // "Items: "
            if (!itemsLine.endsWith("none")) {
                String itemLine;
                while ((itemLine = br.readLine()) != null) {
                    String[] parts = itemLine.split(" - ");
                    Thing item = new Thing(parts[0], parts[1],player.getInventoryLocation());
                    inventory.addThing(item);
                }
            }

            player.setInventory(inventory);
            return player;

        } catch (IOException e) {
            System.err.println("Fehler beim Laden des Spiels: " + e.getMessage());
            return null;
        }
    }
}
