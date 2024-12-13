import java.util.Scanner;

public class TestSzenario {
    private String read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte geben Sie einen Text ein:");
        String text = sc.nextLine();
        sc.close();
        return text;
    }
    public static void main(String[] args) {
        // Location und Ausgänge erstellen
        Location dach = new Location("Dach", "Dies ist das Dach der kleinen Hütte.", null);
        Location huette = new Location("Hütte", "Dies ist eine kleine, verfallene Hütte am Waldrand.", null);
        Location wiese = new Location("Wiese", "Eine Wildblumenwiese. Irgendetwas ist seltsam an dieser Wiese.", null);
        Location bach = new Location("Bach", "Ein reißender Bergbach. Ein falscher Schritt kann dich das Leben kosten ...", null);

        huette.addExit(new Exit("hoch", "Die Rückwand der Hütte sieht so aus, als könnte man dort hochklettern.", dach));
        dach.addExit(new Exit("runter", "Ein Loch im Dach führt in das Innere der Hütte.", huette));
        huette.addExit(new Exit("raus", "Durch die Tür siehst du eine blühende Wiese.", wiese));
        wiese.addExit(new Exit("rein", "Durch die Tür siehst du das Innere einer Hütte.", huette));
        wiese.addExit(new Exit("Osten", "Im Osten grenzt die Wiese an einen Bach.", bach));
        bach.addExit(new Exit("Westen", "Am Westufer ist eine Wiese.", wiese));

        // Dinge erstellen
        Container stein = new Container("Stein", "Ein schwerer Granitklotz.", wiese);
        Thing schwert = new Thing("Schwert", "Ein königliches Schwert.", wiese);
        stein.addThing(schwert);

        Container schrank = new Container("Schrank", "Ein großer, dunkler Bauernschrank.", huette);

        // Spieler erstellen
        Player spieler = new Player("Artus", "Ein mutiger Abenteurer.");
        spieler.setCurrentLocation(bach);

        // Simulation starten
        System.out.println("Simulation gestartet!");

        // Spieler verlässt den Bach
        spieler.move("Westen");
        printState(spieler);

        // Spieler nimmt das Schwert aus dem Stein
        spieler.addItem(schwert);
        printState(spieler);

        // Spieler geht in die Hütte
        spieler.move("rein");
        printState(spieler);

        // Spieler deponiert das Schwert im Schrank
        spieler.removeItem(schwert,schrank);
        printState(spieler);

        // Spieler klettert aufs Dach
        spieler.move("hoch");
        printState(spieler);

        System.out.println(schrank.toString());
        System.out.println("Simulation beendet!");
    }

    // Hilfsmethode zum Zustand drucken
    private static void printState(Player spieler) {
        System.out.println(spieler.toString());
    }
}