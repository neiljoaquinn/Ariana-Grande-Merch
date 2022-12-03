package models;

import utils.Input;

public class Album extends Merch {
    public Album(){
        initialize();
    }

    @Override
    public void initialize() {
        this.name = Input.string("Enter Album Name: ");
        this.quantity = Input.number("Enter Album quantity: ");
        this.rank = 1;
    }
    
    @Override
    public void print() {
        System.out.println(String.format("Album: [%s] %s",quantity, name));
    }
}