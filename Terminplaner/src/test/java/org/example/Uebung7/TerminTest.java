package org.example.Uebung7;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Termin;
import org.testng.annotations.Test;

public class TerminTest {

    @Test
    void ueberschneidetSichMit_ueberschneidendeTermine() {
        Termin termin1 = new Termin("10:00", 30);
        Termin termin2 = new Termin("10:15", 30);
        assertTrue(termin1.ueberschneidetSichMit(termin2));
    }

    @Test
    void ueberschneidetSichMit_nichtUeberschneidendeTermine() {
        Termin termin1 = new Termin("10:00", 30);
        Termin termin2 = new Termin("10:30", 30);
        assertFalse(termin1.ueberschneidetSichMit(termin2));
    }

    @Test
    void ueberschneidetSichMit_TestMitVerschiedenenZeiten() {
        Termin frueherTermin = new Termin("08:00", 60); // 08:00 bis 09:00
        Termin spaeterTermin = new Termin("09:00", 60); // 09:00 bis 10:00
        assertFalse(frueherTermin.ueberschneidetSichMit(spaeterTermin));
        assertFalse(spaeterTermin.ueberschneidetSichMit(frueherTermin));
    }

    @Test
    void toStringGibtKorrektenStringZurueck() {
        Termin termin = new Termin("10:00", 30);
        String erwarteterString = "Termin{Startzeit='10:00', Dauer=30 Minuten}";
        assertEquals(erwarteterString, termin.toString());
    }
}
