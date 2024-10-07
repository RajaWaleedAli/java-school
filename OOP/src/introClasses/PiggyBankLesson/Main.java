package introClasses.PiggyBankLesson;

public class Main {
    public static void main(String[] args) {
        // Test 1: Initialisierung eines leeren Sparschweins
        PiggyBank piggy1 = new PiggyBank(20);  // Kapazität 20 Münzen
        PiggyBank piggy2 = new PiggyBank(30);  // Kapazität 30 Münzen

        System.out.println("Test 1: Initialisierung");
        System.out.println("Ist Piggy1 leer? " + piggy1.isEmpty());  // true
        System.out.println("Ist Piggy1 voll? " + piggy1.isFull());   // false
        System.out.println("Ist Piggy1 aufgebrochen? " + piggy1.isBroken()); // false

        // Test 2: Münzen hinzufügen
        System.out.println("\nTest 2: Münzen hinzufügen");
        piggy1.add1Cents(5);  // 5 x 1-Cent-Münzen
        piggy1.add10Cents(3); // 3 x 10-Cent-Münzen
        piggy1.add50Cents(2); // 2 x 50-Cent-Münzen
        piggy1.add100Cents(1); // 1 x 1-Euro-Münze

        System.out.println("Piggy1 hat nun " + piggy1.piggyCoins() + " Münzen.");

        // Test 3: Sparschwein ist fast voll
        System.out.println("\nTest 3: Ist Piggy1 voll?");
        System.out.println("Piggy1 ist voll: " + piggy1.isFull());   // false

        // Test 4: Überlaufprüfung
        System.out.println("\nTest 4: Überlauf hinzufügen");
        int restMuenzen = piggy1.add1Cents(15);  // 15 weitere 1-Cent-Münzen
        System.out.println("Nicht hineingepasste Münzen: " + restMuenzen);

        // Test 5: Sparschwein aufbrechen
        System.out.println("\nTest 5: Piggy1 aufbrechen");
        int gesamtBetrag = piggy1.breakInto();
        System.out.println("Gesamtbetrag in Piggy1 nach Aufbrechen: " + gesamtBetrag + " Cents");
        System.out.println("Ist Piggy1 aufgebrochen? " + piggy1.isBroken());  // true
        System.out.println("Ist Piggy1 leer nach dem Aufbrechen? " + piggy1.isEmpty()); // true

        // Test 6: Münzen in Piggy2 hinzufügen und vergleichen
        System.out.println("\nTest 6: Münzen in Piggy2 hinzufügen");
        piggy2.addCoins(2, 3, 1, 2); // 2x 1-Cent, 3x 10-Cent, 1x 50-Cent, 2x 1-Euro

        System.out.println("Piggy2 hat nun " + piggy2.piggyCoins() + " Münzen.");
        System.out.println("Ist Piggy1 leichter als Piggy2? " + piggy1.isLighterThan(piggy2));

        // Test 7: Piggy2 in Piggy1 umfüllen
        System.out.println("\nTest 7: Piggy2 in Piggy1 umfüllen");
        piggy1 = new PiggyBank(20); // Neues Sparschwein mit Kapazität 20 Münzen
        boolean result = piggy1.addCoin_New(piggy2);
        System.out.println("Piggy2 erfolgreich in Piggy1 umgefüllt: " + result);
        System.out.println("Piggy1 hat jetzt " + piggy1.piggyCoins() + " Münzen.");
        System.out.println("Piggy2 hat jetzt " + piggy2.piggyCoins() + " Münzen.");
    }
}

