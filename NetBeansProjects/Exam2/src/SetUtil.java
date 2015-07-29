
import java.util.Set;
import java.util.TreeSet;

public class SetUtil
{

    public static Set union(Set A, Set B)
    {
       Set unite = new TreeSet();
       unite.addAll(A);
       unite.addAll(B);
       return unite;
    }
}