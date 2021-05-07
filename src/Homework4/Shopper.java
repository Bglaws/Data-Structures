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
    public void addItemToCart(Item item, int numItems) {
        for (int i = 0; i < numItems; i++) {
            myCart.addItem(item);
        }
    }

    /*
     * overriden addItemToCart so when user only wants to add one item they just say
     * which item
     */
    public void addItemToCart(Item item) {
        addItemToCart(item, 1);
    }

    /*
     * takes the sum of all items in shoppers cart, grandTotal(), applies the tax,
     * and returns the total this shopper owes the hardware store
     */
    public int amountOwed() {
        int sub = myCart.grandTotal();
        float tax = (float) (sub*0.0875);
        return sub + Math.round(tax);
    }

    // String representation for this shoppers cart
    public String toString() {
        String s = firstName + " " + lastName + "\'s shopping cart: " + myCart.toString();
        return s;
    }

    // compareTo method for comparing the totals of 2 seperate shoppers
    @Override
    public int compareTo(Shopper o) {
        if (this.amountOwed() > o.amountOwed()) {
            return -1;
        } else if (this.amountOwed() < o.amountOwed()) {
            return 1;
        }
        return 0;
    }
}