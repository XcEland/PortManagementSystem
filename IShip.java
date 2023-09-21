interface IShip {
    void loadContainer(Container container);
    void unloadContainer(Container container);
    void sailToPort(Port port);
    void refuelShip(double fuelAmount);
}
