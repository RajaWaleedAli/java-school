package Oktober.SoftwareSchule;
import java.time.LocalDateTime;

public class Person {
    private String name;
    private int yearBirth;
    public Person(String name, int yearBirth) {
        this.name = name;
        this.yearBirth = yearBirth;
    }

    public int getAge() {
        return yearBirth-LocalDateTime.now().getYear();
    }

    public String getName() {
        return name;
    }
}
