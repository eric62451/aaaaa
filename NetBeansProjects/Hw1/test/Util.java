
import java.util.Comparator;

public class Util {

    public static Object largest(Object[] values, Comparator comp) {
        int largestLocation = 0;
        for (int i = 0; i < values.length; i++) {
            if(comp.compare(values[largestLocation], values[i])<1){
                largestLocation = i;
            }
        }
        return values[largestLocation];
    }
}
