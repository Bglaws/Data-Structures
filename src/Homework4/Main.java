package Homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Item> inventoryList = new ArrayList<Item>();

    // need to use a hashmap for inventory so you can map the names of items to the
    // inventory values

    public static void main(String[] args) throws FileNotFoundException {
        Scanner items = new Scanner(new File("inventory.txt"));
        Scanner event = new Scanner(new File("event.txt"));

        // array of items and their descriptions
        String[] itemList = new String[100];
        for (int i = 0; i < itemList.length || !items.hasNext(); i++) {
            itemList[i] = items.nextLine();
            String[] splitStr = itemList[i].split(" ");
            inventoryList.add(new Item(splitStr[0], Integer.parseInt(splitStr[1])));
        }

        String[] shopper = new String[100];
        String first, last;
        for (int i = 0; i < shopper.length; i++) {
            shopper[i] = event.nextLine();
            String[] splitStr = shopper[i].split(" ");
            first = splitStr[0];
            last = splitStr[1];

            // Need to consruct shopping cart and then shopper using the new shopping cart

        }

    }

}
