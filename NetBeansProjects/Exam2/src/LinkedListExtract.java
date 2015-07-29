
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Kathleen O'Brien
 */
public class LinkedListExtract {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 20; i++) {
            list.addLast("" + i);
        }
        LinkedList extraction = extract(list, 5);
        System.out.println(extraction);
        System.out.println("Expected: [5, 10, 15, 20]");
        System.out.println(list);
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]");

    }

    private static LinkedList extract(LinkedList list, int n) {
        LinkedList aList = new LinkedList();
        ListIterator iter = list.listIterator();
        int count = 1;
        while (iter.hasNext()) {
            if (count % n == 0) {
                aList.add(iter.next());
            } else {
                iter.next();
            }
            count++;
        }

        return aList;
    }
}
