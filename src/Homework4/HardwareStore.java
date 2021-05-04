package Homework4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HardwareStore {
    private PriorityQueue<Queue<Shopper>> checkoutLines;
    private int totalRevenue;
    private LinkedList<Shopper> shortestLine;
    private PriorityQueue<Shopper> store;

    /*
     * HardwareStore Constructor. This constructor instantiates the "store"
     * arraylist, which will contain however many registers that are specified. the
     * registers themselves are queues that use LinkedLists as their underlying
     * structure.
     */
    HardwareStore(int numRegisters) {
        this.checkoutLines = new PriorityQueue<Queue<Shopper>>((Queue<Shopper> q1, Queue<Shopper> q2) -> {
            return (q1.size() < q2.size());
        });
        this.store = new PriorityQueue<Shopper>();
        this.totalRevenue = 0;
        this.shortestLine = null;
        while (numRegisters > 0) {
            checkoutLines.add(new LinkedList<Shopper>());
            numRegisters--;
        }
    }

    // HERE! not sure if adding shopper to priority que is this simple?
    // need to research priorityQueue.add
    void addShopperToLine(Shopper shopper) {
        store.add(shopper);
    }

    void checkoutAllShoppers() {
        // size is used to save the size of the shortest checkout line.
        int size = 0;
        Queue<Shopper> temp;

        while (!store.isEmpty()) {
            temp = checkoutLines.poll();
            temp.offer(store.poll());
        }
    }

    double totalRevenue() {
        return -1;
    }

}
