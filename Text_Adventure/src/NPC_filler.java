/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Non Player Characters die nichts mit der story zu tun haben
*/

public class NPC_filler extends NPC {
    public NPC_filler(String name, String description, Location location) {
        super(name, description, location);
    }

    @Override
    public void speak(){
        System.out.println(getName() + ": " + NPCDialog.getRandomQuote());
    }
}
