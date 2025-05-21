import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Flughafen {

    public static final int ANZAHL_FLUGZEUGE = 3;
    public static final int ANZAHL_LANDEBAHNEN = 2;

    public static final Semaphore[] landebahnen = new Semaphore[ANZAHL_LANDEBAHNEN];
    public static final boolean[] bahnGesperrt = new boolean[ANZAHL_LANDEBAHNEN];
    public static final Semaphore[] bahnLock = new Semaphore[ANZAHL_LANDEBAHNEN];

    static {
        for (int i = 0; i < ANZAHL_LANDEBAHNEN; i++) {
            landebahnen[i] = new Semaphore(1);
            bahnGesperrt[i] = false;
            bahnLock[i] = new Semaphore(1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(ANZAHL_FLUGZEUGE);
        Tower tower = new Tower();
        Feuerwehr feuerwehr = new Feuerwehr();

        for (int i = 1; i <= ANZAHL_FLUGZEUGE; i++) {
            new Thread(new Flieger(i, latch, tower, feuerwehr)).start();
        }

        latch.await();
        System.out.println("Alle Flugzeuge sind am Boden.");
        System.out.println("Flughafen- Simulation abgeschlossen.");
    }
}
