
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetUtil {

    public static Set intersection(Set A, Set B) {
        Set intersect = new TreeSet();
        Iterator<Object> iter = A.iterator();
        while (iter.hasNext()) {
            Object obj = iter.next();
            if (B.contains(obj)){
                intersect.add(obj);
            }
        }
        return intersect;
    }
}
