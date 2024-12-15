/*
    Autor: Raja Waleed Ali
    Klasse: 4BT
    Fach: Informatik
    Datum: 15.12.2024
    Beschreibung: Userinput.
*/

import java.util.Objects;
import java.util.Scanner;

public class Read {
    private static final Scanner sc = new Scanner(System.in);
    public static String read(){
        return sc.nextLine();
    }

    public static int parseWithDefault(String number, int defaultVal) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    public static int askMode(Player player){
        System.out.println("\nWas willst du tun?!");
        int index=0;
        do{
            System.out.println("[1] Print Player Information");
            System.out.println("[2] Print Location Information");
            System.out.println("[3] Print Inventory");
            System.out.println("[4] Select Exit");
            System.out.println("[5] Talk to NPC");
            System.out.println("[6] Drop Item");
            System.out.println("[7] Pick up Item");
            System.out.println("[8] Load Data");
            System.out.println("[9] Save");
            System.out.println("[-1] Quit Game");
            index=parseWithDefault(Read.read(), 0);
            if(index<-1||index>9){
                index=0;
            }
        }while(index==0);
        switch (index){
            case 1:
                System.out.println(player.toString());
                break;
            case 2:
                System.out.println(player.getCurrentLocation().toString());
                break;
            case 3:
                System.out.println(player.getInventory().toString());
                break;
            case 4:
                Exit tempE = Read.readExit(player.getCurrentLocation());
                if(tempE==null||tempE.getDestination()==null){
                    break;
                }else{
                    System.out.println(tempE.getDestination().getDescription());
                    player.move(tempE.getName());
                    for(NPC n:tempE.getDestination().getNPCs()){
                        n.setDefaultMsg(false);
                    }
                }
                break;
            case 5:
                NPC temp=Read.readNPC(player.getCurrentLocation());
                if(temp==null){
                    break;
                }else{
                    temp.speak();
                }
                break;
            case 6:
                Thing thingToRem = Read.readThing(player.getInventory());
                if(thingToRem==null){
                    break;
                }else {
                    player.removeItem(thingToRem,player.getCurrentLocation().getItems());
                }
                break;
            case 7:
                Thing thingToAdd = Read.readThing(player.getCurrentLocation().getItems());
                if(thingToAdd==null){
                    break;
                }else{
                    player.addItem(thingToAdd);
                }
                break;
            case 8:
                break;
            case 9:
                boolean value = Save.saveGame(player);
                if(!value){
                    return -2;
                }
                break;
            case -1:
                sc.close();
                break;
        }
        return index;
    }

    public static Exit readExit(Location location){
        if(location.getExits()==null){
            System.out.println("Keine Ausgaenge!");
            return null;
        }
        String text;
        int control=0;
        do{
            if(control==2){
                System.out.println("Falsche Eingabe! Probiere es noch einmal!");
            }
            System.out.println("Verfuegbare Ausgaenge:\n"+location.getExits().toString());
            text=null;
            text = Read.read();
            for(Exit exit : location.getExits()){
                if(exit.getName().equals(text)){
                    return exit;
                }else {
                    control=2;
                }
            }
        }while (control!=1);
        return null;
    }

    public static Thing readThing(Container container){
        if(container==null||container.getThings().isEmpty()){
            System.out.println("Keine Items Verfuegbar!");
            return null;
        }
        String text;
        int control=0;
        do{
            if(control==2){
                System.out.println("Falsche Eingabe! Probiere es noch einmal!");
            }
            System.out.println("Verfuegbare Gegenstaende:\n"+container.getThings().toString());
            text=null;
            text = Read.read();
            for(Thing x : container.getThings()){
                if(x.getName().equals(text)){
                    control=1;
                    return x;
                }else {
                    control=2;
                }
            }
        }while (control!=1);
        return null;
    }
    public static NPC readNPC(Location location){
        if(location.getNPCs().isEmpty()){
            System.out.println("Keine NPCs!");
            return null;
        }
        String text;
        int control=0;
        do{
            if(control==2){
                System.out.println("Falsche Eingabe! Probiere es noch einmal!");
            }
            System.out.println("Verfuegbare NPCs:\n"+location.getNPCs().toString());
            text=null;
            text = Read.read();
            for(NPC x : location.getNPCs()){
                if(x.getName().equals(text)){
                    control=1;
                    return x;
                }else {
                    control=2;
                }
            }
        }while (control!=1);
        return null;
    }
}
