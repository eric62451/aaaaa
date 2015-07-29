/*
Eric Tam
007989423
CS154
2/6/2015
*/

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationsTester {

    public static void main(String[] args) {
        Set a = new TreeSet<String>();
        Set b = new HashSet<String>();
        Set c = new HashSet<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        b.add("d");
        b.add("e");
        b.add("f");
        b.add("g");
        c.add("f");
        c.add("g");
        
        Set w = Operations.union(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("\nUNION TEST");
        System.out.println("a union b = " + w);
        w = Operations.union(a, c);
        System.out.println("a union c = " + w);

        w = Operations.intersect(a, b);
        System.out.println("\nINTERSECT TEST");
        System.out.println("a intersect b = " + w);
        w = Operations.intersect(b, c);
        System.out.println("b intersect c = " + w);
        
        w = Operations.diff(a, b);
        System.out.println("\nDIFF TEST");
        System.out.println("a diff b = " + w);
        w = Operations.diff(b, c);
        System.out.println("b diff c = " + w);

        Boolean d = Operations.subset(a, b);
        System.out.println("\nSUBSET TEST");
        System.out.println("a subset b: " + d);
        d = Operations.subset(c, b);
        System.out.println("c subset b: " + d);

        a = new HashSet<Integer>();
        // a = first 20 multiples of 3
        for (int i = 0; i < 20; i++) {
            a.add(i * 3);
        }
        
        b = Operations.filter(a, (Integer x) -> x % 2 == 0);
        w = Operations.map(b, (Integer x) -> 2 * x);
        System.out.println("\nFilter and map test");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + w);

        System.out.println("\nPower Set test");
        Set<Integer> e = new HashSet<Integer>();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(4);
        e.add(5);
        System.out.println("Set: "+ e);
        for (Set<Integer> s : Operations.power(e)) {
            System.out.println(s);
        }
        
        System.out.println("\nDigit to unicode test");
        try {
            System.out.println("1 = "+Operations.digitToUnicode(1));
            System.out.println("9 = "+Operations.digitToUnicode(9));
            System.out.println("3 = "+Operations.digitToUnicode(3));
            System.out.println("10 = "+Operations.digitToUnicode(10));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
