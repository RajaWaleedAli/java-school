package org.example.interfaces;

import org.example.Buch;
import org.example.Nutzer;
import org.example.exceptions.BuchNichtGefundenException;
import org.example.exceptions.BuchNichtVerfuegbarException;
import org.example.exceptions.NutzerNichtGefundenException;

import java.util.List;

public interface IBibliothek {
    void buchHinzufuegen(Buch buch);
    void buchEntfernen(String isbn);

    void nutzerHinzufuegen(Nutzer nutzer);
    void nutzerEntfernen(String nutzerID);

    void buchAnNutzerAusleihen(String isbn, String nutzerID)
            throws BuchNichtGefundenException, NutzerNichtGefundenException, BuchNichtVerfuegbarException;

    void buchVonNutzerZuruecknehmen(String isbn, String nutzerID)
            throws BuchNichtGefundenException, NutzerNichtGefundenException;

    List<Buch> getBuecher();
    void setBuecher(List<Buch> buecher);

    List<Nutzer> getNutzer();
    void setNutzer(List<Nutzer> nutzer);
}
