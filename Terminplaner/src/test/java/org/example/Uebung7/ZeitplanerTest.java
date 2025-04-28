package org.example.Uebung7;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Zeitplaner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ZeitplanerTest {

    private Zeitplaner planer;

    @BeforeEach
    void setUp() {
        planer = new Zeitplaner();
    }

    @Test
    void terminHinzufuegen_und_PruefenObBelegt() {
        planer.terminHinzufuegen("10:00", 30);
        assertTrue(planer.istTerminBelegt("10:00", 30));
    }

    @Test
    void ueberschneidenderTerminHinzufuegen_wirftException() {
        planer.terminHinzufuegen("10:00", 30);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            planer.terminHinzufuegen("10:15", 30); // Überschneidet sich mit 10:00 - 10:30
        });
        assertEquals("Terminüberschneidung", exception.getMessage());
    }

    @Test
    void terminLoeschen_und_PruefenObNichtMehrBelegt() {
        planer.terminHinzufuegen("10:30", 30);
        planer.terminLoeschen("10:30");
        assertFalse(planer.istTerminBelegt("10:30", 30));
    }

    @Test
    void alleTermineAnzeigen_nachHinzufuegenUndLoeschen() {
        planer.terminHinzufuegen("09:00", 60);
        planer.terminHinzufuegen("10:00", 30);
        planer.terminLoeschen("09:00");
        List<String> termine = planer.alleTermineAnzeigen();

        String erwarteterTerminString = "Termin{Startzeit='10:00', Dauer=30 Minuten}";
        assertTrue(termine.contains(erwarteterTerminString) && termine.size() == 1);
    }

    @Test
    void terminHinzufuegen_mitUngueltigerZeit_wirftException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            planer.terminHinzufuegen("25:00", 30);
        });
        assertEquals("Ungültige Zeitangabe oder Dauer", exception.getMessage());
    }
}
