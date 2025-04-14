public class Ticket {
    private final String id;
    private final Station start;
    private final Station destination;
    private final double price;

    public Ticket(String id, Station start, Station destination, double price) {
        this.id = id;
        this.start = start;
        this.destination = destination;
        this.price = price;
    }
}
