package src;

public class DListTest {
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
}
