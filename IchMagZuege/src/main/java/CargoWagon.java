public class CargoWagon extends Wagon {
    private final double maxWeight;
    private double currentWeight;

    public CargoWagon(String id, double maxWeight) {
        super(id);
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public void loadCargo(double weight) {
        if (currentWeight + weight > maxWeight) {
            throw new IllegalArgumentException("Maximale Traglast überschritten");
        }
        currentWeight += weight;
    }
}
