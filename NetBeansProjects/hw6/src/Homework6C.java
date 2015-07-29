
import java.util.LinkedList;
import java.util.ListIterator;

public class Homework6C {

    public static void reverse(LinkedList<String> list) {
        ListIterator<String> iter = list.listIterator();
        if (iter.hasNext()) {
            String temp;
            temp = iter.next();
            iter.remove();
            reverse(list);
            list.addLast(temp);
        }
    }
}
