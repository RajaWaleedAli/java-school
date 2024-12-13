package Socken;

import java.awt.*;

public class Socke extends Kleidung{
    Socke(String farbe) {
        super(farbe);
    }
    Socke() {
        this("Schwarz");
    }
    Socke(Color farbe){
        super(farbe);
    }
    @Override
    public void trockne(){
        System.out.println("Socke getrocknet");
        super.trockne();
    }

    @Override
    void setzeWaschZeit(int zeit) {
        this.waschzeit = zeit;
    }
}
