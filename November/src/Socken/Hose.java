package Socken;

import java.awt.*;

public class Hose extends Kleidung {
    Hose(String farbe) {
        super(farbe);
    }
    Hose() {
        this("Schwarz");
    }
    Hose(Color farbe){
        super(farbe);
    }
    @Override
    public void trockne(){
        System.out.println("Hose getrocknet");
        super.trockne();
    }

    @Override
    void setzeWaschZeit(int zeit) {
        this.waschzeit = zeit;
    }
}
