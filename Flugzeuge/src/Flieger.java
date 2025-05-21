import java.util.concurrent.CountDownLatch;

public class Flieger implements Runnable {
    private final int id;
    private final CountDownLatch latch;
    private final Tower tower;

    Feuerwehr feuerwehr;

    public Flieger(int id, CountDownLatch latch, Tower tower, Feuerwehr feuerwehr) {
        this.id = id;
        this.latch = latch;
        this.tower = tower;
        this.feuerwehr = feuerwehr;
    }

    @Override
    public void run(){
        try {
            int bahn;
            bahn=tower.anfordernLandebahn(id);
            int flugzeit = 1000 + (int) (Math.random() * 3000);
            System.out.println(id + " fliegt für " + flugzeit + " ms.");
            Thread.sleep(flugzeit);

            bahn = tower.anfordernLandebahn(id);

            System.out.println("Flugzeug " + id + " landet auf Landebahn " + bahn + ".");

            if ((Math.random() * 100) < 40) {
                System.out.println("Flugzeug " + id + " ist abgestürzt auf Landebahn " + bahn + "!");
                Flughafen.bahnLock[bahn].acquire();
                Flughafen.bahnGesperrt[bahn] = true;
                Flughafen.bahnLock[bahn].release();
                //Feuerwehr code
            } else {
                Thread.sleep(1000 + (int) (Math.random() * 1000));
                System.out.println("Flugzeug " + id + " ist gelandet auf Landebahn " + bahn + ".");
                Thread.sleep(1000); // fährt in den Hangar
            }

            Flughafen.landebahnen[bahn].release();
        }catch (InterruptedException e){
            System.out.println(id + " wurde unterbrochen.");
        }finally {
            latch.countDown();
        }
    }
}
