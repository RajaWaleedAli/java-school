package Personenverwaltung;

public class Person {
    private String name;
    private int id;
    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    //Getter-Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
