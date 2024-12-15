/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Non Player Characters die etwas mit der story zu tun haben
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class NPC extends Entety {
    ArrayList<String> dialog;
    Location location;
    boolean defaultMsg;
    String defaultText;
    public NPC(String name, String description, Location location) {
        super(name, description);
        this.location = location;
        dialog = new ArrayList<>();
        defaultMsg = false;
        defaultText = "...";
    }

    public void addDialog(String dialog) {
        this.dialog.add(dialog);
    }
    public void removeDialog(String dialog) {
        this.dialog.remove(dialog);
    }
    public void speak(){
        if(defaultMsg){
            System.out.println(this.getName()+": "+defaultText);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== NPC Details ===\n")
                .append("Name: ").append(this.getName() != null ? this.getName() : "Unknown").append("\n")
                .append("Description: ").append(this.getDescription() != null ? this.getDescription() : "None").append("\n")
                .append("Location: ").append(this.location != null ? this.location.getName() : "Unknown").append("\n");
        return sb.toString();
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

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NPC other = (NPC) obj;
        return Objects.equals(this.getName(), other.getName()) &&
                Objects.equals(this.getDescription(), other.getDescription());
    }
}
