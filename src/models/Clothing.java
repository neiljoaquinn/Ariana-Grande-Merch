package models;

import utils.Input;

public class Clothing extends Merch{
    
    public Clothing(){
        initialize();
    }
    
    @Override
    public void initialize() {
        this.name = Input.string("Enter Clothing Name: ");
        this.quantity = Input.number("Enter Clothing quantity: ");
        this.rank = 3;
    }

    @Override
    public void print() {
        System.out.println(String.format("Clothing: [%s] %s",quantity, name));
    }
    
}