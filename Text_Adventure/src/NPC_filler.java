public class NPC_filler extends NPC {
    public NPC_filler(String name, String description, Location location) {
        super(name, description, location);
    }

    @Override
    public void speak(){
        System.out.println(getName() + ": " + NPCDialog.getRandomQuote());
    }
}
