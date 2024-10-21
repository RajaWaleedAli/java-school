package Oktober.Vererbung;

import java.lang.reflect.Member;

public class Sportler extends Mensch {
    private String sportName;
    private int sportYear;
    public Sportler(String name, int age, String sportName, int sportYear) {
        super(name, age);
        this.sportName = sportName;
        this.sportYear = sportYear;
    }
    public String getSportName() {
        return sportName;
    }
    public int getSportYear() {
        return sportYear;
    }
}
