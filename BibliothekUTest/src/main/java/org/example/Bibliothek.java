package org.example;

import org.example.exceptions.BuchNichtGefundenException;
import org.example.exceptions.BuchNichtVerfuegbarException;
import org.example.exceptions.NutzerNichtGefundenException;
import org.example.interfaces.IBibliothek;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek implements IBibliothek {
    private List<Buch> buecher = new ArrayList<>();
    private List<Nutzer> nutzer = new ArrayList<>();

    // Methoden
    public void buchHinzufuegen(Buch buch) {
        buecher.add(buch);
    }

    public void buchEntfernen(String isbn) {
        buecher.removeIf(b -> b.getIsbn().equals(isbn));
    }

    public void nutzerHinzufuegen(Nutzer neuerNutzer) {
        nutzer.add(neuerNutzer);
    }

    public void nutzerEntfernen(String nutzerID) {
        nutzer.removeIf(n -> n.getNutzerID().equals(nutzerID));
    }

    public void buchAnNutzerAusleihen(String isbn, String nutzerID)
            throws BuchNichtGefundenException, NutzerNichtGefundenException, BuchNichtVerfuegbarException {

        Buch buch = findeBuch(isbn);

        Nutzer n = findeNutzer(nutzerID);

        n.buchAusleihen(buch);
    }

    public void buchVonNutzerZuruecknehmen(String isbn, String nutzerID) throws NutzerNichtGefundenException, BuchNichtGefundenException {
        Buch buch = findeBuch(isbn);
        Nutzer n = findeNutzer(nutzerID);
        n.buchZurueckgeben(buch);
    }

    private Buch findeBuch(String isbn) throws BuchNichtGefundenException {
        for (Buch buch : buecher) {
            if (buch.getIsbn().equals(isbn)) {
                return buch;
            }
        }
        throw new BuchNichtGefundenException("Buch mit ISBN " + isbn + " wurde nicht gefunden.");
    }

    private Nutzer findeNutzer(String nutzerID) throws NutzerNichtGefundenException {
        for (Nutzer n : nutzer) {
            if (n.getNutzerID().equals(nutzerID)) {
                return n;
            }
        }
        throw new NutzerNichtGefundenException("Nutzer mit ID " + nutzerID + " wurde nicht gefunden.");
    }

    public List<Buch> getBuecher() {
        return buecher;
    }

    public void setBuecher(List<Buch> buecher) {
        this.buecher = buecher;
    }

    public List<Nutzer> getNutzer() {
        return nutzer;
    }

    public void setNutzer(List<Nutzer> nutzer) {
        this.nutzer = nutzer;
    }
}
