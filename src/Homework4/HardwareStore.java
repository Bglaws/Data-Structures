package Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HardwareStore {
    private PriorityQueue<Queue<Shopper>> checkoutLines;
    private PriorityQueue<Shopper> store;
    private HashMap<String, Item> inventory;
    private int totalRevenue;

    /*
     * HardwareStore Constructor. This constructor creates the "store" priority
     * queue, which will contain however many registers are specified. the registers
     * themselves are queues that use LinkedLists as their underlying structure. I
     * started writing this class using an array list to represent the store, but I
     * decided to change it to a PriorityQueue. I chose to do this because the
     * PriorityQueue will always return the register (queue) with the shortest line,
     * saving me some code in the checkoutAllShoppers method.
     */
    HardwareStore(int numRegisters, HashMap<String, Item> inventory) {
        /*
         * calls PriorityQueue constructor and passes a comparator to it using a lambda
         * expression. The Comparator puts the smallest que at the head. I realized
         * while working on this that my computer has java 11 installed, the PQ
         * constructor in java 7 takes an initial capacity as a parameter. I know you
         * want us to code in java 7. I hope its ok that I submit this assignment in
         * java 11 since I've almost finished.
         */
        this.checkoutLines = new PriorityQueue<Queue<Shopper>>((Queue<Shopper> q1, Queue<Shopper> q2) -> {
            return (q1.size() - q2.size());
        });
        this.store = new PriorityQueue<Shopper>();
        this.inventory = new HashMap<String, Item>(inventory);
        this.totalRevenue = 0;
        while (numRegisters > 0) {
            checkoutLines.add(new LinkedList<Shopper>());
            numRegisters--;
        }
    }

    public void addShopperToLine(Shopper shopper) {
        store.add(shopper);
    }

    public void checkoutAllShoppers() {
        // size is used to save the size of the shortest checkout line.
        Shopper shopper;
        Queue<Shopper> line;
        /*
         * in order to add a shopper to a register, the queue must first be removed from
         * checkoutLines. Once you remove the the queue and add the shopper to it, then
         * you add it back into checkoutLines so that the queue can be resorted into the
         * right order. this while loop does this until the store is empty.
         * 
         */

        while (!store.isEmpty()) {
            line = checkoutLines.poll();
            shopper = store.poll();
            line.offer(shopper);
            checkoutLines.offer(line);
        }
        /*
         * queues are removed from checkoutLines and added to an ArrayList so that the
         * queue's can be iterated through. the ArrayList is looped through in reverse
         * order so that the queue's with the longest lines will be polled first.
         * 
         * I tried changing the comparator in the constructor so that the priority queue 
         * would poll() the largest queue first, but then the while loop above wouldnt work,
         * because the shoppers would all be added to one line
         */

        ArrayList<Queue<Shopper>> l = new ArrayList<Queue<Shopper>>();
        for (Queue<Shopper> q : checkoutLines) {
            l.add(q);
        }
        for (int i = l.size() - 1; i >= 0; i--) {
            Queue<Shopper> q = l.get(i);
            while (!q.isEmpty()) {
                Shopper temp = q.poll();
                totalRevenue += temp.amountOwed();
            }
        }

    }

    public double totalRevenue() {
        return totalRevenue / 100.0;
    }
    public HashMap<String,Item> getInventory() {
        return inventory;
    }

}
