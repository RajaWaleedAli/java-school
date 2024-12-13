package Oktober.Vererbung;

public class Stuermer extends Fussballer {
    private int goals;
    private double speed;

    public Stuermer(String name, int age, int sportYear, String team, int goals, double speed) {
        super(name, age, sportYear, team, "Stuermer");
        this.goals = goals;
        this.speed = speed;
    }
    public boolean shoot(){
        if(Math.random() < 0.2){
            return true;
        }else
            return false;
    }
    public int getGoals() {
        return goals;
    }
    public double getSpeed() {
        return speed;
    }
}
