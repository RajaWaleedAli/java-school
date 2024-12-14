public class Exit extends Entety {
    private Location destination;

    public Exit(String name, String description, Location destination) {
        super(name,description);
        this.destination = destination;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Exit ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Destination: ").append(this.destination != null && this.destination.getName() != null ? this.destination.getName() : "Unknown").append("\n");
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

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
