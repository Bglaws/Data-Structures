package src;

import java.util.Iterator;

public class DList implements Iterable<String> {

    private DListNode nil;

    public DList() {
        nil = new DListNode();
        nil.previous = nil;
        nil.next = nil;
        nil.data = null;
    }

    // nil -> null
    public void addFirst(String elem) {
        DListNode temp = nil.next;
        nil.next = new DListNode();
        nil.next.previous = nil;
        nil.next.data = elem;
        nil.next.next = temp;
    }

    public void addLast(String elem) {
        DListNode temp = nil.previous;
        nil.previous = new DListNode();
        nil.previous.next = nil;
        nil.previous.data = elem;
        nil.previous.previous = temp;
    }

    public String getFirst() {
        return nil.next.data;
    }

    public String getLast() {
        return nil.previous.data;
    }

    public String removeFirst() {
        DListNode temp = nil.next;
        nil.next = temp.next;
        temp.next.previous = nil;
        return temp.data;
    }

    public String removeLast() {
        DListNode temp = nil.previous;
        nil.previous = temp.previous;
        temp.previous.next = nil;
        return temp.data;
    }

    public String get(int index) {
        String s = "";
        DListNode temp;
        while (index > 0) {
            if (nil.next == nil) {
                throw new IndexOutOfBoundsException("aint no vitamins in that shit");
            }

        }
        return s;
    }

    @Override
    public Iterator<String> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    private static class DListNode {
        public String data;
        public DListNode next;
        public DListNode previous;
    }

    private class DListIterator implements Iterator<String> {
        private DListNode pointer;

        public DListIterator() {
            if (nil.next == nil)
                pointer = nil;
            else
                pointer = nil.next;
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public String next() {
            // TODO Auto-generated method stub
            return null;
        }

    }

    public static void main(String[] args) {

        DList a = new DList();
        String elem = "My first node!";
        a.addFirst(elem);
    }

}
