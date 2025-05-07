import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Eingabe von Min und Max
        System.out.print("Gib die minimale Wortlänge ein (min): ");
        int min = scanner.nextInt();
        System.out.print("Gib die maximale Wortlänge ein (max): ");
        int max = scanner.nextInt();
        scanner.nextLine(); // Zeilenumbruch abfangen

        // Eingabe des Textes
        System.out.println("Gib den Text ein:");
        String inputText = scanner.nextLine().toLowerCase();

        // Wörter extrahieren
        String[] words = inputText.split("\\W+");

        // TreeMap nach Wort sortiert (natürliche Ordnung)
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();

        for (String word : words) {
            if (word.length() >= min && word.length() <= max) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }

        // TreeMap mit Komparator für absteigende Sortierung nach Wort
        TreeMap<String, Integer> reverseSortedMap = new TreeMap<>(new ReverseStringComparator());
        reverseSortedMap.putAll(wordCountMap);

        // Liste für Sortierung nach Anzahl (Häufigkeit)
        List<Map.Entry<String, Integer>> sortedByFrequency = new ArrayList<>(wordCountMap.entrySet());
        sortedByFrequency.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Ausgabe
        System.out.println("\nAnzahl gültiger Wörter: " + wordCountMap.values().stream().mapToInt(Integer::intValue).sum());

        System.out.println("\nWörter alphabetisch sortiert:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\nWörter absteigend sortiert:");
        for (Map.Entry<String, Integer> entry : reverseSortedMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\nWörter sortiert nach Häufigkeit:");
        for (Map.Entry<String, Integer> entry : sortedByFrequency) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

// Komparator für absteigende String-Sortierung
class ReverseStringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }
}

