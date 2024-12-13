package Oktober.Vererbung;

public class Main {
    public static void main(String[] args) {
        // Create a Mensch object
        Mensch person = new Mensch("John Doe", 25);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Can walk: " + person.walk());

        // Create a Bueroangestellter object
        Bueroangestellter employee = new Bueroangestellter("Sarah", 30, "IT", 101);
        System.out.println("Bueroangestellter: " + employee.getName() + ", Department: " + employee.getDepartment());
        System.out.println("Is Working: " + employee.isWorking());

        // Create a Sportler object
        Sportler athlete = new Sportler("Tom", 20, "Basketball", 4);
        System.out.println("Sportler: " + athlete.getName() + ", Sport: " + athlete.getSportName() + ", Sport Year: " + athlete.getSportYear());

        // Create a Fussballer object
        Fussballer footballer = new Fussballer("David", 28, 10, "Team A", "Midfielder");
        System.out.println("Fussballer: " + footballer.getName() + ", Team: " + footballer.getTeam() + ", Position: " + footballer.getPosition());

        // Create a Stuermer object
        Stuermer striker = new Stuermer("Leo", 29, 12, "Team B", 30, 9.5);
        System.out.println("Stuermer: " + striker.getName() + ", Goals: " + striker.getGoals() + ", Speed: " + striker.getSpeed());
        System.out.println("Shot success: " + (striker.shoot() ? "Goal!" : "Missed"));

        // Create a Torwart object
        Torwart goalkeeper = new Torwart("Manuel", 32, 15, "Team C", 120, 1.88);
        System.out.println("Torwart: " + goalkeeper.getName() + ", Parries: " + goalkeeper.getParries() + ", Height: " + goalkeeper.getHeight());
    }
}
