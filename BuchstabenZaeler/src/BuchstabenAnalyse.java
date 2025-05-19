import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class BuchstabenAnalyse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib einen Text ein:");
        String eingabe = scanner.nextLine().toLowerCase();

        Map<Character, Integer> haeufigkeit = new TreeMap<>();

        for (char buchstabe : eingabe.toCharArray()) {
            if (Character.isLetter(buchstabe)) {
                if (haeufigkeit.containsKey(buchstabe)) {
                     haeufigkeit.put(buchstabe, haeufigkeit.get(buchstabe) + 1);
                } else {
                    haeufigkeit.put(buchstabe, 1);
                }
            }
        }

        System.out.println("\nBuchstabenhäufigkeit:");
        for (Map.Entry<Character, Integer> eintrag : haeufigkeit.entrySet()) {
            System.out.printf("%c: %d%n", eintrag.getKey(), eintrag.getValue());
        }

        scanner.close();
    }
}

