package Homework4;

public class Shopper implements Comparable<Shopper> {
    private String firstName;
    private String lastName;
    private ShoppingCart myCart;

    // Shopper Constructor
    Shopper(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.myCart = new ShoppingCart();
    }

    // adds specified number of items to this Shopper's cart
    void addItemToCart(Item item, int numItems) {
        for (int i =0; i < numItems; i++) {
            myCart.addItem(item);
        }
    }
    /* overriden addItemToCart so when user
    only wants to add one item they just say which item*/
    void addItemToCart(Item item) {
        addItemToCart(item, 1);
    }

    int amountOwed() {
        return (int) Math.ceil(myCart.grandTotal() * 8.875);
    }

    public String toString() {
        String s = firstName + " " + lastName + 
        "\'s shopping cart: " + myCart.toString();
        return s;
    }

    @Override
    public int compareTo(Shopper o) {
        // TODO Auto-generated method stub
        return 0;
    }
}