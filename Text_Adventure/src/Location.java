import java.util.ArrayList;

public class Location extends Entety{
    Container items;
    ArrayList<Exit>exits;
    Location lastLocation;
    public Location(String name, String description, Location lastLocation) {
        super(name, description);
        this.lastLocation = lastLocation;
        this.exits = new ArrayList<>();
        this.items = new Container(null,null,this);
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public void removeExit(Exit exit) {
        exits.remove(exit);
    }

    public void addItems(Thing items){
        this.items.addThing(items);
    }

    public void removeItems(Thing items, Container playerInventory){
        this.items.removeThing(items, playerInventory);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Location ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Items: ").append(this.items != null && this.items.getThings() != null ? this.items.getThings() : "No items here").append("\n")
                .append("Exits: ").append(this.exits != null ? this.exits : "No exits available").append("\n")
                .append("Last Location: ").append(this.lastLocation != null && this.lastLocation.getName() != null ? this.lastLocation.getName() : "Unknown").append("\n");
        return sb.toString();
    }



    //Getter-Setter
    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getDescription() {
        return super.getDescription();
    }

    public void setDescription(String description) {
        super.setDescription(description);
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }

    public Container getItems() {
        return items;
    }

    public void setItems(Container items) {
        this.items = items;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void setExits(ArrayList<Exit> exits) {
        this.exits = exits;
    }
}
