import java.util.ArrayList;
import java.util.List;

class Ship implements IShip {
    private int ID;
    private double fuel;
    private Port currentPort;
    List<Container> containers;

    public Ship(int ID, Port currentPort) {
        this.ID = ID;
        this.fuel = 0.0;
        this.currentPort = currentPort;
        this.containers = new ArrayList<>();
    }

    @Override
    public void loadContainer(Container container) {
        containers.add(container);
        currentPort.removeContainer(container);
        System.out.println("Container loaded successfully.");
    }

    @Override
    public void unloadContainer(Container container) {
        containers.remove(container);
        currentPort.addContainer(container);
        System.out.println("Container unloaded successfully.");
    }

    @Override
    public void sailToPort(Port port) {
        double distance = currentPort.getDistance(port);
        double fuelConsumption = containers.stream().mapToDouble(Container::consumption).sum();
        if (fuelConsumption <= fuel) {
            fuel -= fuelConsumption;
            currentPort.removeShipFromCurrent(this);
            currentPort = port;
            port.addShipToCurrent(this);
            System.out.println("Ship sailed to the new port successfully.");
        } else {
            System.out.println("Insufficient fuel to sail to the new port.");
        }
    }

    @Override
    public void refuelShip(double fuelAmount) {
        fuel += fuelAmount;
        System.out.println("Ship refueled successfully.");
    }
}