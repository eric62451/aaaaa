import java.util.LinkedList;
import java.util.ListIterator;

public class Homework3A {

    public static void main(String[] args)//...
    {
LinkedList<String> myLList = new LinkedList<String>();
myLList.add("Mary");
myLList.add("John");
myLList.add("Sue");
ListIterator<String> iterator = myLList.listIterator();
iterator.next();
iterator.next();
 iterator.add("Robert");
iterator.previous();
iterator.previous();
iterator.remove();
System.out.println(myLList);
    }

    private static int clean(String s) {
        String cleaned = s.replace("$", "");
        cleaned = cleaned.replace(",", "");
        //extra protection
        try {
            return Integer.parseInt(cleaned);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
