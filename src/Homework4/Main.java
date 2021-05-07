package Homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static HardwareStore getHardwareStore() throws FileNotFoundException{
        Scanner items = new Scanner(new File("./src/Homework4/inventory.txt"));
        HashMap<String,Item> inventory = new HashMap<String,Item>();

        // reads in name of items and their respective prices
        String[] itemList = new String[100];
        for (int i = 0; i < itemList.length && items.hasNextLine(); i++) {
            itemList[i] = items.nextLine();
            String[] splitStr = itemList[i].split(" ");
            /*
             * inventoryList is a hashmap that maps the name of an item to an item object. 
             */
            inventory.put(splitStr[0], new Item(splitStr[0], Integer.parseInt(splitStr[1])));
        }

        return new HardwareStore(3, inventory);
    }

    public static void readEvent(HardwareStore hardwareStore) throws FileNotFoundException {
        Scanner event = new Scanner(new File("./src/Homework4/event.txt"));
        
        String[] shopperArr = new String[100];
        String first, last;
        
        /**
         * this first for loop is used to read in from the event file first and last name of a shopper.
         * Im using the String method split() to get an array of individual strings delimited by spaces (" ")
         * so that I can use a second for loop to access the remainder of the elements in the nextLine 
         * (which are just the items in shoppers cart, and how many of them) individually.
         */
        for (int i = 0; i < shopperArr.length && event.hasNextLine(); i++) {
            shopperArr[i] = event.nextLine();
            String[] splitStr = shopperArr[i].split(" ");
            first = splitStr[0];
            last = splitStr[1];
            Shopper shopper = new Shopper(first,last);
            
            for (int j = 2; j < splitStr.length; j++) {
                /**
                 * if the inventory has the item that the user has in their shopping cart 
                 * (meaning it follows the shoppers name in the event file), than add that item to 
                 * the shoppers cart.
                 */
                if (hardwareStore.getInventory().containsKey(splitStr[j])) {
                    Item item = hardwareStore.getInventory().get(splitStr[j]);
                    shopper.addItemToCart(item, Integer.parseInt(splitStr[j+1]));
                }
            }
            System.out.println(shopper.toString());
            //once all of a shoppers items have been added to their cart, add the shopper to the store.
            hardwareStore.addShopperToLine(shopper);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        HardwareStore hardwareStore = getHardwareStore();

        readEvent(hardwareStore);

        hardwareStore.checkoutAllShoppers();

        System.out.println(hardwareStore.totalRevenue());
    }

}
