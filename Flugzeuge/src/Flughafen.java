import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Flughafen {
    private Tower tower;
    private int landebahn;

    public Flughafen() {
        tower=new Tower();
    }
    public static void main(String[] args) {
        int anzahlFlieger=5;
        CountDownLatch latch=new CountDownLatch(anzahlFlieger);
    }
}
