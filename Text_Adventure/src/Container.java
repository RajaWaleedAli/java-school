import java.util.ArrayList;
import java.util.Objects;

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

    public void searchThing(Thing thing) {
        for(Thing t : things) {
            if(t.equals(thing)){
                this.addThing(thing);
            }
        }
    }

    public void searchThing(Thing thing,Container containerAdd) {
        for(Thing t : this.things) {
            if(t.equals(thing)){
                this.removeThing(thing,containerAdd);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Container ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Items:\n").append(!this.things.isEmpty() ? this.things : "Empty").append("\n")
                .append("Location: ").append(this.getLocation() != null && this.getLocation().getName() != null ? this.getLocation().getName() : "Unknown").append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Container other = (Container) obj;
        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getDescription(), other.getDescription());
    }

    //Getter-Setter
    public ArrayList<Thing> getThings() {
        return things;
    }

    public void setThings(ArrayList<Thing> things) {
        this.things = things;
    }
}
