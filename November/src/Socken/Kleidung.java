package Socken;

import java.awt.*;

public abstract class Kleidung implements Waschbar {
    Color farbe;
    private boolean istTrocken;
    protected int waschzeit;
    Kleidung(String farbe) {
        this.farbe = stringToColor(farbe);
        this.istTrocken = true;
    }
    Kleidung(Color farbe) {
        this.farbe = farbe;
        this.istTrocken = true;
    }
    Kleidung() {
        this("Black");
    }
    public boolean istTrocken() {
        return istTrocken;
    }

    public void trockne(){
        istTrocken = true;
    }

    public static Color stringToColor(String s ) {
        s.replace(" ","");
        switch (s.toLowerCase()) {
            case "blau":
                return Color.BLUE;
            case "rot":
                return Color.RED;
            case "gruen":
                return Color.GREEN;
            case "weiss":
                return Color.WHITE;
            case "gelb":
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
    }
    public static String colorToString(Color color) {
        if (color.equals(Color.BLUE)) return "Blau";
        if (color.equals(Color.RED)) return "Rot";
        if (color.equals(Color.GREEN)) return "Gruen";
        if (color.equals(Color.BLACK)) return "Schwarz";
        if (color.equals(Color.WHITE)) return "Weiss";
        if (color.equals(Color.YELLOW)) return "Gelb";
        return "Schwarz";
    }
    public void wasche(){
        istTrocken = false;
        this.farbe = farbe.brighter();
    }

    public String getFarbe() {
        return colorToString(farbe);
    }

    public void setFarbe(String farbe) {
        this.farbe = stringToColor(farbe);
    }
    abstract void setzeWaschZeit(int a);

}
