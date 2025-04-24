package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Zeitplaner {
    private List<Termin> termine;
    public void terminHinzufuegen(String time, int i) {
        termine.add(new Termin(time, i));
    }

    public boolean istTerminBelegt(String time, int i) {
        Termin _termin = new Termin(time,i);
        if(termine.isEmpty()) {
            return false;
        }
        for (Termin termin : termine) {
            if(termin.ueberschneidetSichMit(_termin)){
                return true;
            }
        }
        return false;
    }

    public void terminLoeschen(String time) {
        for (Termin termin : termine) {
            if(termin.getTime().equals(time)) {
                termine.remove(termin);
                break;
            }
        }
    }

    public List<String> alleTermineAnzeigen() {
        List<String> liste = new ArrayList<String>();
        for (Termin termin : termine) {
            liste.add(termin.toString());
        }
        return liste;
    }
}
