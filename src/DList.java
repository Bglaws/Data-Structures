package src;

import java.util.*;
import java.io.Serializable;

public class DList<E> implements List<E>, Deque<E>, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private int size;
    private DListNode<E> nil;

    // DListNode data
    private static class DListNode<E> {
        public E data;
        public DListNode<E> next;
        public DListNode<E> previous;
    }

    // DList Iterator class
    private class DListIterator implements Iterator<E> {
        private DListNode<E> pointer;

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
            DListNode<E> temp = this.pointer;
            this.pointer = this.pointer.next;
            return (E) temp.data;
        }

    }

    // DList constructor
    public DList() {
        nil = new DListNode<E>();
        nil.previous = nil;
        nil.next = nil;
        nil.data = null;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        return (E) nil.next;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        return (E) nil.previous;
    }

    public void addFirst(E elem) {
        DListNode<E> temp = nil.next;
        nil.next = new DListNode<E>();
        nil.next.previous = nil;
        nil.next.data = elem;
        nil.next.next = temp;
        temp.previous = nil.next;
        size++;
    }

    public void addLast(E elem) {
        DListNode<E> temp = nil.previous;
        nil.previous = new DListNode<E>();
        nil.previous.next = nil;
        nil.previous.data = elem;
        nil.previous.previous = temp;
        temp.next = nil.previous;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        DListNode<E> temp = nil.next;
        nil.next = temp.next;
        temp.next.previous = nil;
        size--;
        return (E) temp.data;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        DListNode<E> temp = nil.previous;
        nil.previous = temp.previous;
        temp.previous.next = nil;
        size--;
        return (E) temp.data;
    }

    public E get(int index) {
        DListNode<E> temp;

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

    // replaces and returns old value
    public E set(int index, E value) {
        DListNode<E> temp;
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
        DListNode<E> temp = nil.next;
        while (temp != nil) {
            if (temp.data == obj) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object obj) {
        int count = 0;
        DListNode<E> temp = nil.next;
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


    // Extra Credit

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E pollFirst() {
        return removeFirst();
    }

    @Override
    public E pollLast() {
        return removeLast();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return getFirst();
    }

    @Override
    public E peekFirst() {
        return peek();
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return getLast();
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public boolean remove(Object o) {
        int target = indexOf(o);
        if (target >= 0) {
            remove(target);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        DListNode<E> temp = nil.previous;
        int target = size - 1;
        while (temp != nil) {
            if (temp.data.equals(o)) {
                remove(target);
                return true;
            } else {
                target--;
                temp = temp.previous;
            }
        }
        return false;
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public Iterator<E> descendingIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (nil.next == nil) {
            return true;
        }
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
        addLast(e);
        return true;
    }

    @Override
    public void add(int index, E element) {
        // needs to create new node

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
    public boolean containsAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
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
