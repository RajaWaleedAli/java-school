import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class NPC extends Entety {
    ArrayList<String> dialog;
    Location location;
    boolean defaultMsg;
    public NPC(String name, String description, Location location) {
        super(name, description);
        this.location = location;
        dialog = new ArrayList<>();
        defaultMsg = false;
    }

    public void addDialog(String dialog) {
        this.dialog.add(dialog);
    }
    public void removeDialog(String dialog) {
        this.dialog.remove(dialog);
    }
    public void speak(){
        if(defaultMsg){
            System.out.println(this.getName()+": ...");
        }
        else{
            for(int i=0; i<dialog.size(); i++){
                System.out.println(this.getName()+": "+dialog.get(i));
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            defaultMsg = true;
        }

    }

    public void resetNPC(){
        this.setDefaultMsg(false);
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

    public boolean isDefaultMsg() {
        return defaultMsg;
    }

    public void setDefaultMsg(boolean defaultMsg) {
        this.defaultMsg = defaultMsg;
    }

}
