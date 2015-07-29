import java.util.Set;
import java.util.Map;
public class Homework7B
{
    public static void main(String[] args)
    {
      DuplicateHashCodeFinder searcher = new DuplicateHashCodeFinder(System.in);
      Map<Integer, Set<String>> map = searcher.getDuplicateHashcodes();
      Set<Integer> hashcodeKeys = map.keySet();
      for (Integer key : hashcodeKeys)
      {
         System.out.println(key + ": " + map.get(key));
      }
    }
}