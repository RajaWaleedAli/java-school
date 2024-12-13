package Oktober.Vererbung;

public class Torwart extends Fussballer{
    private int parries;
    private double height;
    public Torwart(String name, int age, int sportYear, String team, int parries, double height) {
        super(name, age, sportYear, team, "Tormann");
        this.parries = parries;
        this.height = height;
    }
    private boolean parry(){
        if(Math.random()<0.2){
            return true;
        }else
            return false;
    }
    public int getParries() {
        return parries;
    }
    public double getHeight() {
        return height;
    }
}
