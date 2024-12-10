import java.util.ArrayList;

public class Location extends Entety{
    Container items;
    ArrayList<Exit>exits;
    Location lastLocation;
    public Location(String name, String description, Location lastLocation) {
        super(name, description);
        this.lastLocation = lastLocation;
        this.exits = new ArrayList<>();
        this.items = new Container(null,null,null);
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

    public void removeItems(Thing items, Player player){
        this.items.removeThing(items, player);
    }

    @Override
    public String toString() {
        return "Location{" +
                "\nName = " + this.getName() +
                "\nDescription="+this.getDescription()+
                "\nItems=" + this.items.getThings().toString() +
                "\nExits=" + this.exits.toString() +
                "\nLast Location=" + lastLocation.getName() +
                "\n}";
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
