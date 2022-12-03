package models;

import utils.Input;

public class Fragrances extends Merch {
    public Fragrances(){
        initialize();
    }
    @Override
    public void initialize() {
        this.name = Input.string("Enter Fragrance Name: ");
        this.quantity = Input.number("Enter Fragrance quantity: ");
        this.rank = 4;
    }
    
    @Override
    public void print() {
        System.out.println(String.format("Fragrance: [%s] %s",quantity, name));
    }
}