public class Entety {
    private String name;
    private String description;
    public Entety(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Getter-Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
