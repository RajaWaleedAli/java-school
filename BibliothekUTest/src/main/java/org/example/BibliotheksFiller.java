package org.example;

public class BibliotheksFiller {

    public static void fillBibliothek(Bibliothek bibliothek) {
        // Hinzufügen einiger Bücher
        Buch buch1 = new Buch("Java für Anfänger", "Max Mustermann", "12345");
        Buch buch2 = new Buch("Fortgeschrittenes Java", "Erika Mustermann", "67890");
        bibliothek.buchHinzufuegen(buch1);
        bibliothek.buchHinzufuegen(buch2);

        // Hinzufügen einiger Nutzer
        Nutzer nutzer1 = new Nutzer("N001", "Julia Beispiel");
        Nutzer nutzer2 = new Nutzer("N002", "Niklas Beispiel");
        bibliothek.nutzerHinzufuegen(nutzer1);
        bibliothek.nutzerHinzufuegen(nutzer2);
    }
}