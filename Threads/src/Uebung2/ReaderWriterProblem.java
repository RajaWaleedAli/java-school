package Uebung2;

import java.util.concurrent.Semaphore;

public class ReaderWriterProblem {

    private static final Semaphore mutex = new Semaphore(1);        // Schützt readCount
    private static final Semaphore writeLock = new Semaphore(1);    // Schreibzugriff synchronisieren

    private static int readCount = 0;
    private static String sharedData = "Initial shared data";

    static class Reader implements Runnable {
        private final int readerId;

        public Reader(int id) {
            this.readerId = id;
        }

        @Override
        public void run() {
            try {
                mutex.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire();
                }
                mutex.release();

                System.out.println("Reader " + readerId + " liest: " + sharedData);
                Thread.sleep(1000);

                mutex.acquire();
                readCount--;
                if (readCount == 0) {
                    writeLock.release();
                }
                mutex.release();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Writer implements Runnable {
        private final int writerId;

        public Writer(int id) {
            this.writerId = id;
        }

        @Override
        public void run() {
            try {
                writeLock.acquire();

                // Schreibbereich
                sharedData = "Daten von Writer " + writerId;
                System.out.println("Writer " + writerId + " schreibt neue Daten.");
                Thread.sleep(1500);

                writeLock.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            new Thread(new Reader(i)).start();
        }

        for (int i = 1; i <= 2; i++) {
            new Thread(new Writer(i)).start();
        }

        for (int i = 4; i <= 6; i++) {
            new Thread(new Reader(i)).start();
        }
    }
}

