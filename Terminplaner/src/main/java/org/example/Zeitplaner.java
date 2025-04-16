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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime uhrzeit = LocalTime.parse(time, formatter);
        for (Termin termin : termine) {
            LocalTime uhrzeit1 = LocalTime.parse(termin.getTime(), formatter);
            if (uhrzeit1.equals(uhrzeit)) {
                return false;
            }else if(uhrzeit.isBefore(uhrzeit1)){
                if(uhrzeit.plusMinutes(i).isAfter(uhrzeit1)){
                    return false;
                }
            }else if(uhrzeit1.isBefore(uhrzeit)){
                if(uhrzeit1.plusMinutes(termin.getDauer()).isAfter(uhrzeit)){
                    return false;
                }
            }
        }
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
