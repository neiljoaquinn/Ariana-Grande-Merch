package models;

public class Orders {
    public Orders(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    private String name;
    private int amount;

    public void print(){
        System.out.println(name+" "+amount);
    }
}