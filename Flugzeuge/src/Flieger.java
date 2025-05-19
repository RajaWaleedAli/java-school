import java.util.concurrent.CountDownLatch;

public class Flieger extends Thread {
    private final String name;
    private final CountDownLatch latch;
    private final Tower tower;

    public Flieger(String name, CountDownLatch latch, Tower tower) {
        this.name = name;
        this.latch = latch;
        this.tower = tower;
    }

    @Override
    public void run(){
        try {
            int flugzeit = 1000 + (int) (Math.random() * 3000);
            System.out.println(name + " fliegt für " + flugzeit + " ms.");
            Thread.sleep(flugzeit);
        }catch (InterruptedException e){
            System.out.println(name + " wurde unterbrochen.");
        }finally {
            latch.countDown();
        }
    }
}
