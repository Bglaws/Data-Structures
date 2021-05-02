package Homework4;

public class Item {
    private String name;
    private int price;

    // Item Constructor
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // returns name of Item
    public String getName() {
        return name;
    }

    // returns individual price of item
    public int getPrice() {
        return price;
    }

    // returns string representation of item
    public String toString() {
        return "name: " + name + "price: " + price;
    }
}
