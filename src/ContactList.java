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

        int lowest = 0;
        int highest = this.size() - 1;

        while (lowest <= highest) {
            int middle = lowest + highest / 2;
            Contact e = this.get(middle);

            // Check if x is present at mid
            if (last.equals(e.getLast())) {
                return e;
            }

            // If x greater, ignore left half
            if (last.compareTo(e.getLast()) == 1) {
                lowest = middle + 1;
            }
            // If x is smaller, ignore right half
            else
                highest = middle - 1;
        }
        return null;
    }

    public Contact findByPhoneNumber(String phone) {

        int numContacts = this.size() - 1;
        for (int i = 0; i < numContacts; i++) {
            if (this.get(i).getNumber() == phone) {
                return this.get(i);
            }
        }
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
        return this.size();
    }

    public Contact remove(Object obj) {
        return null;
    }

    public Contact get(int index) {
        return this.get(index);
    }

    public boolean equals(Object obj) {

        for (ContactList l : this) {
            if (l.equals(obj) == false) {
                return false;
            }
        }
        return true;
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

        Contact[] contacts = new Contact[10];

        Contact a = new Contact("Brian", "Glaws", "(123) 456-7890", "2900 Beford Avenue", "Brooklyn", "NY");
        ContactList listA = new ContactList(a);

    }

}