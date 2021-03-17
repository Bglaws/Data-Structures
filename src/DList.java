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
        DListNode temp;

        if(nil.next == nil) {
            throw new IndexOutOfBoundsException("aint no vitamins in that shit");
        } else {
            temp = nil.next;
        }

        while (index > 0) {
            temp = temp.next;
            if (temp == nil) {
                throw new IndexOutOfBoundsException("aint no vitamins in that shit");
            }
            index--;
        }
        return temp.data;
    }

    // returns old value
    public String set(int index, String value) {
        DListNode temp;
        if(nil.next == nil) {
            throw new IndexOutOfBoundsException("aint no vitamins in that shit");
        } else {
            temp = nil.next;
        }
       
        while(index > 0) {
            temp = temp.next;
            if (temp == nil) {
                throw new IndexOutOfBoundsException("aint no vitamins in that shit");
            }
            index--;
        }
        String o = temp.data;
        temp.data = value;
        return o;
    }

    public boolean contains(Object obj) {
        DListNode temp = nil.next;
        while(temp != nil) {
            if (temp.data == obj) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        DListNode temp = nil.next;
        while (temp != nil) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public int indexOf(Object obj) {
        int count = 0;
        DListNode temp = nil.next;
        while (temp != nil) {
            if (temp.data.equals(obj)) {
                return count;
            } else {
                count++;
            }
        }
        return count = -1;
    }

    @Override
    public Iterator<String> iterator() {
        return new DListIterator();
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
            if (this.pointer == nil) {
                return false;
            } else {
                return true;
            }
        }

        @Override
        public String next() {
            DListNode temp = this.pointer;
            this.pointer = this.pointer.next;
            return temp.data;
        }

    }

    public static void main(String[] args) {

        DList a = new DList();
        DList b = new DList();

        String elem1 = "My first node!";
        String elem2 = "My first node!";
        String elem3 = "My first node!";
        String elem4 = "My first node!";
        String elem5 = "My first node!";

        a.addFirst(elem1);
        a.addFirst(elem2);
        a.addLast(elem3);

        DListIterator it = (DListIterator) a.iterator();
        System.out.println(it.next());

        b.addFirst(elem4);
        b.addFirst(elem5);

        
    }

}
