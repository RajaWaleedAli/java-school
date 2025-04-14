import java.util.ArrayList;
import java.util.List;

public class PassengerWagon extends Wagon {
    private final int maxSeats;
    private final List<Ticket> tickets;

    public PassengerWagon(String id, int maxSeats) {
        super(id);
        this.maxSeats = maxSeats;
        this.tickets = new ArrayList<>();
    }

    public void sellTicket(Ticket ticket) {
        if (tickets.size() >= maxSeats) {
            throw new IllegalArgumentException("Waggon ist voll");
        }
        tickets.add(ticket);
    }
}
