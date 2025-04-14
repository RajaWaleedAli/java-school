package org.example.interfaces;

import org.example.Buch;
import org.example.exceptions.BuchNichtGefundenException;
import org.example.exceptions.BuchNichtVerfuegbarException;

import java.util.List;

public interface INutzer {
    String getNutzerID();
    void setNutzerID(String nutzerID);

    String getName();
    void setName(String name);

    List<Buch> getAusgelieheneBuecher();

    void buchAusleihen(Buch buch) throws BuchNichtVerfuegbarException;
    void buchZurueckgeben(Buch buch) throws BuchNichtGefundenException;
}
