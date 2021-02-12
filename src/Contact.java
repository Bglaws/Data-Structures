package src;

public class Contact implements Comparable <Contact>{
    
    private String first;
    private String last;
    private String number;
    private String address;
    private String city;
    private String state;

    public Contact(String first, String last, String number, String address, String city, String state) {
        this.first = first;
        this.last = last;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public Contact(String first, String last, String number) {
        this.first = first;
        this.last = last;
        this.number = number;
    }

    public String getFirst() {
        return this.first;
    }
    public String getLast() {
        return this.last;
    }
    public String getNumber() {
        return this.number;
    }
    public String getAddress() {
        return this.address;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }

    // full update
    public void update(String first, String last, String number, String address, String city, String state) {
        this.first = first;
        this.last = last;
        this.number = number;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    // partial update
    private void update(String first, String last, String number) {
        this.first = first;
        this.last = last;
        this.number = number;
    }

    @Override
    public int compareTo(Contact o) {
        // last name of calling obj
        int aLength = this.getLast().length();
        // last name of other object
        int bLength = o.getLast().length();
        int size = 0;

        if (aLength <= bLength) {
            size = aLength;
        }
        else size = bLength;
  
        for (int i = 0; i < size; i++) {
            if (this.getLast().charAt(i) < o.getLast().charAt(i)){
                return -1;
            }
            if (this.getLast().charAt(i) > o.getLast().charAt(i)){
                return 1;
            }
        }

        aLength = this.getFirst().length();
        bLength = o.getFirst().length();
        if (aLength <= bLength) {
            size = aLength;
        }
        else size = bLength;

        for (int j = 0; j < size; j++) {
            if (this.getFirst().charAt(j) < o.getFirst().charAt(j)) {
                return -1;
            }
            if (this.getFirst().charAt(j) > o.getFirst().charAt(j)) {
                return 1;
            }
        } 
        return 0;
    }

    public boolean equals(Object o) {
        return this.getFirst() == ((Contact) o).getFirst() && this.getLast() == ((Contact) o).getLast();
    }

    public String toString() {
        if (this.getAddress() == null || this.getCity() == null || this.getState() == null) {
            return this.getFirst() + " " + this.getLast() + "       Phone number: " + this.getNumber();
        }
        return this.getFirst() + " " + this.getLast() + "       Phone number: " + this.getNumber() +
        "\n" + this.getAddress() + "\n" + this.getCity() + ", " + this.getState();
    }

    public static void main(String[] args) {

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
