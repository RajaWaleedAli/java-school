package Oktober.Vererbung;

public class Mensch {
    private String name;
    private int age;
    public Mensch(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean walk(){
        if(age>10){
            return true;
        }else
            return false;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
