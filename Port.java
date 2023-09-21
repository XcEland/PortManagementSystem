import java.util.ArrayList;

class Port<Ship> implements IPort {
    private int ID;
    private double latitude;
    private double longitude;
    ArrayList<Container> containers;
    private ArrayList<Ship> history;
    private ArrayList<Ship> current;

    public Port(int ID, double latitude, double longitude) {
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.containers = new ArrayList<>();
        this.history = new ArrayList<>();
        this.current = new ArrayList<>();
    }

    @Override
    public double getDistance(Port other) {
        // Calculate the distance between this port and another port
        // You can implement the distance calculation logic here
        // For example, you can calculate the Euclidean distance based on latitude and longitude
        double latDiff = Math.abs(this.latitude - other.latitude);
        double lonDiff = Math.abs(this.longitude - other.longitude);
        return Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public void removeContainer(Container container) {
        containers.remove(container);
    }

    public void addShipToCurrent(Ship ship) {
        current.add(ship);
    }

    public void removeShipFromCurrent(Ship ship) {
        current.remove(ship);
    }
}