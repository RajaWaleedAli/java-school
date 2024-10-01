package introClasses.PersonLesson;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Anna");
        Person person2 = new Person("Anna");

        if (person1==person2) {     //== tests for reference equality (whether they are on the same memory)
            System.out.println("Die Personen sind gleich.");
        } else {
            System.out.println("Die Personen sind nicht gleich.");
        }
    }
}