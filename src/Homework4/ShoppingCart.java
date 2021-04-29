package Homework4;

import java.util.LinkedList;

public class ShoppingCart {
    private LinkedList<Item> cart;
    private double sum;
    private int numItems = 0;

    ShoppingCart() {
        this.cart = new LinkedList<Item>();
    }

    void addItem(Item item) {
        cart.addLast(item);
        numItems++;
    }

    double grandTotal() {
        for (Item i : cart) {
            sum += i.getPrice();
        }
        return sum;
    }

    int numItems() {
        return numItems;
    }

    public String toString() {
        return null;
    }

}
