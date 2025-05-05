public class Auto implements Runnable {
    private final Parkhaus parkhaus;
    private final String name;

    public Auto(Parkhaus parkhaus, String name) {
        this.parkhaus = parkhaus;
        this.name = name;
    }

    @Override
    public void run() {
        parkhaus.parken(name);
    }
}
