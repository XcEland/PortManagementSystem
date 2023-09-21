import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Container> containers = new ArrayList<>();
    private static ArrayList<Ship> ships = new ArrayList<>();
    private static ArrayList<Port> ports = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Create a container");
                System.out.println("2. Create a ship");
                System.out.println("3. Create a port");
                System.out.println("4. Load a container to a ship");
                System.out.println("5. Unload a container from a ship");
                System.out.println("6. Sail ship to another port");
                System.out.println("7. Refuel ship");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();

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
                        loadContainer();
                        break;
                    case 5:
                        unloadContainer();
                        break;
                    case 6:
                        sailShip();
                        break;
                    case 7:
                        reFuelShip();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
    }

    private static void createContainer() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the container ID:");
            int id = scanner.nextInt();

            System.out.println("Enter the container weight:");
            int weight = scanner.nextInt();

            String type = "";
            if (weight >= 5000) {
                System.out.println("Is the container refrigerated or liquid? (R/L)");
                type = scanner.next();
            }

            Container container = new BasicContainer(id, weight);
            if (type.equals("R")) {
                container = new RefrigeratedContainer(id, weight);
            } else if (type.equals("L")) {
                container = new LiquidContainer(id, weight);
            }

            containers.add(container);
        }

        System.out.println("Container created successfully.");
        System.out.println("Press Enter to return to the main menu.");
        System.in.read();
    }

    private static void createShip() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the ship ID:");
            int id = scanner.nextInt();

            System.out.println("Enter the port where the ship is currently located:");
            int portId = scanner.nextInt();

            Port port = findPortById(ports, portId);
            if (port == null) {
                System.out.println("Port not found.");
                return;
            }

            System.out.println("Enter the ship's total weight capacity:");
            int totalWeightCapacity = scanner.nextInt();

            System.out.println("Enter the ship's maximum number of all containers:");
            int maxNumberOfAllContainers = scanner.nextInt();

            System.out.println("Enter the ship's maximum number of heavy containers:");
            int maxNumberOfHeavyContainers = scanner.nextInt();

            System.out.println("Enter the ship's maximum number of refrigerated containers:");
            int maxNumberOfRefrigeratedContainers = scanner.nextInt();

            System.out.println("Enter the ship's maximum number of liquid containers:");
            int maxNumberOfLiquidContainers = scanner.nextInt();

            System.out.println("Enter the ship's fuel tank capacity:");
            double fuelTankCapacity = scanner.nextDouble();

            System.out.println("Enter the ship's fuel consumption per kilometer:");
            //double fuelConsumptionPerKM = scanner.nextDouble();

            Ship ship = new Ship(id, port, totalWeightCapacity, maxNumberOfAllContainers, maxNumberOfHeavyContainers, maxNumberOfRefrigeratedContainers, maxNumberOfLiquidContainers, fuelTankCapacity);
            ships.add(ship);
        }

        System.out.println("Ship created successfully.");
    }


    private static void loadContainer() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the ship ID:");
            int shipId = scanner.nextInt();
   
            System.out.println("Enter the container ID:");
            int containerId = scanner.nextInt();
   
            Ship ship = findShipById(ships, shipId);
            if (ship == null) {
                System.out.println("Ship not found.");
                return;
            }
   
            Container container = findContainerById(containers, containerId);
            if (container == null) {
                System.out.println("Container not found.");
                return;
            }
   
            if (!ship.load(container)) {
                System.out.println("The ship cannot load the container.");
                return;
            }
   
            ship.load(container);
        }
    
        System.out.println("Container loaded successfully.");
    }
    
    private static void unloadContainer() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the ship ID:");
            int shipId = scanner.nextInt();
   
            System.out.println("Enter the container ID:");
            int containerId = scanner.nextInt();
   
            Ship ship = findShipById(ships, shipId);
            if (ship == null) {
                System.out.println("Ship not found.");
                return;
            }
   
            Container container = ship.findContainerById(containerId);
            if (container == null) {
                System.out.println("Container not found in the ship.");
                return;
            }
   
            ship.unLoad(container);
        }
    
        System.out.println("Container unloaded successfully.");
    }
    
    private static void sailShip() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Enter the ship ID:");
        int shipId = scanner.nextInt();
    
        System.out.println("Enter the destination port ID:");
        int destinationPortId = scanner.nextInt();
    
        Ship ship = findShipById(ships, shipId);
        if (ship == null) {
            System.out.println("Ship not found.");
            return;
        }
    
        Port destinationPort = findPortById(ports, destinationPortId);
        if (destinationPort == null) {
            System.out.println("Destination port not found.");
            return;
        }
    
        //if (!ship.hasEnoughFuelToSailTo(destinationPort)) {
        //    System.out.println("The ship does not have enough fuel to sail to the destination port.");
        //    return;
        //}
    
        ship.sailTo(destinationPort);
    
        System.out.println("Ship sailed to the destination port successfully.");
    }
    
    private static void reFuelShip() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the ship ID:");
            int shipId = scanner.nextInt();
   
            System.out.println("Enter the amount of fuel to refuel:");
            double amountOfFuel = scanner.nextDouble();

            
            Ship ship = findShipById(ships, shipId);
            if (ship == null) {
                System.out.println("Ship not found.");
                return;
            }
   
            ship.reFuel(amountOfFuel);
        }
    
        System.out.println("Ship refueled successfully.");
    }

    public static Ship findShipById(ArrayList<Ship> ships, int shipId) {
        for (Ship ship : ships) {
            if (ship.getID() == shipId) {
                return ship;
            }
        }

        return null;
    }

    public static Container findContainerById(ArrayList<Container> containers, int containerId) {
        for (Container container : containers) {
            if (container.getID() == containerId) {
                return container;
            }
        }

        return null;
    }

    public static Port findPortById(ArrayList<Port> ports, int portId) {
        for (Port port : ports) {
            if (port.getID() == portId) {
                return port;
            }
        }
    
        return null;
    }

    private static void createPort() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the x-coordinate of the new port:");
            double xCoordinate = scanner.nextDouble();
   
            System.out.println("Enter the y-coordinate of the new port:");
            double yCoordinate = scanner.nextDouble();
   
            Port port = new Port(ports.size() + 1, xCoordinate, yCoordinate);
            ports.add(port);
        }
    
        System.out.println("Port created successfully.");
    }
    
}
