import java.util.ArrayList;

public class Container extends Thing {
    ArrayList<Thing> things;
    Container(String name, String description, Location location) {
        super(name, description, location);
        things = new ArrayList<>();
    }
    public void addThing(Thing thing) {
        things.add(thing);
        thing.setLocation(this.getLocation());
    }
    public void removeThing(Thing thing, Container containerAdd) {
        things.remove(thing);
        containerAdd.addThing(thing);
        thing.setLocation(containerAdd.getLocation());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Container ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Items:\n").append(this.things != null ? this.things : "Empty").append("\n")
                .append("Location: ").append(this.getLocation() != null && this.getLocation().getName() != null ? this.getLocation().getName() : "Unknown").append("\n");
        return sb.toString();
    }



    //Getter-Setter
    public ArrayList<Thing> getThings() {
        return things;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }
}
