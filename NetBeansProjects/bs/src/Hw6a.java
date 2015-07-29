
import java.util.Comparator;

public class Hw6a {

    Object[] a;
    Comparator com;

    public Hw6a(Object[] anArray, Comparator aComparator) {
        a = anArray;
        com = aComparator;
        /**great code here, and everywhere else*/
    }

    public void sort() {
        Object[][] sorterArray = new Object[a.length][1];
        for (int i = 0; i < a.length; i++) {
            sorterArray[i][0] = a[i];
        }
        for (int i = a.length; i != 1; i = i / 2) {
            for (int j = 0; j < i; j++) {
                sorterArray[j] = merge(sorterArray[j*2], sorterArray[j*2 + 1], j);
            }
        }
        a = sorterArray[0];
    }

    private Object[] merge(Object[] first, Object[] second, int offset) {
        System.out.println("Merging " + offset + "..."
                + (offset + first.length - 1) + " and "
                + (offset + first.length) + "..."
                + (offset + first.length + second.length - 1));
        int iFirst = 0; // Next element to consider in the first array
        int iSecond = 0; // Next element to consider in the second array
        int j = 0; // Next open position in a
        Object[] a = new Object[first.length + second.length];

        // As long as neither iFirst nor iSecond is past the end, move
        // the smaller element into a
        while (iFirst < first.length && iSecond < second.length) {
            if (com.compare(first[iFirst], second[iSecond]) < 0) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // Note that only one of the two loops below copies entries
        // Copy any remaining entries of the first array
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }
        // Copy any remaining entries of the second half
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
        return a;
    }
}
