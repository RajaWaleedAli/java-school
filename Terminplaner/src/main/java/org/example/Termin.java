package org.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Termin {
    private String time;
    private int dauer;
    public Termin(String time, int dauer) {
        this.time = time;
        this.dauer = dauer;
    }

    public boolean ueberschneidetSichMit(Termin termin2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime uhrzeit = LocalTime.parse(time, formatter);
        LocalTime uhrzeit1 = LocalTime.parse(termin2.getTime(), formatter);

        if(time.equals(termin2.getTime())){
            return true;
        }else if(uhrzeit.isBefore(uhrzeit1)){
            if(uhrzeit.plusMinutes(dauer).isAfter(uhrzeit1)){
                return true;
            }
        }else if(uhrzeit1.isBefore(uhrzeit)){
            if(uhrzeit1.plusMinutes(termin2.getDauer()).isAfter(uhrzeit)){
                return true;
            }
        }
        return false;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String toString() {
        return "Termin{Startzeit='" + time + "', Dauer=" + dauer + " Minuten}";
    }
}
