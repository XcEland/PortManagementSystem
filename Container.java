abstract class Container {
    protected String ID;
    protected int weight;

    public Container(String ID, int weight) {
        this.ID = ID;
        this.weight = weight;
    }

    public abstract double consumption();

    public boolean equals(Container other) {
        //return this.getClass() == other.getClass() && this.ID == other.ID && this.weight == other.weight;
        return this.ID.equals(other.ID ) && this.weight == other.weight;
    }

    public String getID() {
        return ID;
    }

    public int getWeight() {
        return weight;
    }

    
}