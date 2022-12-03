package models;

public abstract class Merch implements Comparable<Merch>{
    protected String size;
    protected int rank;
    public String name;
    public int quantity;

    public abstract void initialize();
    public abstract void print();

    @Override
    public int compareTo(Merch b) {
        if(this.rank > b.rank){
            return 1;
        }else if(this.rank < b.rank){
            return -1;
        }
        return 0;
    }
}