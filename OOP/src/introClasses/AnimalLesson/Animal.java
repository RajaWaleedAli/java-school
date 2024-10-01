package introClasses.AnimalLesson;

public class Animal {
    private String name;
    private int age;
    private String species;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public void macheGeraesch() {
        System.out.println("Tier mach Geraesche");
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return this.species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
}
