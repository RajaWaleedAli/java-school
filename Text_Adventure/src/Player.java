import java.util.ArrayList;

public class Player extends Entety {
    private Location currentLocation;
    private ArrayList<Thing> inventory;
    public Player(String name,String description) {
        super(name,description);
        currentLocation = null;
        inventory = new ArrayList<>();
    }

    public void addItem(Thing item) {
        inventory.add(item);
    }
    public void removeItem(Thing item, Container container) {
        inventory.remove(item);
        container.addThing(item);
    }

    public void move(String exitName) {
        // Überprüfen, ob die aktuelle Location existiert
        if (currentLocation != null) {
            ArrayList<Exit> exits = currentLocation.getExits();
            Exit chosenExit = null;

            // Suchen nach dem passenden Ausgang
            for (Exit exit : exits) {
                if (exit.getName().equalsIgnoreCase(exitName)) {
                    chosenExit = exit;
                    break;
                }
            }

            if (chosenExit != null) {
                // Spieler zur neuen Location bewegen
                Location newLocation = chosenExit.getDestination();
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
        return "Player{" +
                "\nName = " + this.getName() +
                "\ncurrentLocation = " + currentLocation.getName() +
                "\ninventory = " + inventory.toString() +
                "\n}";
    }

    //Getter-Setter
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

    public ArrayList<Thing> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Thing> inventory) {
        this.inventory = inventory;
    }
}
