
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class SelectionSorterWithComparator {
Object[] obj;
Comparator comparer;
    public SelectionSorterWithComparator(Object[] array, Comparator comp) {
        obj = array;
        comparer = comp;
    }

    public void sort() {

        for (int i = 0; i < obj.length - 1; i++) {
            int minPos = minimumPosition(i);
            swap(minPos, i);
        }
    }

    /**
    Finds the smallest element in a tail range of the array.
    @param from the first position in a to compare
    @return the position of the smallest element in the
    coin[i].getValue() < obj[minPos].getValue()
     */
    private int minimumPosition(int from) {
        int minPos = from;
        for (int i = from + 1; i < obj.length; i++) {
            if (comparer.compare(obj[i], obj[minPos]) == -1) {
                minPos = i;
            }
        }
        return minPos;
    }

        private void swap(int i, int j) {
        Object temp = obj[i];
        obj[i] = obj[j];
        obj[j] = temp;
    }

}
