import java.util.ArrayList;
import java.util.List;

public class Station {
    private final String name;
    private final List<Train> arrivingTrains;
    private final List<Train> departingTrains;

    public Station(String name) {
        this.name = name;
        this.arrivingTrains = new ArrayList<>();
        this.departingTrains = new ArrayList<>();
    }

    public void registerArrival(Train train) {
        arrivingTrains.add(train);
    }

    public void registerDeparture(Train train) {
        departingTrains.add(train);
    }
}
