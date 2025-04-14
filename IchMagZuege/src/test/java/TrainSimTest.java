import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class TrainSimTest {

    private Train train;
    private CargoWagon cargoWagon;
    private PassengerWagon passengerWagon;
    private Station station;
    private Ticket ticket;

    @Before
    public void setUp() {
        train = new Train("Train1", 2);
        cargoWagon = new CargoWagon("Cargo1", 1000);
        passengerWagon = new PassengerWagon("Passenger1", 10);
        station = new Station("Central Station");
        ticket = new Ticket("T1", station, new Station("North Station"), 50.0);
    }

    @Test
    public void testAddWagon_Success() {
        train.addWagon(cargoWagon);
        train.addWagon(passengerWagon);
        assertEquals(2, train.getWagons().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testAddWagon_ExceedsCapacity() {
        train.addWagon(cargoWagon);
        train.addWagon(passengerWagon);
        train.addWagon(new CargoWagon("Cargo2", 500)); // Sollte eine Exception werfen
    }

    @Test
    public void testLoadCargo_Success() {
        cargoWagon.loadCargo(500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoadCargo_ExceedsWeight() {
        cargoWagon.loadCargo(1100); // Sollte eine Exception werfen
    }

    @Test
    public void testSellTicket_Success() {
        passengerWagon.sellTicket(ticket);
        passengerWagon.sellTicket(new Ticket("T2", station, new Station("East Station"), 30.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellTicket_WagonFull() {
        for (int i = 0; i < 11; i++) {
            passengerWagon.sellTicket(new Ticket("T" + i, station, new Station("West Station"), 25.0));
        }
    }

    @Test
    public void testRegisterArrivalAndDeparture() {
        station.registerArrival(train);
        station.registerDeparture(train);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoute_MaxStationsExceeded() {
        new Route(Arrays.asList(new Station("S1"), new Station("S2"), new Station("S3"), new Station("S4"), new Station("S5"), new Station("S6")));
    }

    @After
    public void tearDown() {
        train = null;
        cargoWagon = null;
        passengerWagon = null;
        station = null;
        ticket = null;
    }
}
