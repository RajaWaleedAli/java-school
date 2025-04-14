package org.example;
import org.example.exceptions.BuchNichtGefundenException;
import org.example.exceptions.NutzerNichtGefundenException;

import java.util.Scanner;

public class BibliotheksConsoleInterface {

    private Bibliothek bibliothek;
    private Scanner scanner;

    public BibliotheksConsoleInterface() {
        bibliothek = new Bibliothek();
        BibliotheksFiller.fillBibliothek(bibliothek);
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean aktiv = true;
        while (aktiv) {
            System.out.println("Wählen Sie eine Option:");
            System.out.println("(1) Buch ausleihen");
            System.out.println("(2) Buch zurückgeben");
            System.out.println("(3) Beenden");
            int auswahl = scanner.nextInt();
            scanner.nextLine(); // Nächste Zeile lesen, um den Zeilenumbruch zu entfernen

            switch (auswahl) {
                case 1:
                    buchAusleihen();
                    break;
                case 2:
                    buchZurueckgeben();
                    break;
                case 3:
                    aktiv = false;
                    break;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }

    private void buchAusleihen() {
        System.out.println("Verfügbare Bücher:");
        for (Buch buch : bibliothek.getBuecher()) {
            if (buch.isVerfuegbar()) {
                System.out.println("ISBN: " + buch.getIsbn() + " - Titel: " + buch.getTitel());
            }
        }
        System.out.println("Geben Sie die ISBN des Buches ein, das Sie ausleihen möchten:");
        String isbn = scanner.nextLine();

        System.out.println("Verfügbare Nutzer:");
        for (Nutzer nutzer : bibliothek.getNutzer()) {
            System.out.println("Nutzer-ID: " + nutzer.getNutzerID() + " - Name: " + nutzer.getName());
        }
        System.out.println("Geben Sie die Nutzer-ID ein:");
        String nutzerId = scanner.nextLine();
        try {
            bibliothek.buchAnNutzerAusleihen(isbn, nutzerId);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void buchZurueckgeben() {
        System.out.println("Nutzer, die Bücher ausgeliehen haben:");
        for (Nutzer nutzer : bibliothek.getNutzer()) {
            if (!nutzer.getAusgelieheneBuecher().isEmpty()) {
                System.out.println("Nutzer-ID: " + nutzer.getNutzerID() + " - Name: " + nutzer.getName());
            }
        }
        System.out.println("Geben Sie die Nutzer-ID des Rückgebers ein:");
        String nutzerId = scanner.nextLine();

        System.out.println("Bücher, die von " + nutzerId + " ausgeliehen wurden:");
        Nutzer nutzer = bibliothek.getNutzer().stream().filter(n -> n.getNutzerID().equals(nutzerId)).findFirst().orElse(null);
        if (nutzer != null) {
            for (Buch buch : nutzer.getAusgelieheneBuecher()) {
                System.out.println("ISBN: " + buch.getIsbn() + " - Titel: " + buch.getTitel());
            }
        }

        System.out.println("Geben Sie die ISBN des Buches ein, das zurückgegeben werden soll:");
        String isbn = scanner.nextLine();

        try {
            bibliothek.buchVonNutzerZuruecknehmen(isbn, nutzerId);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}