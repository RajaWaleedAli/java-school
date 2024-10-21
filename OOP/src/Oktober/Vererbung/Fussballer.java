package Oktober.Vererbung;

public class Fussballer extends Sportler{
    private String team;
    private String position;

    public Fussballer(String name, int age, int sportYear, String team, String position) {
        super(name, age, "Fussball", sportYear);
        this.team = team;
        this.position = position;
    }
    public String getTeam() {
        return team;
    }
    public String getPosition() {
        return position;
    }
}
