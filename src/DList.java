package src;

import java.util.*;
import java.io.Serializable;

public class DList<E>

        implements List<E>, Deque<E>, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private DListNode nil;

    // DListNode data
    private static class DListNode<E> {
        public E data;
        public DListNode next;
        public DListNode previous;
    }

    // DList Iterator class
    private class DListIterator implements Iterator<E> {
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
            }
            return true;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                return null;
            }
            DListNode temp = this.pointer;
            this.pointer = this.pointer.next;
            return (E) temp.data;
        }

    }

    public static void main(String[] args) {

        DList a = new DList();
        DList b = new DList();

        String elem1 = "P";
        String elem2 = "O";
        String elem3 = "P";
        String elem4 = "C";
        String elem5 = "O";
        String elem6 = "R";
        String elem7 = "N";

        a.addFirst(elem1);
        a.addFirst(elem2);
        a.addFirst(elem3);
        a.addLast(elem4);
        a.addLast(elem5);
        a.addLast(elem6);
        a.addLast(elem7);

        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        a.removeFirst();
        a.removeFirst();
        a.set(0, "S");

        it = a.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println(a.get(a.size() - 1) + "\n");
        a.removeLast();
        a.addLast("E");

        it = a.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        System.out.println(a.contains("O"));
        System.out.println(a.indexOf("S"));

    }

    // DList constructor
    public DList() {
        nil = new DListNode();
        nil.previous = nil;
        nil.next = nil;
        nil.data = null;
    }

    public void addFirst(E elem) {
        DListNode temp = nil.next;
        nil.next = new DListNode();
        nil.next.previous = nil;
        nil.next.data = elem;
        nil.next.next = temp;
        temp.previous = nil.next;
    }

    public void addLast(String elem) {
        DListNode temp = nil.previous;
        nil.previous = new DListNode();
        nil.previous.next = nil;
        nil.previous.data = elem;
        nil.previous.previous = temp;
        temp.next = nil.previous;
    }

    public E getFirst() {
        return (E) nil.next.data;
    }

    public E getLast() {
        return (E) nil.previous.data;
    }

    public E removeFirst() {
        DListNode temp = nil.next;
        nil.next = temp.next;
        temp.next.previous = nil;
        return (E) temp.data;
    }

    public E removeLast() {
        DListNode temp = nil.previous;
        nil.previous = temp.previous;
        temp.previous.next = nil;
        return (E) temp.data;
    }

    public E get(int index) {
        DListNode temp;

        if (nil.next == nil) {
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
        return (E) temp.data;
    }

    // returns old value
    public E set(int index, E value) {
        DListNode temp;
        if (nil.next == nil) {
            throw new IndexOutOfBoundsException();
        } else {
            temp = nil.next;
        }

        while (index > 0) {
            temp = temp.next;
            if (temp == nil) {
                throw new IndexOutOfBoundsException();
            }
            index--;
        }
        E o = (E) temp.data;
        temp.data = value;
        return o;
    }

    public boolean contains(Object obj) {
        DListNode temp = nil.next;
        while (temp != nil) {
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
    public Iterator<E> iterator() {
        return new DListIterator();
    }

    @Override
    public void addLast(E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean offerFirst(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E pollFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E pollLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E peekFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E peekLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean offer(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E poll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E element() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void push(E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public E pop() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean add(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(Object o) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int index, E element) {
        // TODO Auto-generated method stub

    }

    @Override
    public E remove(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }
}
