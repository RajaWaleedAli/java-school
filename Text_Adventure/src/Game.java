public class Game {
    public static void main(String[] args) {
        // Locations und Exits erstellen
        Location verlassenerPlatz = new Location("Verlassener Platz", "Ein verlassener, von Nebel umgebener Platz mit zerfallenen Statuen.", null);
        Location bibliothek = new Location("Bibliothek", "Eine verstaubte Bibliothek voller alter Bücher, von denen viele in einer fremden Sprache geschrieben sind.", null);
        Location rathaus = new Location("Rathaus", "Ein verlassenes Gebäude mit zerstörten Möbeln und geheimen Dokumenten.", null);
        Location turm = new Location("Turm", "Ein hoher, zerfallener Turm, von dessen Spitze man den Nebel überblicken kann.", null);
        Location versteck = new Location("Versteck", "Ein geheimer Unterschlupf mit versteckten Fallen und Rätseln.", null);
        Location geheimeHoehle = new Location("Geheime Höhle", "Eine dunkle Höhle voller antiker Zeichnungen, die das Geheimnis der Stadt erklären.", null);

        // Verbindungen zwischen den Orten (Exits) erstellen
        verlassenerPlatz.addExit(new Exit("Bibliothek", "Ein Pfad führt zur Bibliothek.", bibliothek));
        verlassenerPlatz.addExit(new Exit("Rathaus", "Ein Weg führt zum Rathaus.", rathaus));

        bibliothek.addExit(new Exit("Verlassener Platz", "Der Weg zurück zum verlassenen Platz.", verlassenerPlatz));
        bibliothek.addExit(new Exit("Turm", "Ein schmaler Pfad führt zum Turm.", turm));

        rathaus.addExit(new Exit("Verlassener Platz", "Ein Pfad führt zurück zum verlassenen Platz.", verlassenerPlatz));
        rathaus.addExit(new Exit("Versteck", "Eine versteckte Tür führt zu einem geheimen Unterschlupf.", versteck));

        turm.addExit(new Exit("Bibliothek", "Ein Weg führt zurück zur Bibliothek.", bibliothek));

        versteck.addExit(new Exit("Rathaus", "Der Weg zurück zum Rathaus.", rathaus));
        versteck.addExit(new Exit("Geheime Höhle", "Ein schmaler Gang führt in eine dunkle Höhle.", geheimeHoehle));

        geheimeHoehle.addExit(new Exit("Versteck", "Der Weg zurück zum Versteck.", versteck));

        // Items erstellen
        Thing laterne = new Thing("Laterne", "Eine alte Laterne, die Licht spenden kann.", verlassenerPlatz);
        Thing altesBuch = new Thing("Altes Buch", "Ein Buch mit Hinweisen auf die Geschichte der Stadt.", bibliothek);
        Thing schluessel = new Thing("Schlüssel", "Ein alter Schlüssel, der eine versteckte Tür öffnen kann.", bibliothek);
        Thing karte = new Thing("Karte", "Eine grobe Karte mit eingezeichneten Orten.", rathaus);
        Thing fernrohr = new Thing("Fernrohr", "Ein Fernrohr, das verborgene Details in der Ferne zeigt.", turm);
        Thing kristall = new Thing("Kristall", "Ein mysteriöser Kristall, der in der Höhle gebraucht wird.", versteck);
        Thing dolch = new Thing("Dolch", "Ein verfluchter Dolch mit einer unbekannten Macht.", geheimeHoehle);

        // Container für zusätzliche Items (falls nötig)
        Container schreibtisch = new Container("Schreibtisch", "Ein alter Schreibtisch mit einer Schublade.", bibliothek);
        schreibtisch.addThing(altesBuch);

        Container truhe = new Container("Truhe", "Eine massive Holztruhe mit Eisenbeschlägen.", versteck);
        truhe.addThing(kristall);

        // Spieler erstellen
        Player spieler = new Player("Reisender", "Ein Reisender ohne Erinnerung.");
        spieler.setCurrentLocation(verlassenerPlatz);

        while(true){
            int mode=Read.askMode(spieler);
            if(mode==-1){
                System.out.println("Spiel wird Beendet!");
                break;
            }
        }
    }
}
