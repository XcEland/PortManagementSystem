class LiquidContainer extends HeavyContainer {
    public LiquidContainer(String ID, int weight) {
        super(ID, weight);
    }

    @Override
    public double consumption() {
        return weight * 4.00;
    }
}
