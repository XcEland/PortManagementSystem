abstract class Container {
    protected int ID;
    protected int weight;

    public Container(int ID, int weight) {
        this.ID = ID;
        this.weight = weight;
    }

    public abstract double consumption();

    public boolean equals(Container other) {
        return this.getClass() == other.getClass() && this.ID == other.ID && this.weight == other.weight;
        //return this.ID == other.ID && this.weight == other.weight;
    }
}