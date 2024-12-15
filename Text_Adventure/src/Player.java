/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Spieler.
*/

import java.util.ArrayList;
import java.util.Objects;

public class Player extends Entety {
    private Location currentLocation;
    private Container inventory; // Container als Inventar
    private Location inventoryLocation = new Location("Inventory", "Für Items, welche sich im Inventar befinden!", null);

    public Player(String name, String description) {
        super(name, description);
        this.currentLocation = null;
        this.inventory = new Container("Inventory", "Spieler-Inventar", inventoryLocation);
    }

    public void addItem(Thing item) {
        this.inventory.addThing(item); // Hinzufügen von Gegenständen in den Container
        item.setLocation(inventoryLocation);
    }

    public void removeItem(Thing item, Container container) {
        this.inventory.removeThing(item,container); // Entfernen aus dem Container
        item.setLocation(container.getLocation());
    }

    public void move(String exitName) {
        // Überprüfen, ob die aktuelle Location existiert
        if (currentLocation != null) {
            Exit chosenExit = null;

            // Suchen nach dem passenden Ausgang
            for (Exit exit : currentLocation.getExits()) {
                if (exit.getName().equalsIgnoreCase(exitName)) {
                    chosenExit = exit;
                    break;
                }
            }

            if (chosenExit != null) {
                // Spieler zur neuen Location bewegen
                Location newLocation = chosenExit.getDestination();
                newLocation.setLastLocation(getCurrentLocation());
                setCurrentLocation(newLocation);
                System.out.println(chosenExit.toString());
            } else {
                System.out.println("Es gibt keinen Ausgang mit dem Namen '" + exitName + "' in diesem Raum.");
            }
        } else {
            System.out.println("Der Spieler befindet sich derzeit nicht in einer gültigen Location.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Player ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unnamed").append("\n")
                .append("Current Location: ").append(this.currentLocation != null && this.currentLocation.getName() != null ? this.currentLocation.getName() : "Unknown").append("\n")
                .append("Inventory:\n").append(this.inventory != null && !this.inventory.getThings().isEmpty() ? this.inventory.getThings() : "Empty").append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Player other = (Player) obj;
        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getDescription(), other.getDescription());
    }

    // Getter-Setter
    public String getName() {
        return super.getName();
    }

    public void setName(String playerName) {
        super.setName(playerName);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Container getInventory() {
        return inventory;
    }

    public void setInventory(Container inventory) {
        this.inventory = inventory;
    }

    public Location getInventoryLocation() {
        return inventoryLocation;
    }
}
