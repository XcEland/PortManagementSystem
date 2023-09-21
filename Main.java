import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Port port1 = new Port(1, 0.0, 0.0);
        Port port2 = new Port(2, 10.0, 10.0);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create a container");
            System.out.println("2. Create a ship");
            System.out.println("3. Load a container to a ship");
            System.out.println("4. Unload a container from a ship");
            System.out.println("5. Sail ship to a new port");
            System.out.println("6. Refuel a ship");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the newline character after the integer input

            switch (choice) {
                case 1:
                    System.out.print("Enter the container ID: ");
                    int containerID = scanner.nextInt();
                    System.out.print("Enter the container weight: ");
                    int containerWeight = scanner.nextInt();
                    Container container = new BasicContainer(containerID, containerWeight);
                    port1.addContainer(container);
                    System.out.println("Container created and added to Port 1.");
                    break;
                case 2:
                    System.out.print("Enter the ship ID: ");
                    int shipID = scanner.nextInt();
                    Ship ship = new Ship(shipID, port1);
                    port1.addShipToCurrent(ship);
                    System.out.println("Ship created and added to Port 1.");
                    break;
                case 3:
                    System.out.print("Enter the container ID to load: ");
                    int containerIDToLoad = scanner.nextInt();
                    for (Container c : port1.containers) {
                        if (c.ID == containerIDToLoad) {
                            ship.loadContainer(c);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter the container ID to unload: ");
                    int containerIDToUnload = scanner.nextInt();
                    for (Container c : ship.containers) {
                        if (c.ID == containerIDToUnload) {
                            ship.unloadContainer(c);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter the destination port ID: ");
                    int destinationPortID = scanner.nextInt();
                    Port destinationPort = (destinationPortID == 1) ? port1 : port2;
                    ship.sailToPort(destinationPort);
                    break;
                case 6:
                    System.out.print("Enter the amount of fuel to refuel: ");
                    double fuelAmount = scanner.nextDouble();
                    ship.refuelShip(fuelAmount);
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}