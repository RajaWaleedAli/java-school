public class Thing extends Entety {
    private Location location;

    Thing(String name, String description, Location location) {
        super(name, description);
        this.location = location;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Thing ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Location: ").append(this.location != null && this.location.getName() != null ? this.location.getName() : "Unknown").append("\n");
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
