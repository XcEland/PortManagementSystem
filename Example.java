import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Container {
    private String id;
    private double weight;

    public Container(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Port {
    private double x;
    private double y;
    private String id;

    public Port(double x, double y, String id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    // Getters and setters

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Ship {
    private String id;
    private String portId;
    private double maxWeight;
    private int maxNumContainers;
    private int maxNumHeavyContainers;
    private int maxNumRefrigeratedContainers;
    private int maxNumLiquidContainers;
    private double fuelTankCapacity;
    private double currentFuelLevel;
    private double fuelConsumptionPerKm;

    public Ship(String id, String portId, double maxWeight, int maxNumContainers, int maxNumHeavyContainers,
                int maxNumRefrigeratedContainers, int maxNumLiquidContainers, double fuelTankCapacity,
                double currentFuelLevel, double fuelConsumptionPerKm) {
        this.id = id;
        this.portId = portId;
        this.maxWeight = maxWeight;
        this.maxNumContainers = maxNumContainers;
        this.maxNumHeavyContainers = maxNumHeavyContainers;
        this.maxNumRefrigeratedContainers = maxNumRefrigeratedContainers;
        this.maxNumLiquidContainers = maxNumLiquidContainers;
        this.fuelTankCapacity = fuelTankCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    // Getters and setters

    public Ship(int id2, Port port, int totalWeightCapacity, int maxNumberOfAllContainers,
            int maxNumberOfHeavyContainers, int maxNumberOfRefrigeratedContainers, int maxNumberOfLiquidContainers,
            double fuelTankCapacity2) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxNumContainers() {
        return maxNumContainers;
    }

    public void setMaxNumContainers(int maxNumContainers) {
        this.maxNumContainers = maxNumContainers;
    }

    public int getMaxNumHeavyContainers() {
        return maxNumHeavyContainers;
    }

    public void setMaxNumHeavyContainers(int maxNumHeavyContainers) {
        this.maxNumHeavyContainers = maxNumHeavyContainers;
    }

    public int getMaxNumRefrigeratedContainers() {
        return maxNumRefrigeratedContainers;
    }

    public void setMaxNumRefrigeratedContainers(int maxNumRefrigeratedContainers) {
        this.maxNumRefrigeratedContainers = maxNumRefrigeratedContainers;
    }

    public int getMaxNumLiquidContainers() {
        return maxNumLiquidContainers;
    }

    public void setMaxNumLiquidContainers(int maxNumLiquidContainers) {
        this.maxNumLiquidContainers = maxNumLiquidContainers;
    }

    public double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }
}

public class Example {
    private static List<Container> containers = new ArrayList<>();
    private static List<Port> ports = new ArrayList<>();
    private static List<Ship> ships = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Create a container");
            System.out.println("2. Create a ship");
            System.out.println("3. Create a port");
            System.out.println("4. Load a container to a ship");
            System.out.println("5. Unload a container from a ship");
            System.out.println("6. Sail ship to another port");
            System.out.println("7. Refuel Ship");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createContainer();
                    break;
                case 2:
                    createShip();
                    break;
                case 3:
                    createPort();
                    break;
                case 4:
                    loadContainerToShip();
                    break;
                case 5:
                    unloadContainerFromShip();
                    break;
                case 6:
                    sailShipToPort();
                    break;
                case 7:
                    refuelShip();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
    }

    private static void createContainer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter container ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter container weight: ");
        double weight = scanner.nextDouble();

        Container container = new Container(id, weight);
        containers.add(container);
        System.out.println("Container created successfully.");
    }

    private static void createShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ship ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter initial port ID: ");
        String portId = scanner.nextLine();
        System.out.print("Enter maximum weight of all containers: ");
        double maxWeight = scanner.nextDouble();
        System.out.print("Enter maximum number of all containers: ");
        int maxNumContainers = scanner.nextInt();
        System.out.print("Enter maximum number of heavy containers: ");
        int maxNumHeavyContainers = scanner.nextInt();
        System.out.print("Enter maximum number of refrigerated containers: ");
        int maxNumRefrigeratedContainers = scanner.nextInt();
        System.out.print("Enter maximum number of liquid containers: ");
        int maxNumLiquidContainers = scanner.nextInt();
        System.out.print("Enter fuel tank capacity: ");
        double fuelTankCapacity = scanner.nextDouble();
        System.out.print("Enter current fuel level: ");
        double currentFuelLevel = scanner.nextDouble();
        System.out.print("Enter fuel consumption per km: ");
        double fuelConsumptionPerKm = scanner.nextDouble();

        Ship ship = new Ship(id, portId, maxWeight, maxNumContainers, maxNumHeavyContainers,
                maxNumRefrigeratedContainers, maxNumLiquidContainers, fuelTankCapacity,
                currentFuelLevel, fuelConsumptionPerKm);
        ships.add(ship);
        System.out.println("Ship created successfully.");
    }

    private static void createPort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter port ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter x-coordinate of the port: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y-coordinate of the port: ");
        double y = scanner.nextDouble();

        Port port = new Port(x, y, id);
        ports.add(port);
        System.out.println("Port created successfully.");
    }

    private static void loadContainerToShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ship ID: ");
        String shipId = scanner.nextLine();
        System.out.print("Enter container ID: ");
        String containerId = scanner.nextLine();

        Ship ship = findShipById(shipId);
        Container container = findContainerById(containerId);

        if (ship == null) {
            System.out.println("Ship not found.");
        } else if (container == null) {
            System.out.println("Container not found.");
        } else {
            // Check if the container can be loaded onto the ship
            if (container.getWeight() > 5000 && (container.getId().endsWith("R") || container.getId().endsWith("L"))) {
                System.out.println("Loading not possible for heavy, refrigerated, or liquid containers.");
            } else if (ship.getCurrentFuelLevel() + container.getWeight() > ship.getMaxWeight()) {
                System.out.println("Loading not possible. Exceeds maximum weight limit.");
            } else if (countContainersOfType(ship, "HeavyContainer") >= ship.getMaxNumHeavyContainers()) {
                System.out.println("Loading not possible. Exceeds maximum");
            } else {
                ship.setCurrentFuelLevel(ship.getCurrentFuelLevel() + container.getWeight());
                ship.setMaxNumContainers(ship.getMaxNumContainers() + 1);
                containers.remove(container);
                System.out.println("Container loaded successfully onto the ship.");
            }
        }
    }

    private static void unloadContainerFromShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ship ID: ");
        String shipId = scanner.nextLine();
        System.out.print("Enter container ID: ");
        String containerId = scanner.nextLine();

        Ship ship = findShipById(shipId);
        Container container = findContainerById(containerId);

        if (ship == null) {
            System.out.println("Ship not found.");
        } else if (container == null) {
            System.out.println("Container not found.");
        } else {
            ship.setCurrentFuelLevel(ship.getCurrentFuelLevel() - container.getWeight());
            ship.setMaxNumContainers(ship.getMaxNumContainers() - 1);
            containers.add(container);
            System.out.println("Container unloaded successfully from the ship.");
        }
    }

    private static void sailShipToPort() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ship ID: ");
        String shipId = scanner.nextLine();
        System.out.print("Enter destination port ID: ");
        String portId = scanner.nextLine();

        Ship ship = findShipById(shipId);
        Port port = findPortById(portId);

        if (ship == null) {
            System.out.println("Ship not found.");
        } else if (port == null) {
            System.out.println("Port not found.");
        } else {
            double distance = calculateDistance(ship.getPortId(), portId);
            double fuelRequired = distance * ship.getFuelConsumptionPerKm();

            if (fuelRequired > ship.getCurrentFuelLevel()) {
                System.out.println("Insufficient fuel. Refuel the ship before sailing.");
            } else {
                ship.setCurrentFuelLevel(ship.getCurrentFuelLevel() - fuelRequired);
                ship.setPortId(portId);
                System.out.println("Ship sailed successfully to the destination port.");
            }
        }
    }

    private static void refuelShip() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ship ID: ");
        String shipId = scanner.nextLine();

        Ship ship = findShipById(shipId);

        if (ship == null) {
            System.out.println("Ship not found.");
        } else {
            double refuelAmount = ship.getFuelTankCapacity() - ship.getCurrentFuelLevel();
            ship.setCurrentFuelLevel(ship.getFuelTankCapacity());
            System.out.println("Ship refueled successfully with " + refuelAmount + " units of fuel.");
        }
    }

    private static Ship findShipById(String shipId) {
        for (Ship ship : ships) {
            if (ship.getId().equals(shipId)) {
                return ship;
            }
        }
        return null;
    }

    private static Container findContainerById(String containerId) {
        for (Container container : containers) {
            if (container.getId().equals(containerId)) {
                return container;
            }
        }
        return null;
    }

    private static Port findPortById(String portId) {
        for (Port port : ports) {
            if (port.getId().equals(portId)) {
                return port;
            }
        }
        return null;
    }

    private static double calculateDistance(String port1Id, String port2Id) {
        Port port1 = findPortById(port1Id);
        Port port2 = findPortById(port2Id);

        if (port1 == null || port2 == null) {
            return 0.0;
        }

        double xDiff = port2.getX() - port1.getX();
        double yDiff = port2.getY() - port1.getY();

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private static int countContainersOfType(Ship ship, String containerType) {
        int count = 0;
        for (Container container : containers) {
            if (containerType.equals("HeavyContainer") && container.getWeight() > 5000) {
                count++;
            } else if (containerType.equals("RefrigeratedContainer") && container.getId().endsWith("R")) {
                count++;
            } else if (containerType.equals("LiquidContainer") && container.getId().endsWith("L")) {
                count++;
            }
        }
        return count;
    }
}