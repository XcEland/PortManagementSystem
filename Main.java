import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Container> containers = new ArrayList<>();
    private static ArrayList<Ship> ships = new ArrayList<>();
    private static ArrayList<Port> ports = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
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
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            
            System.out.println();
        } while (choice != 8);
        
        
    }
    
    private static void createContainer() {
        
        
        System.out.print("Enter container ID/Serial #: ");
        String id = scanner.nextLine().trim();

        scanner.nextLine();
        System.out.print("Enter container weight: ");
        int weight = scanner.nextInt();
        
        boolean isHeavy = false;
        boolean isRefrigerated = false;
        boolean isLiquid = false;
        
        if (weight >= 5000) {
            if (id.endsWith("R")) {
                isRefrigerated = true;
                isHeavy = true;
            } else if (id.endsWith("L")) {
                isLiquid = true;
                isHeavy = true;
            } else {
                isHeavy = true;
            }
        }
        
        Container container;
        
        if (isRefrigerated) {
            //container = new RefrigeratedContainer(id, weight, isHeavy, isLiquid);
            container = new RefrigeratedContainer(id, weight);
        } else {
            container = new BasicContainer(id, weight);
        }
        
        containers.add(container);
        
        System.out.println("Container created successfully.");
    }
    
    private static void createShip() {
        
        
        System.out.print("Enter the ID of the port where the ship initially is: ");
        String portId = scanner.nextLine().trim();
        scanner.nextLine();

        System.out.print("Enter the maximum weight of all containers in the ship: ");
        int maxWeight = scanner.nextInt();

        System.out.print("Enter the maximum number of all containers in the ship: ");
        int maxContainers = scanner.nextInt();


        System.out.print("Enter the maximum number of heavy containers in the ship: ");
        int maxHeavyContainers = scanner.nextInt();
        System.out.print("Enter the maximum number of refrigerated containers in the ship: ");
        int maxRefrigeratedContainers = scanner.nextInt();
        System.out.print("Enter the maximum number of liquid containers in the ship: ");
        int maxLiquidContainers = scanner.nextInt();
        System.out.print("Enter the fuel tank capacity of the ship: ");
        double fuelTankCapacity = scanner.nextDouble();
        System.out.print("Enter the current fuel level of the ship: ");
        double currentFuelLevel = scanner.nextDouble();
        System.out.print("Enter the fuel consumption per km of the ship: ");
        double fuelConsumptionPerKm = scanner.nextDouble();
        
        Ship ship = new Ship(portId, maxWeight, maxContainers, maxHeavyContainers, maxRefrigeratedContainers, maxLiquidContainers, fuelTankCapacity, currentFuelLevel, fuelConsumptionPerKm);
        ships.add(ship);
        
        System.out.println("Ship created successfully.");
    }
    
    private static void createPort() {
        
        
        System.out.print("Enter the x coordinate of the port: ");
        double xCoordinate = scanner.nextDouble();

        System.out.print("Enter the y coordinate of the port: ");
        double yCoordinate = scanner.nextDouble();
        
        Port port = new Port(null, xCoordinate, yCoordinate);
        
        ports.add(port);
        
        System.out.println("Port created successfully.");
    }

    private static void loadContainerToShip() {
        
        
        System.out.print("Enter the ID of the ship: ");
        String shipId = scanner.nextLine().trim();

        scanner.nextLine();
        System.out.print("Enter the ID of the container: ");
        String containerId = scanner.nextLine().trim();
        scanner.nextLine();
        
        Ship ship = findShip(shipId);
        Container container = findContainer(containerId);
        
        if (ship == null || container == null) {
            System.out.println("Ship or container not found.");
            return;
        }
        
        boolean loaded = ship.load(container);
        
        if (loaded) {
            System.out.println("Container loaded successfully.");
        } else {
            System.out.println("Loading not possible. Check ship's restrictions.");
        }
    }
    
    private static void unloadContainerFromShip() {
        
        
        System.out.print("Enter the ID of the ship: ");
        String shipId = scanner.nextLine().trim();
        scanner.nextLine();

        System.out.print("Enter the ID of the container: ");
        String containerId = scanner.nextLine().trim();
        scanner.nextLine();

        
        Ship ship = findShip(shipId);
        Container container = findContainer(containerId);
        
        if (ship == null || container == null) {
            System.out.println("Ship or container not found.");
            return;
        }
        
        boolean unloaded = ship.unLoad(container);
        
        if (unloaded) {
            System.out.println("Container unloaded successfully.");
        } else {
            System.out.println("Container not found on the ship.");
        }
    }
    
    private static void sailShipToPort() {
        
        
        System.out.print("Enter the ID of the ship: ");
        String shipId = scanner.nextLine().trim();
        scanner.nextLine();

        System.out.print("Enter the ID of the destination port: ");
        String portId = scanner.nextLine().trim();
        scanner.nextLine();

        
        Ship ship = findShip(shipId);
        Port port = findPort(portId);
        
        if (ship == null || port == null) {
            System.out.println("Ship or port not found.");
            return;
        }
        
        boolean sailed = ship.sailTo(port);
        
        if (sailed) {
            System.out.println("Ship sailed to the destination port successfully.");
        } else {
            System.out.println("Ship does not have enough fuel to sail to the destination port.");
        }
    }
    
    private static void refuelShip() {
        
        
        System.out.print("Enter the ID of the ship: ");
        String shipId = scanner.nextLine().trim();
        scanner.nextLine();

        System.out.print("Enter the amount of fuel to add: ");
        double fuelAmount = scanner.nextDouble();
        
        Ship ship = findShip(shipId);
        
        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }
        
        ship.reFuel(fuelAmount);
        
        System.out.println("Ship refueled successfully.");
    }
    
    private static Ship findShip(String shipId) {
        for (Ship ship : ships) {
            if (ship.getID().equals(shipId)) {
                return ship;
            }
        }
        return null;
    }
    
    private static Container findContainer(String containerId) {
        for (Container container : containers) {
            if (container.getID().equals(containerId)) {
                return container;
            }
        }
        return null;
    }
    
    private static Port findPort(String portId) {
        for (Port port : ports) {
            if (port.getID().equals(portId)) {
                return port;
            }
        }
        return null;
    }

    
}
