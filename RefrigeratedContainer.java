public class RefrigeratedContainer extends HeavyContainer {
    public RefrigeratedContainer(String id, int weight) {
        super(id, weight);
    }

    @Override
    public double consumption() {
        return weight * 5.00;
    }
}
