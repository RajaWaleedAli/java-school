import java.util.concurrent.Semaphore;

class Parkhaus {
    private final Semaphore parkplaetze;

    public Parkhaus(int anzahlPlaetze) {
        this.parkplaetze = new Semaphore(anzahlPlaetze);
    }

    public void parken(String autoName) {
        try {
            while(!parkplaetze.tryAcquire()){
                System.out.println(autoName + " wartet...");
                Thread.sleep(1000);
            }
            System.out.println(autoName + " hat geparkt.");
            Thread.sleep((int) (Math.random() * 5000 + 1000));
            System.out.println(autoName + " fährt weg.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            parkplaetze.release();
        }
    }
}

