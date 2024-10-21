package Oktober.SoftwareSchule;

public class Student extends Person {
    private int klassenStufe;
    private int contFactor;

    public Student(String name, int yearBirth, int klassenStufe) {
        super(name, yearBirth);
        this.klassenStufe = klassenStufe;
        this.contFactor = 5;
    }
}
