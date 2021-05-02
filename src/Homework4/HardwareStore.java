package Homework4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HardwareStore {
    private ArrayList<Queue<Shopper>> store;
    private int totalRevenue;
    private LinkedList<Shopper> shortestLine;
    private PriorityQueue<Shopper> pq;

    /*
     * HardwareStore Constructor. This constructor instantiates the "store"
     * arraylist, which will contain however many registers that are specified. the
     * registers themselves are queues that use LinkedLists as their underlying
     * structure.
     */
    HardwareStore(int numRegisters) {
        this.store = new ArrayList<Queue<Shopper>>();
        this.pq = new PriorityQueue<Shopper>();
        this.totalRevenue = 0;
        this.shortestLine = null;
        while (numRegisters > 0) {
            store.add(new LinkedList<Shopper>());
            numRegisters--;
        }
    }

    // HERE! not sure if adding shopper to priority que is this simple?
    // need to research priorityQueue.add
    void addShopperToLine(Shopper shopper) {
        pq.add(shopper);
    }

    void checkoutAllShoppers() {

    }

    double totalRevenue() {
        return -1;
    }

}
