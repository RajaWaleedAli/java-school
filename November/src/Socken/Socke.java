package Socken;

public class Socke {
    String farbe;
    boolean istTrocken;
    Socke(String farbe) {
        this.farbe = farbe;
        this.istTrocken = true;
    }
    private boolean istTrocken() {
        return istTrocken;
    }
    public void trockne(){
        istTrocken = true;
    }
}
