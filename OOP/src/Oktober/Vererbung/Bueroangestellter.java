package Oktober.Vererbung;

public class Bueroangestellter extends Mensch{
    private String department;
    private int workplace;
    public Bueroangestellter(String name, int age, String department, int workplace) {
        super(name, age);
        this.department = department;
        this.workplace = workplace;
    }
    public boolean isWorking(){
        if(super.getAge()<18) {
            return false;
        }else{
            return true;
        }
    }
    public String getDepartment() {
        return department;
    }
    public int getWorkplace() {
        return workplace;
    }
}
