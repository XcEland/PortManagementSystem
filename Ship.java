import java.util.ArrayList;

public class Ship implements IShip {

    private int ID;
    private double fuel;
    private Port currentPort;
    private int totalWeightCapacity;
    private int maxNumberOfAllContainers;
    private int maxNumberOfHeavyContainers;
    private int maxNumberOfRefrigeratedContainers;
    private int maxNumberOfLiquidContainers;
    private double fuelConsumptionPerKM;
    private ArrayList<Container> containers;

    public Ship(int ID, Port p, int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int maxNumberOfRefrigeratedContainers, int maxNumberOfLiquidContainers, double fuelConsumptionPerKM) {
        this.ID = ID;
        this.currentPort = p;
        this.totalWeightCapacity = totalWeightCapacity;
        this.maxNumberOfAllContainers = maxNumberOfAllContainers;
        this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
        this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
        this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
        this.containers = new ArrayList<>();
    }

    @Override
    public boolean sailTo(Port p) {
        double distance = currentPort.getDistance(p);
        double fuelRequired = distance * fuelConsumptionPerKM;

        if (fuel >= fuelRequired) {
            fuel -= fuelRequired;
            currentPort = p;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reFuel(double newFuel) {
        fuel += newFuel;
    }

    @Override
    public boolean load(Container cont) {
        if (containers.size() >= maxNumberOfAllContainers) {
            return false;
        }

        if (cont.weight > totalWeightCapacity) {
            return false;
        }

        if (cont instanceof HeavyContainer) {
            if (containers.size() >= maxNumberOfHeavyContainers) {
                return false;
            }

            if (cont instanceof RefrigeratedContainer) {
                if (containers.size() >= maxNumberOfRefrigeratedContainers) {
                    return false;
                }
            }

            if (cont instanceof LiquidContainer) {
                if (containers.size() >= maxNumberOfLiquidContainers) {
                    return false;
                }
            }
        }

        containers.add(cont);
        return true;
    }

    @Override
    public boolean unLoad(Container cont) {
        if (!containers.contains(cont)) {
            return false;
        }

        containers.remove(cont);
        return true;
    }

    @Override
    public ArrayList<Container> getCurrentContainers() {
        return new ArrayList<>(containers);
    }

    // Getter and setter methods
    public int getID() {
        return ID;
    }

    public double getFuel() {
        return fuel;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public int getTotalWeightCapacity() {
        return totalWeightCapacity;
    }

    public int getMaxNumberOfAllContainers() {
        return maxNumberOfAllContainers;
    }

    public int getMaxNumberOfHeavyContainers() {
        return maxNumberOfHeavyContainers;
    }

    public int getMaxNumberOfRefrigeratedContainers() {
        return maxNumberOfRefrigeratedContainers;
    }

    public int getMaxNumberOfLiquidContainers() {
        return maxNumberOfLiquidContainers;
    }

    public double getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public void setTotalWeightCapacity(int totalWeightCapacity) {
        this.totalWeightCapacity = totalWeightCapacity;
    }

    public void setMaxNumberOfAllContainers(int maxNumberOfAllContainers) {
        this.maxNumberOfAllContainers = maxNumberOfAllContainers;
    }

    public void setMaxNumberOfHeavyContainers(int maxNumberOfHeavyContainers) {
        this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
    }

    public void setMaxNumberOfLiquidContainers(int maxNumberOfLiquidContainers) {
        if (maxNumberOfLiquidContainers < 0) {
            throw new IllegalArgumentException("Max number of liquid containers must be non-negative.");
        }
    
        this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
    }

    public Container findContainerById(int containerId) {
        return null;
    }
}
    
