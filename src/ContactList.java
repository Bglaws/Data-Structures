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

        int firstElement = 0;
        int lastElement = this.size() - 1;

        while (firstElement <= lastElement) {
            int middle = firstElement + lastElement / 2;
            Contact e = this.get(middle);

            if (last.equalsIgnoreCase(e.getLast())) {
                return e;
            }
            if (last.compareTo(e.getLast()) == 1) {
                firstElement = middle + 1;
            }
            else
                lastElement = middle - 1;
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

        Iterator<Contact> it = iterator();
        ContactList lastInitialList = new ContactList();

        while (it.hasNext()) {
            Contact contact = it.next();
            if (ch == contact.getLast().charAt(0)) {
                lastInitialList.add(contact);
            }
        }
        return lastInitialList;

    }

    public ContactList findAllByCity(String city) {

        Iterator<Contact> it = iterator();
        ContactList allCityList = new ContactList();

        while (it.hasNext()) {
            Contact contact = it.next();
            if (city == contact.getCity()) {
                allCityList.add(contact);
            }
        }
        return allCityList;
    }

    public boolean add(Contact c) {

        if (this.list.isEmpty()) {
            this.add(c);
            return true;
        }

        int firstElement = 0;
        int lastElement = this.size() - 1;

        while (firstElement <= lastElement) {
            int middle = firstElement + lastElement / 2;
            Contact e = this.get(middle);

            if (c.getLast().equalsIgnoreCase(e.getLast())) {
                return e;
            }
            if (last.compareTo(e.getLast()) == 1) {
                firstElement = middle + 1;
            }
            else
                lastElement = middle - 1;
        }
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

        for (Contact l : this) {
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
       return this.iterator();
    }

    public static void main(String[] args) {


        Contact a = new Contact("Brian", "Glaws", "(123) 456-7890", "2900 Beford Avenue", "Brooklyn", "NY");
        Contact b = new Contact("Charlie", "Glaws", "(123) 456-7890", "10 New rd", "Sedona", "AZ");
        Contact c = new Contact("Santa", "Claus", "(098) 765-4321", "123 Elf Road", "Northpole", "NJ");
        Contact[] contacts = {a,b,c};
       
       
        ContactList listA = new ContactList(contacts);
        ContactList listB = new ContactList(contacts);

        Contact a = new Contact("Brian", "Glaws", "(123) 456-7890", "2900 Beford Avenue", "Brooklyn", "NY");
        System.out.println(a);

        Contact b = a;
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));

        a.update("Charlie", "Glaws", "(123) 456-7890", "10 New rd", "Sedona", "AZ");
        System.out.println(a.compareTo(b));
        System.out.println(a.equals(b));
        System.out.println(a);
        
        a.update("Santa", "Claus", "(098) 765-4321", "123 Elf Road", "Northpole", "NJ");
        System.out.println(a.compareTo(b));

        Contact c = new Contact("Vito", "Corleone", "(111) 222-3333");
        System.out.println(c);

        c.update("Michael", "Corleone", "(333) 222-1111");
        System.out.println(c);
        System.out.println(c.compareTo(a));

    }

}