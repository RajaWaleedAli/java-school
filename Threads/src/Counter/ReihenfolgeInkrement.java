package Counter;

public class ReihenfolgeInkrement {
    private static int counter = 0;

    public static void main(String[] args) {
        Thread thread = null;

        for (int i = 0; i < 10; i++) {
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thread = new Thread(() -> {
                synchronized (ReihenfolgeInkrement.class) {
                    counter++;
                    System.out.println("Zählerstand: " + counter);
                }
            });
            thread.start();
        }

        if (thread != null) {
            try {
               thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Endwert: " + counter);
    }
}

