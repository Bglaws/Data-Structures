package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ContactList implements Iterable<Contact> {

   public ArrayList<Contact> list;

    ContactList() {
        this.list = new ArrayList<Contact>();

    }

    ContactList(Contact[] contacts) {
        this.list = (ArrayList<Contact>) Arrays.asList(contacts);
    }

    public Contact findByLastName(String last) {
        return null;

    }

    public Contact findByPhoneNumber(String phone) {
        return null;

    }

    public ContactList findAllByLastInitial(char ch) {
        return null;
        
    }

    public ContactList findAllByCity(String city) {
        return null;
        
    }

    public boolean add(Contact c) {
        return false;
    }

    public int size() {
        return 0;
    }

    public Contact remove(Object obj) {
        return null;
    } 

    public Contact get(int index) {
        return null;
    }

    public boolean equals(Object obj) {
        return false;
    }

    public String toString() {
        return null;
    }

    @Override
    public Iterator<Contact> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {

    }
    
}