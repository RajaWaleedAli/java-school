import java.util.List;

public class Route {
    private final List<Station> stations;

    public Route(List<Station> stations) {
        if (stations.size() > 5) {
            throw new IllegalArgumentException("Maximal 5 Bahnhöfe erlaubt");
        }
        this.stations = stations;
    }
}
