package Homework4;
import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<Item> cart;
    private int sum;
    private int numItems = 0;

    // ShoppingCart constructor
    ShoppingCart() {
        this.cart = new LinkedList<Item>();
    }
    /* adds items to end of this ShoppingCart
    and increments the number of items in the list*/
    void addItem(Item item) {
        cart.addLast(item);
        numItems++;
    }
    // returns the sum of all the items in this ShoppingCart
    int grandTotal() {
        for (Item i : cart) {
            sum += i.getPrice();
        }
        return sum;
    }
    // returns number of items in this ShoppingCart
    int numItems() {
        return numItems;
    }

    /* Iterates through all the items in this shopping cart
    and concatenates the toString of each individual item together 
    into one string*/
    public String toString() {
        String s = "";
        for (Item i : cart) {
            s += "\n"+ i.toString();
        }
        return s;
    }

}
