import java.util.ArrayList;

public abstract class NPC extends Entety {
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
    public void speak(int index){
        if(dialog==null){
            System.out.println(this.getName()+": ...");
            return;
        }
        else{
            System.out.println(this.getName()+": "+dialog.get(index));
            dialog.remove(index);
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

    public abstract void speak();
}
