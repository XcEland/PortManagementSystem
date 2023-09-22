class BasicContainer extends Container {
    public BasicContainer(String ID, int weight) {
        super(ID, weight);
    }

    @Override
    public double consumption() {
        return 2.50 * weight;
    }
}
