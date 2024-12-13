package introClasses.StaticLesson;

public class Rechnerei
{
    public static void einenSpruchSagen(String spruch)
    {
        System.out.println(spruch);
    }
    public static int zweiZahlenAddieren(int zahl1, int zahl2)
    {
        return zahl1+zahl2;
    }
    public static double wurzelZiehen(double zahl)
    {
        double ergebnis = Math.sqrt(zahl);
        return ergebnis;
    }
}