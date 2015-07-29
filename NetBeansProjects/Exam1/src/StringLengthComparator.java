
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class StringLengthComparator implements Comparator{

    public int compare(Object o1, Object o2) {
        String first = (String) o1;
        String second = (String) o2;
        if(first.length()==second.length()) return 0;
        if(first.length()<second.length()) return -1;
        return 1;
    }
 
}
