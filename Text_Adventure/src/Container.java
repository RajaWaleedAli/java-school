import java.util.ArrayList;

public class Container extends Thing {
    ArrayList<Thing> things;
    Container(String name, String description, Location location) {
        super(name, description, location);
        things = new ArrayList<>();
    }
    public void addThing(Thing thing) {
        things.add(thing);
    }
    public void removeThing(Thing thing, Player player) {
        things.remove(thing);
    }

    @Override
    public String toString() {
        return "Container{" +
                "\nName = " + this.getName() +
                "\nDescription = "+this.getDescription()+
                "\nItems = " + things.toString() +
                "\nLocation=" + this.getLocation().getName() +
                "\n}";
    }

    //Getter-Setter
    public ArrayList<Thing> getThings() {
        return things;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }
}
