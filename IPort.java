public interface IPort {
    void incomingShip(Ship s);
    void outgoingShip(Ship s);
    double getDistance(Port other);
}
