import java.util.ArrayList;

public class NPC extends Entety {
    ArrayList<String> dialog;
    Location location;
    public NPC(String name, String description, Location location) {
        super(name, description);
        this.location = location;
        dialog = new ArrayList<>();
    }

    public void addDialog(String dialog) {
        this.dialog.add(dialog);
    }
    public void removeDialog(String dialog) {
        this.dialog.remove(dialog);
    }
    public void speak(boolean inOrder){
        if(inOrder){

        }

    }

    //Getter-Setter
    public ArrayList<String> getDialog() {
        return dialog;
    }

    public void setDialog(ArrayList<String> dialog) {
        this.dialog = dialog;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
