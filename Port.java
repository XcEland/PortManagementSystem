import java.util.ArrayList;

public class Port implements IPort {

    private String ID;
    private double latitude;
    private double longitude;
    private ArrayList<Container> containers;
    private ArrayList<Ship> history;
    private ArrayList<Ship> current;

    public Port(String ID, double latitude, double longitude) {
        this.ID = ID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.containers = new ArrayList<>();
        this.history = new ArrayList<>();
        this.current = new ArrayList<>();
    }

    @Override
    public void incomingShip(Ship s) {
        if (!current.contains(s)) {
            current.add(s);
        }
    }

    @Override
    public void outgoingShip(Ship s) {
        if (current.contains(s)) {
            current.remove(s);
        }

        if (!history.contains(s)) {
            history.add(s);
        }
    }

    @Override
    public double getDistance(Port other) {
        double distance = Math.sqrt(Math.pow(this.latitude - other.latitude, 2) + Math.pow(this.longitude - other.longitude, 2));
        return distance;
    }

    // Getter and setter methods
    public String getID() {
        return ID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public ArrayList<Ship> getHistory() {
        return history;
    }

    public ArrayList<Ship> getCurrent() {
        return current;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public void setHistory(ArrayList<Ship> history) {
        this.history = history;
    }

    public void setCurrent(ArrayList<Ship> current) {
        this.current = current;
    }
}
