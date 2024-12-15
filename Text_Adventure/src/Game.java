/*
    Autor: Raja Waleed Ali
    Text (zb Beschreibungen) von ChatGPT generiert
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Hauptklasse.
*/

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        // Hauptklasse
        ArrayList<Location> locations = new ArrayList<>();

        // Locations erstellen
        Location tor = new Location("Schattenhaftes Tor", "Ein massives Tor, verziert mit mystischen Runen.", null);
        Location marktplatz = new Location("Verfallener Marktplatz", "Ruinen alter Marktstände und verbrannte Fassaden umgeben dich.", null);
        Location kapelle = new Location("Kapelle der Flüsternden", "Eine halb zerstörte Kapelle, in der Schatten flüstern.", null);
        Location friedhof = new Location("Friedhof der Vergessenen", "Grabsteine und Nebel so weit das Auge reicht.", null);
        Location gassen = new Location("Gassen des Zwielichts", "Enge, dunkle Pfade voller Schatten.", null);
        Location turm = new Location("Turm der Asche", "Ein endloser Turm, dessen Spitze in Dunkelheit gehüllt ist.", null);

        locations.add(tor);
        locations.add(marktplatz);
        locations.add(kapelle);
        locations.add(friedhof);
        locations.add(gassen);
        locations.add(turm);

        marktplatz.setLastLocation(tor);
        kapelle.setLastLocation(tor);
        friedhof.setLastLocation(kapelle);
        gassen.setLastLocation(marktplatz);
        turm.setLastLocation(gassen);

        // Verbindungen zwischen Locations (Exits)
        tor.addExit(new Exit("Verfallener Marktplatz", "Ein Weg führt zum Marktplatz.", marktplatz));
        tor.addExit(new Exit("Kapelle der Flüsternden", "Ein Pfad zur zerstörten Kapelle.", kapelle));

        marktplatz.addExit(new Exit("Schattenhaftes Tor", "Ein Pfad zurück zum Tor.", tor));
        marktplatz.addExit(new Exit("Gassen des Zwielichts", "Ein dunkler Durchgang führt tiefer in die Stadt.", gassen));

        kapelle.addExit(new Exit("Schattenhaftes Tor", "Ein Pfad zurück zum Tor.", tor));
        kapelle.addExit(new Exit("Friedhof der Vergessenen", "Ein Weg führt zum Friedhof.", friedhof));

        gassen.addExit(new Exit("Verfallener Marktplatz", "Ein Pfad zurück zum Marktplatz.", marktplatz));
        gassen.addExit(new Exit("Turm der Asche", "Ein Pfad zum dunklen Turm.", turm));

        friedhof.addExit(new Exit("Kapelle der Flüsternden", "Ein Pfad zurück zur Kapelle.", kapelle));
        turm.addExit(new Exit("Gassen des Zwielichts", "Ein Pfad zurück zu den Gassen.", gassen));

        // Dinge erstellen
        Thing mondsteinFragment1 = new Thing("Mondstein-Fragment", "Ein blau schimmerndes Fragment des Mondsteins.", marktplatz);
        Thing geisterlaterne = new Thing("Geisterlaterne", "Eine Laterne, die das Unsichtbare sichtbar macht.", kapelle);
        Thing schluesselToten = new Thing("Schlüssel der Toten", "Ein uralter Schlüssel, der Geheimnisse birgt.", friedhof);
        Thing mondsteinFragment5 = new Thing("Mondstein-Fragment", "Das letzte Fragment des Mondsteins.", turm);

        marktplatz.addItems(mondsteinFragment1);
        kapelle.addItems(geisterlaterne);
        friedhof.addItems(schluesselToten);
        turm.addItems(mondsteinFragment5);

        // NPCs erstellen
        NPC waechter = new NPC("Wächter der Schwelle", "Ein geisterhafter Wächter des Tors.", tor);
        dialogWaechter(waechter);
        tor.addNPC(waechter);

        NPC haendler = new NPC("Händler ohne Gesicht", "Ein mysteriöser Gestalt in einer Kapuze.", marktplatz);
        dialogHaendler(haendler);
        marktplatz.addNPC(haendler);

        NPC priesterin = new NPC("Priesterin Seraphina", "Ein durchscheinender Geist in der Kapelle.", kapelle);
        dialogPriesterin(priesterin);
        kapelle.addNPC(priesterin);

        NPC grabwaechter = new NPC("Grabwächter", "Ein knochiges Wesen, das die Toten bewacht.", friedhof);
        dialogGrabwaechter(grabwaechter);
        friedhof.addNPC(grabwaechter);

        NPC schattenfuerst = new NPC("Schattenfürst", "Der finstere Herrscher von Eldoria.", turm);
        dialogSchattenfuerst(schattenfuerst);
        turm.addNPC(schattenfuerst);

        // Filler-NPCs hinzufügen
        NPC_filler bettler = new NPC_filler("Alter Bettler", "Ein ärmlicher Mann, der im Schatten sitzt.", marktplatz);
        NPC_filler kind = new NPC_filler("Verlorenes Kind", "Ein ängstliches Kind, das herumirrt.", gassen);
        NPC_filler witwe = new NPC_filler("Weinende Witwe", "Eine Frau, die einsam auf einem Grabstein sitzt.", friedhof);
        NPC_filler wanderer = new NPC_filler("Stummer Wanderer", "Ein schweigsamer Mann, der den Horizont beobachtet.", tor);
        NPC_filler rattenmeister = new NPC_filler("Rattenmeister", "Ein Mann, der Ratten wie Freunde behandelt.", gassen);

        // Filler-NPCs zu Locations hinzufügen
        marktplatz.addNPC(bettler);
        gassen.addNPC(kind);
        gassen.addNPC(rattenmeister);
        friedhof.addNPC(witwe);
        tor.addNPC(wanderer);

        // Spieler erstellen
        Player spieler = new Player("Reisender", "Ein Reisender ohne Erinnerung.");
        spieler.setCurrentLocation(tor);

        // Spielstart
        System.out.println("Willkommen in Eldoria...");
        System.out.println(tor.getDescription());

        String kampfEntscheidungText =
            """
            Die Luft um dich herum verdichtet sich. Dunkle Nebelschwaden kriechen über den kalten Steinboden des Turms,
            während der Schattenfürst vor dir auftaucht. Seine Gestalt scheint aus der Dunkelheit selbst zu bestehen, 
            ein Flimmern von Schatten und Glut.
    
            "Du wagst es, mir die Stirn zu bieten?" hallt seine Stimme, tief und schwer, durch den Raum. 
            Es ist, als würde die Dunkelheit selbst zu dir sprechen.
    
            Du spürst, wie die kalte Angst in deine Knochen kriecht, doch etwas in dir weigert sich nachzugeben. 
            Vielleicht ist es der Drang zu überleben. Vielleicht die Sehnsucht nach Erlösung. Oder vielleicht einfach 
            der unbändige Wunsch, diesem Albtraum ein Ende zu setzen.
    
            Mit zitternden Händen, aber festem Griff ziehst du die Geisterlaterne hervor, deren Licht in der Dunkelheit aufflackert. 
            Die Schatten um dich herum zucken zurück, wütend und ängstlich zugleich. Der Schattenfürst zögert, seine Feueraugen blitzen, 
            und du siehst: Er ist nicht unverwundbar.
    
            "Ein Narr bist du, Reisender. Ein Narr, der gegen die Dunkelheit selbst kämpfen will."
    
            Doch du antwortest nicht. Du stehst, eine Silhouette des Lichts im Meer der Schatten, und bereitest dich auf das Unvermeidliche vor.
    
            Der Boden beginnt zu beben. Flammen züngeln aus den Mauerrissen, während der Schattenfürst seine Arme hebt, um seine Macht zu entfesseln. 
            Der Turm bebt unter seiner Wut, und es fühlt sich an, als würde die Welt in zwei Hälften gerissen.
    
            Es gibt kein Zurück mehr.
    
            Mit einem Kampfschrei auf den Lippen stürzt du dich vorwärts – ein einzelnes Licht, das den Schatten herausfordert. 
            Dein Herz hämmert, deine Sinne sind scharf. Die Klinge in deiner Hand spiegelt die letzten Funken Hoffnung wider, die du in dir trägst.
    
            "Für Eldoria... oder für mich selbst – ich werde kämpfen!"
            """;

        boolean start=true;
        boolean firstTor=true;
        boolean firstMarktplatz=true;
        boolean firstKapelle=true;
        boolean firstFriedhof=true;
        boolean firstTurm=true;
        boolean firstGassen=true;

        int tempMode=0;

        while(true){
            if(start){
                System.out.println("===============");
                System.out.println("Einst war Eldoria ein blühendes Königreich voller Magie und Wissen,\n"+
                        "doch vor vielen Jahrhunderten legte sich ein dunkler Fluch über das Land.\n"+
                        "Heute liegt die einst prachtvolle Stadt verlassen und in Dunkelheit gehüllt.\n"+
                        "Du, ein namenloser Reisender, wachst ohne Erinnerung an deine Vergangenheit am Tor der Stadt auf.\n"+
                        "Eine mystische Stimme flüstert dir zu:\n"+
                        "\"Finde die fünf Fragmente des Mondsteins und brich den Fluch von Eldoria.\"");
                System.out.println("===============");
                start=false;
            }
            if(firstTor && spieler.getCurrentLocation().equals(tor)){
                System.out.println("===============");
                System.out.println("Du stehst vor einem massiven, verzierten Tor, dessen Stein von seltsamen Runen bedeckt ist.\n"+
                        "Das Tor knarrt leise im Wind, und dahinter breitet sich eine finstere Stadt aus, die wie ausgestorben wirkt.");
                System.out.println("===============");
                firstTor=false;
            }else if(firstMarktplatz && spieler.getCurrentLocation().equals(marktplatz)){
                System.out.println("===============");
                System.out.println("Ruinen alter Marktstände und verkohlte Fassaden umgeben dich.\n "+
                        "Ab und zu knirscht Holz unter deinen Füßen, und eine kühle Brise lässt die Schatten tanzen.");
                System.out.println("===============");
                firstMarktplatz=false;
            }else if(firstKapelle && spieler.getCurrentLocation().equals(kapelle)){
                System.out.println("===============");
                System.out.println("Das Dach der Kapelle ist eingestürzt, und im Inneren tanzen Schatten an den Wänden.\n"+
                        "Eine fremdartige Stimme flüstert dir unverständliche Worte zu.");
                System.out.println("===============");
                firstKapelle=false;
            }else if(firstFriedhof && spieler.getCurrentLocation().equals(friedhof)){
                boolean foundKey=false;
                for(Thing x:spieler.getInventory().getThings()){
                    if(x.equals(geisterlaterne)){
                        foundKey=true;
                    }
                }
                if(foundKey) {
                    System.out.println("===============");
                    System.out.println("Reihen alter, moosbedeckter Grabsteine erstrecken sich bis zum Horizont.\n" +
                            "Ein kühler Nebel wabert zwischen den Gräbern, und es herrscht eine erdrückende Stille.");
                    System.out.println("===============");
                    firstFriedhof = false;
                }else{
                    System.out.println("===============");
                    System.out.println("Du kannst diese Gegend noch nicht betreten!\nSuche nach Hinweise!");
                    System.out.println("===============");
                    spieler.setCurrentLocation(friedhof.getLastLocation());
                }
            }else if(firstTurm && spieler.getCurrentLocation().equals(turm)){
                boolean foundKey=false;
                for(Thing x:spieler.getInventory().getThings()){
                    if(x.equals(schluesselToten)){
                        foundKey=true;
                    }
                }
                if(foundKey) {
                System.out.println("===============");
                System.out.println("Der Turm wirkt endlos.\n"+
                        "Asche und Staub regnen von den Wänden herab.\n"+
                        "Ein blaues Leuchten dringt aus dem obersten Stockwerk.");
                System.out.println("===============");
                firstTurm=false;
                }else {
                    System.out.println("===============");
                    System.out.println("Du kannst diese Gegend noch nicht betreten!\nSuche nach Hinweise!");
                    System.out.println("===============");
                    spieler.setCurrentLocation(turm.getLastLocation());
                }
            }else if(firstGassen && spieler.getCurrentLocation().equals(gassen)){
                System.out.println("===============");
                System.out.println("Die engen Gassen schlängeln sich zwischen den verfallenen Gebäuden.\n"+
                        "Dunkle Gestalten huschen durch die Schatten, und der Boden ist rutschig von Regen.");
                System.out.println("===============");
                firstGassen=false;
            }

            if(tempMode==5&&spieler.getCurrentLocation().equals(turm)){
                int choice=0;
                boolean foundKey1=false;
                boolean foundKey2=false;
                for(Thing x:spieler.getInventory().getThings()){
                    if(x.equals(mondsteinFragment1)){
                        foundKey1=true;
                    }
                    if (x.equals(mondsteinFragment5)){
                        foundKey2=true;
                    }
                }
                if(foundKey1 && foundKey2) {
                    do {
                        System.out.println("===============");
                        System.out.println("\n[1] Brich den Fluch von Eldoria und befreie die Stadt\n" +
                                "[2] Nutze den Mondstein für dich selbst und herrsche über die Schatten.");
                        System.out.println("===============");
                        choice = Read.parseWithDefault(Read.read(), 0);
                    } while (choice == 0);
                    if(choice==1){
                        endeBefreien();
                    }else if(choice==2){
                        int modeEnd;
                        System.out.println(kampfEntscheidungText);
                        if(RPS.RockPaperScissors(Read.read())){
                            endeSelbstrettungSieg();
                            spieler.getCurrentLocation().removeNPC(schattenfuerst);
                            do {
                                System.out.println("Moechtest du weiter spielen?\n" +
                                        "[1] Ja!\n" +
                                        "[2] Beenden + Speichern!\n" +
                                        "[3] Beenden!");
                                modeEnd = Read.parseWithDefault(Read.read(), 0);
                            }while (modeEnd<1||modeEnd>3);
                            if(modeEnd==2){
                                Save.saveGame(spieler);
                                System.out.println("Spiel wird Beendet!");
                                System.exit(0);
                            }else if(modeEnd==3){
                                System.out.println("Spiel wird Beendet!");
                                System.exit(0);
                            }
                        }else{
                            endeSelbstrettungNiederlage();
                            do {
                                System.out.println("Moechtest du weiter spielen?\n" +
                                        "[1] Ja!(Alte Spielstand laden)\n" +
                                        "[2] Beenden!");
                                modeEnd = Read.parseWithDefault(Read.read(), 0);
                            }while (modeEnd<1||modeEnd>2);
                            if(modeEnd==1){
                                spieler=LoadGame.loadGame();
                                for(Location temp:locations){
                                    if(temp.getName().equals(spieler.getCurrentLocation().getName())){
                                        spieler.setCurrentLocation(temp);
                                    }
                                }
                            }else if(modeEnd==2){
                                System.out.println("Spiel wird Beendet!");
                                System.exit(0);
                            }
                        }
                    }
                }
            }

            int mode=Read.askMode(spieler);
            tempMode=mode;
            if(mode==-1){
                System.out.println("Spiel wird Beendet!");
                System.exit(0);
            }else if(mode==-2){
                System.out.println("Fehler beim speichern!");
                System.exit(-2);
            }else if(mode==8){
                spieler=LoadGame.loadGame();
                for(Location temp:locations){
                    if(temp.getName().equals(spieler.getCurrentLocation().getName())){
                        spieler.setCurrentLocation(temp);
                    }
                }
            }
        }
    }
    private static void dialogWaechter(NPC waechter) {
        waechter.addDialog("Willkommen in Eldoria, Reisender...");
        waechter.addDialog("Findest du die Fragmente des Mondsteins?");
        waechter.setDefaultMsg(false);
    }

    private static void dialogHaendler(NPC haendler) {
        haendler.addDialog("Ich tausche... aber nur das, was mir wertvoll erscheint.");
        haendler.setDefaultMsg(false);
    }

    private static void dialogPriesterin(NPC priesterin) {
        priesterin.addDialog("Suchst du Licht in der Dunkelheit? Die Geister werden dir folgen...");
        priesterin.setDefaultText("Die Laterne wird den verborgenen Weg zeigen.");
        priesterin.setDefaultMsg(false);
    }

    private static void dialogGrabwaechter(NPC grabwaechter) {
        grabwaechter.addDialog("Die Toten bewachen ihre Geheimnisse... bist du bereit, den Preis zu zahlen?");
        grabwaechter.addDialog("Fünf Fragmente, Reisender... die Erlösung naht.");
        grabwaechter.setDefaultMsg(false);
    }

    private static void dialogSchattenfuerst(NPC schattenfuerst) {
        schattenfuerst.addDialog("Du hast die Fragmente gesammelt... doch was wirst du tun?");
        schattenfuerst.setDefaultMsg(false);
    }

    // Ende 1: Die Stadt befreien
    public static void endeBefreien() {
        System.out.println("\n--- ENDE: DIE BEFREIUNG VON ELDORIA ---");
        System.out.println("Du hältst den Mondstein hoch und sprichst die uralten Worte, die der Schattenfürst verborgen hielt.");
        System.out.println("Ein blendendes Licht durchströmt die Stadt, die Dunkelheit weicht und Eldoria erblüht in altem Glanz.");
        System.out.println("Die Geister sind befreit, die Schatten verbannt, und du wirst als Held gefeiert.");
        System.out.println("Doch dein Name bleibt vergessen, nur die Legende lebt fort...");
    }

    // Ende 2: Selbstrettung (Sieg gegen den Fürsten)
    public static void endeSelbstrettungSieg() {
        System.out.println("\n--- ENDE: DER SIEG ÜBER DIE SCHATTEN ---");
        System.out.println("Mit aller Kraft und dem Mondstein als Waffe bezwingst du den Schattenfürst im letzten Kampf.");
        System.out.println("Die Dunkelheit zerfällt zu Staub, doch die Stadt bleibt in Ruinen zurück.");
        System.out.println("Du entkommst Eldoria mit deinem Leben und dem Mondstein – ein Artefakt unvorstellbarer Macht.");
        System.out.println("Dein Herz bleibt schwer, aber die Welt liegt dir zu Füßen...");
    }

    // Ende 3: Selbstrettung (Niederlage gegen den Fürsten)
    public static void endeSelbstrettungNiederlage() {
        System.out.println("\n--- ENDE: DER FALL DES REISENDEN ---");
        System.out.println("Du kämpfst verzweifelt gegen den Schattenfürst, doch seine Macht ist überwältigend.");
        System.out.println("Mit einem letzten Hieb verschlingt dich die Dunkelheit, und Eldoria fällt tiefer in den Fluch.");
        System.out.println("Die Stadt bleibt verloren, dein Name vergessen. Nur die Schatten erinnern sich an deinen Mut...");
    }
}
