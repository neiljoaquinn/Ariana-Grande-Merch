package models;

import utils.Input;

public class Accessories extends Merch {
    public Accessories(){
        initialize();
    }
    @Override
    public void initialize() {
        this.name = Input.string("Enter Accessories Name: ");
        this.quantity = Input.number("Enter Accessories quantity: ");
        this.rank = 2;  
    }
    @Override
    public void print() {
        System.out.println(String.format("Accessories: [%s] %s",quantity, name));
    }
}