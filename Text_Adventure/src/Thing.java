public class Thing extends Entety {
    private Location location;

    Thing(String name, String description, Location location) {
        super(name, description);
        this.location = location;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "\nName = " + this.getName() +
                "\nDescription = "+this.getDescription()+
                "\nLocation = " + this.location.getName() +
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
