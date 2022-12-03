import java.util.ArrayList;
import java.util.Collections;

import models.*;
import utils.*;

public class Shop{
    public void open(){
        println("Ariana Grande Merchandise.");
        while(true){
            println("\n\nChoose an Option");
            println("1. View Products.");
            println("2. Add to Cart.");
            println("3. Purchase Merch.");
            println("4. Show Orders.");
            println("5. Close Kiosk");
            getChoice();
        }
    }

    /**
     * 
     */
    private void getChoice(){
        while(true){
            String input;
            try{
                input = Input.string("-> ");
                int i = Integer.parseInt(input);
                if(i<1 || i>5){
                    throw new ChoiceException();
                }
                performAction(i);
                break;
            }catch(NumberFormatException e){
                println("Input must be a number");
            }catch(final ChoiceException c){
                println("Input must be any of the ff: (1,2,3,4)");
            }
        }
    }

    private void performAction(int choice){
        switch(choice){
            case PRODUCT:
                viewProduct("");
            break;
            case ADD:
                addMerch();
            break;
            case PURCHASE:
                purchase();
            break;
            case SHOW_ORDERS:
                showOrders();
            break;
            case CLOSE:
            System.exit(0);
            break;
        }
    }

    private void viewProduct(String extra){
        if(merch.isEmpty()){
            println("Your Cart is empty.");
            return;
        }
        Collections.sort(merch);
        println("\n========== Menu ==========="+extra);
        for(int i = 0; i < merch.size(); i++){
            print((i+1)+".) ");
            merch.get(i).print();
        }
        println("========== ==== ===========");
    }

    private void addMerch(){
        switch(selectMerch()){
            case ALBUM:
                merch.add(new Album());
            break;
            case ACCESSORIES:
                merch.add(new Accessories());
            break;
            case CLOTHING:
                merch.add(new Clothing());
            break;
            case FRAGRANCES:
                merch.add(new Fragrances());
        }
        println("Successfully added");
    }

    /**
     * @return
     */
    private int selectMerch(){
        println("What do you want to add to your cart?");
        println("1. Album.");
        println("2. Accessories.");
        println("3. Clothing.");
        println("4. Fragrances.");
        int choice = 0;
        while(true){
            String input;
            try{
                input = Input.string("-> ");
                choice = Integer.parseInt(input);
                if(choice<1 || choice>4){
                    throw new ChoiceException();
                }
                break;
            }catch(final ChoiceException c){
                println("Input must be any of the ff: (1,2,3,4)");
            }
        }
        return choice;
    }

    private void purchase(){
        if(merch.isEmpty()){
            println("No products available to purchase.");
            return;
        }
        viewProduct("\nChoose Available Products\n");
        int index = Input.number("index: ")-1;
        if(index >= merch.size() || index < 0){
            println("Invalid input");
            return;
        }
        Merch b = merch.get(index);
        int amount = Input.number("Enter quantity to purchase: ");
        if(amount == 0){
            println("You can't purchase zero merch.");
            return;
        }
        if(amount > b.quantity){
            println("You can exceed the available quantity.");
            return;
        }
        b.quantity -= amount;
        merch.set(index, b);
        print("Successfully purchased "+amount+" merch");
        orders.add(new Orders(b.name, amount));
    }

    public void showOrders(){
        if(orders.isEmpty()){
            println("You have not purchased anything yet.");
            return;
        }
        println("\n========= History ==========");
        for(int i = 0; i < orders.size(); i++){
            print((i+1)+".) ");
            orders.get(i).print();
        }
        println("============================");
    }

    public void close (){
        System.exit(0);
    }

    private void print(String message){
        System.out.print(message);
    }

    private void println(String message){
        System.out.println(message);
    }

    private static final int PRODUCT = 1;
    private static final int ADD = 2;
    private static final int PURCHASE = 3;
    private static final int SHOW_ORDERS = 4;
    private static final int CLOSE = 5;


    private static final int ALBUM = 1;
    private static final int ACCESSORIES = 2;
    private static final int CLOTHING = 3;
    private static final int FRAGRANCES = 4;

    ArrayList<Orders> orders = new ArrayList<>();
    ArrayList<Merch> merch = new ArrayList<>();
}