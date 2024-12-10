public class Exit extends Entety {
    private Location destination;

    public Exit(String name, String description, Location destination) {
        super(name,description);
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "\nName = " + this.getName() +
                "\nDescription="+this.getDescription()+
                "\nDestination=" + this.destination.getName() +
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

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
