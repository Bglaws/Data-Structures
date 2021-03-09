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
        this.list = new ArrayList<Contact>();

        for (int i = 0; i < contacts.length; i++) {
            this.list.add(contacts[i]);
        }
    }

    public Contact findByLastName(String last) {

        int middle;
        int firstElement = 0;
        int lastElement = this.size() - 1;

        while (firstElement <= lastElement) {
            middle = firstElement + (lastElement - 1) / 2;
            Contact e = this.get(middle);

            if (last.equals(e.getLast())) {
                return e;
            }
            if (last.compareTo(e.getLast()) == 1) {
                firstElement = middle + 1;
            } else
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

        int middle;
        int firstElement = 0;
        int lastElement = this.size() - 1;

        while (firstElement <= lastElement) {
            middle = firstElement + (lastElement - 1) / 2;
            Contact e = this.get(middle);

            if (firstElement == lastElement) {
                if (c.compareTo(e) == 1) {
                    this.list.add(firstElement + 1, c);
                    return true;
                } else
                    this.list.add(firstElement - 1, c);
                return true;
            }

            if (c.getLast().equals(e.getLast())) {
                return false;
            }
            if (c.compareTo(e) == 1) {
                firstElement = middle + 1;
            } else
                lastElement = middle - 1;
        }
        return false;
    }

    public int size() {
        return this.list.size();
    }

    public Contact remove(Object obj) {

        int firstElement = 0;
        int lastElement = this.size() - 1;

        while (firstElement <= lastElement) {
            int middle = firstElement + lastElement / 2;
            Contact e = this.get(middle);

            if (obj.compareTo(e) == 0) {
                this.list.remove(e);
                return e;
            }
            if (obj.compareTo(e) == 1) {
                firstElement = middle + 1;
            } else
                lastElement = middle - 1;
        }
        return null;
    }

    public Contact get(int index) {
        return this.list.get(index);
    }

    public boolean equals(Object obj) {

        Iterator<Contact> it = this.list.iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj) == false) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        Iterator<Contact> it = this.list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        return null;
    }

    @Override
    public Iterator<Contact> iterator() {
        return this.list.iterator();
    }

    public static void main(String[] args) {

        Contact a = new Contact("Brian", "Glaws", "(123) 456-7890", "2900 Beford Avenue", "Brooklyn", "NY");
        Contact b = new Contact("Charlie", "Glaws", "(123) 456-7890", "10 New Road", "Sedona", "AZ");
        Contact c = new Contact("Santa", "Claus", "(098) 765-4321", "123 Elf Road", "Northpole", "NJ");
        Contact d = new Contact("Michael", "Jordan", "(111) 222-3333", "Bulls Avenue", "Chicago", "IL");
        Contact e = new Contact("Michael", "Corleone", "(404) 443-8080", "Mafia Boulevard", "Little Italy", "NY");
        Contact f = new Contact("Luke", "Skywalker", "(003) 909-1003", "Mos Eisley", "Tatooine", "CA");
        Contact g = new Contact("Emily", "Lion", "(313) 411-9111", "Knickerbocker Street", "Lake Tahoe", "NV");

        Contact[] contactsA = { a, b, c };
        Contact[] contactsB = { a, b, c };
        Contact[] contactsC = { a, b, c, d, e, f, g };

        // identical lists
        ContactList listA = new ContactList(contactsA);
        ContactList listB = new ContactList(contactsB);
        ContactList listC = new ContactList(contactsC);

        listA.equals(listB);
        listA.add(g);
        listA.toString();

        // listC.toString();

    }

}