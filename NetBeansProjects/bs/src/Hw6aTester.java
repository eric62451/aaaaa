import java.util.Comparator;


public class Hw6aTester{
        static int counter;
    public static void main(String[] args)
    {
        Integer[] in1 = {14, 4, 6, 13, 2, 3, 12, 1, 7, 10, 9, 0, 15, 5, 8, 11};
        Comparator comp = new Comparator() {

            @Override
    public int compare(Object o1, Object o2) {
        Integer s1 = (Integer)o1;
        Integer s2 = (Integer)o2;
        counter++;

        return s1.compareTo(s2);
    }
        };
        Hw6a hw6a = new Hw6a(in1, comp);
        hw6a.sort();
        System.out.println("Expected:  30");
    }
}
