
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class BinarySearcherWithComparator {

    Object[] array;
    Comparator compare;

    public BinarySearcherWithComparator(Object[] array, Comparator compare) {
        this.array = array;
        this.compare = compare;
    }

    public int search(Object target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int diff = compare.compare(array[mid], target);
            if (diff == 0)
            {
                return mid;
            } else if (diff < 0) // a[mid] < v
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
