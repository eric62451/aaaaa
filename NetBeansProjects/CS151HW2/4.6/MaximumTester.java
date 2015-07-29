
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class MaximumTester {

    public static String maximum(ArrayList<String> a, Comparator<String> c){
        String max = a.get(0);
        for(String i : a){
            if(c.compare(max, i) == -1) max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("fire");
        strings.add("ice");
        strings.add("water");
        strings.add("name");
        strings.add("hello world!");
        strings.add("Testomg 1234");
        strings.add("Longest String");
        System.out.println(maximum(strings, new Comparator<String>(){

            public int compare(String one, String two) {
                if(one.length()>two.length()) return 1;
            if(one.length()<two.length()) return -1;
            return 0;
            }

        }));
        System.out.println("Expected: Longest String");
    }
}
