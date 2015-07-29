
import java.util.Arrays;
import java.util.Comparator;

public class LengthSorter {

    public static void main(String[] args) {
        class StringLengthComparator implements Comparator {

            public int compare(Object o1, Object o2) {
                String first = (String) o1;
                String second = (String) o2;
                if (first.length() == second.length()) {
                    return 0;
                }
                if (first.length() < second.length()) {
                    return -1;
                }
                return 1;
            }
        }

        String[] names = {"Oklahoma", "Maryland", "California", "Nevada",
            "Texas", "Arizona"};

        Arrays.sort(names, new StringLengthComparator());//... code to sort the array.
        System.out.println(Arrays.toString(names));
    }
}
