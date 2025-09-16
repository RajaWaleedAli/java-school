import java.util.List;

public class Tower {
    public int anfordernLandebahn(int flugzeugId) throws InterruptedException {
        System.out.println("Flugzeug " + flugzeugId + " wartet auf eine Landebahn.");
        while (true) {
            for (int i = 0; i < Flughafen.ANZAHL_LANDEBAHNEN; i++) {
                if (Flughafen.bahnLock[i].tryAcquire()) {
                    try {
                        if (!Flughafen.bahnGesperrt[i] && Flughafen.landebahnen[i].tryAcquire()) {
                            System.out.println("Flugzeug " + flugzeugId + " hat eine Landebahn.");
                            return i;
                        }
                    } finally {
                        Flughafen.bahnLock[i].release();
                    }
                }
            }
            Thread.sleep(100);
        }
    }
    public void abgestuertzt(int flugzeugId, int bahn, Feuerwehr feuerwehr) throws InterruptedException {
        System.out.println("Flugzeug " + flugzeugId + " ist abgestürzt auf Landebahn " + bahn + "!");
        Flughafen.bahnLock[bahn].acquire();
        Flughafen.bahnGesperrt[bahn] = true;
        Flughafen.bahnLock[bahn].release();
        feuerwehr.loeschen(bahn,this);

    }
    public void bahnFreigeben(int bahn){
        Flughafen.landebahnen[bahn].release();
    }
}
