import java.util.List;

public class Tower {
    private int anzahlLandebahn;

    public int anfordernLandebahn(int flugzeugId) throws InterruptedException {
        while (true) {
            for (int i = 0; i < Flughafen.ANZAHL_LANDEBAHNEN; i++) {
                if (Flughafen.bahnLock[i].tryAcquire()) {
                    try {
                        if (!Flughafen.bahnGesperrt[i] && Flughafen.landebahnen[i].tryAcquire()) {
                            return i;
                        }
                    } finally {
                        Flughafen.bahnLock[i].release();
                    }
                }
            }
            System.out.println("Flugzeug " + flugzeugId + " wartet auf eine Landebahn.");
            Thread.sleep(100);
        }
    }
}
