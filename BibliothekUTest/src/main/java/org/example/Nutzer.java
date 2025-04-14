package org.example;

import org.example.exceptions.BuchNichtGefundenException;
import org.example.exceptions.BuchNichtVerfuegbarException;
import org.example.interfaces.INutzer;

import java.util.ArrayList;
import java.util.List;

public class Nutzer implements INutzer {
    private String nutzerID;
    private String name;
    private List<Buch> ausgelieheneBuecher = new ArrayList<>();

    public Nutzer(String nutzerID, String name) {
        this.nutzerID = nutzerID;
        this.name = name;
    }

    // Getter und Setter
    public String getNutzerID() { return nutzerID; }
    public void setNutzerID(String nutzerID) { this.nutzerID = nutzerID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Buch> getAusgelieheneBuecher() { return ausgelieheneBuecher; }

    // Methoden
    public void buchAusleihen(Buch buch) throws BuchNichtVerfuegbarException {
        if (buch.isVerfuegbar()) {
            ausgelieheneBuecher.add(buch);
            buch.ausleihen();
        } else {
            throw new BuchNichtVerfuegbarException("Buch '" + buch.getTitel() + "' ist nicht verfügbar.");
        }
    }

    public void buchZurueckgeben(Buch buch) throws BuchNichtGefundenException {
        if (ausgelieheneBuecher.remove(buch)) {
            buch.zurueckgeben();
        }else{
            throw new BuchNichtGefundenException("Buch mit ISBN " + buch.getIsbn() + " wurde nicht gefunden.");
        }
    }
}
