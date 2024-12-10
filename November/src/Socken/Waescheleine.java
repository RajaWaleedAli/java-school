package Socken;

import java.util.ArrayList;

public class Waescheleine {
    private final int MAX=10;
    ArrayList<Kleidung> arrList = new ArrayList<Kleidung>(MAX);
    public void add(Kleidung k) {
        arrList.add(k);
    }
    public Kleidung get(int index){
        return arrList.get(index);
    }
    public int lenght(){
        return arrList.size();
    }
    public void trockne(Kleidung k){
        k.trockne();
        arrList.remove(k);
    }
}
