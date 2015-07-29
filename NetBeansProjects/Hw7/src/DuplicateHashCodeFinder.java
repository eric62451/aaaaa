
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DuplicateHashCodeFinder {

    Scanner in;//instance variables if any
    Map<Integer, Set<String>> hashMap = new TreeMap<Integer, Set<String>>();

    /**
     * Creates a DuplicateHashCodeFinder for the given InputStream
     * @param in the Stream to use
     */
    public DuplicateHashCodeFinder(InputStream in) {
        this.in = new Scanner(in);
        this.in.useDelimiter("[^a-zA-Z]+");
        /*
        String word;
        while (this.in.hasNext()) {
        word = this.in.next();
        System.out.println(word.hashCode() + ": " + word);
         */
    }

    /**
     * Gets words with the duplicate hascodes found for this DuplicateHashCodeFinder
     * @return a Map whose keys are hashcodes and whose values are sets containing words
     * with the same hashcodes
     */
    public Map<Integer, Set<String>> getDuplicateHashcodes() {
        Map<Integer, Set<String>> duplicated = new TreeMap<Integer, Set<String>>();
        String word;
        while (in.hasNext()) {
            word = in.next();
            if(!(hashMap.get(word.hashCode()) == null))
            {
                hashMap.get(word.hashCode()).add(word);
            } else {
            hashMap.put(word.hashCode(), new TreeSet<String>());
            hashMap.get(word.hashCode()).add(word);
            }
            if (hashMap.get(word.hashCode()).size() > 1) {
                duplicated.put(word.hashCode(), hashMap.get(word.hashCode()));
            }
    }
    return duplicated;
}

}
