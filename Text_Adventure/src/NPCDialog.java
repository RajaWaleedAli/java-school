import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NPCDialog {

    // Private ArrayList to store the quotes
    private static final ArrayList<String> quotes = new ArrayList<>();

    // Static block to initialize some default quotes
    static {
        quotes.add("Willkommen in unserem Dorf!");
        quotes.add("Das Wetter ist heute schön, nicht wahr?");
        quotes.add("Pass auf dich auf, Reisender.");
        quotes.add("Hast du schon von den Gerüchten gehört?");
        quotes.add("Möchtest du etwas handeln?");
        quotes.add("Die Sterne erzählen uns Geschichten.");
        quotes.add("Was für ein seltsames Geräusch in der Nacht...");
        quotes.add("Die Dorfbewohner sind freundlich, aber sie haben ihre Geheimnisse.");
        quotes.add("Manchmal ist der Weg das Ziel.");
        quotes.add("Glaubst du an die alten Legenden?");
        quotes.add("Jeder hat eine Geschichte zu erzählen.");
        quotes.add("Die Zeit ist ein kostbares Gut, verschwende sie nicht.");
        quotes.add("Der Wind trägt oft die Wahrheit zu uns.");
        quotes.add("Ich habe einen alten Schatz gehört, der tief im Wald vergraben sein soll.");
        quotes.add("Es gibt nichts gefährlicheres als die Stille der Nacht.");
        quotes.add("Du hast ein interessantes Gesicht, Reisender.");
        quotes.add("Viel Glück auf deiner Reise, möge dein Weg sicher sein.");
        quotes.add("Komm bald wieder, wir brauchen deine Hilfe.");
        quotes.add("Hast du etwas über die alten Ruinen gehört?");
        quotes.add("Ich hoffe, du findest, was du suchst.");
        quotes.add("Die Berge sind heute besonders mysteriös.");
        quotes.add("Achte auf die Nacht, sie bringt Gefahr.");
        quotes.add("Die Zeiten ändern sich, aber wir müssen weitergehen.");
        quotes.add("Ich habe gehört, dass der Wald in letzter Zeit gefährlicher geworden ist.");
        quotes.add("Hast du ein Abenteuer im Sinn?");
        quotes.add("Die Zeit heilt alle Wunden, aber nicht alle Narben.");
        quotes.add("Verliere nie den Glauben an das Gute im Menschen.");
        quotes.add("Hast du das alte Schwert in der Schmiede gesehen?");
        quotes.add("Die Magie ist in der Luft, aber sie ist gefährlich.");
        quotes.add("Manchmal muss man Opfer bringen, um zu gewinnen.");
        quotes.add("Die Wälder sind voller Geheimnisse, die nur die Mutigsten entdecken.");
        quotes.add("Glaubst du an Schicksal oder Zufall?");
        quotes.add("Die Sonne sinkt, die Dunkelheit kommt.");
        quotes.add("Vergiss nicht, was du hier gelernt hast, es könnte dich retten.");
        quotes.add("Wirst du den Weg des Kriegers oder des Magiers wählen?");


    }

    // Method to get all quotes as an unmodifiable list
    public static List<String> getQuotes() {
        return Collections.unmodifiableList(quotes);
    }

    // Method to add a new quote
    public static void addQuote(String quote) {
        if (quote != null && !quote.trim().isEmpty()) {
            quotes.add(quote);
        }
    }
    public static String getRandomQuote() {
        Random rand = new Random();
        int index = rand.nextInt(quotes.size()); // Zufälligen Index auswählen
        return quotes.get(index); // Das Zitat mit diesem Index zurückgeben
    }

    // Method to remove a specific quote
    public static boolean removeQuote(String quote) {
        return quotes.remove(quote);
    }

    // Method to clear all quotes
    public static void clearQuotes() {
        quotes.clear();
    }
}

