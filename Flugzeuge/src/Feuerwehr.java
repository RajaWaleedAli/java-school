public class Feuerwehr {

    public void loeschen(int bahn, Tower tower) throws InterruptedException {
        System.out.println("🚒 Tatü Tata die Feuerwehr ist da 🚒");
        Thread.sleep(1000 + (int) (Math.random() * 2000));
        System.out.println("Feuerwehr hat Landebahn " + bahn + " gelöscht.");

        Flughafen.bahnLock[bahn].acquire();
        Flughafen.bahnGesperrt[bahn] = false;
        Flughafen.bahnLock[bahn].release();

        tower.bahnFreigeben(bahn);
    }
}