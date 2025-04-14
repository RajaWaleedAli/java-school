import java.util.ArrayList;
import java.util.List;

public class Train {
    private final String id;
    private final int maxCapacity;
    private final List<Wagon> wagons;

    public Train(String id, int maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.wagons = new ArrayList<>();
    }

    public void addWagon(Wagon wagon) {
        if (wagons.size() >= maxCapacity) {
            throw new IllegalStateException("Maximale Kapazität erreicht");
        }
        wagons.add(wagon);
    }

    public List<Wagon> getWagons() {
        return wagons;
    }
}
