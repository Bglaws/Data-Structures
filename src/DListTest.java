
import java.util.ListIterator;


public class DListTest<E> extends DList<E> {
    public static void main(String[] args) {

        DList<String> a = new DList<String>();
        DList<Integer> b = new DList<Integer>();

        String elem1 = "P";
        String elem2 = "O";
        String elem3 = "P";
        String elem4 = "C";
        String elem5 = "O";
        String elem6 = "R";
        String elem7 = "N";

        int elem8 = 1;

        a.addFirst(elem1);
        a.addFirst(elem2);
        a.addFirst(elem3);
        a.addLast(elem4);
        a.addLast(elem5);
        a.addLast(elem6);
        a.addLast(elem7);

        b.addFirst(elem8);

        ListIterator<String> it = a.listIterator();
        
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        System.out.println("\n------- \n");

        ListIterator<String> descendingIt = a.descendingIterator();

        while (descendingIt.hasNext()) {
            System.out.println(descendingIt.next());
        }
        
        String[] arr = (String[]) a.toArray();

    }
}
