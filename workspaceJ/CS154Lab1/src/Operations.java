/*
Eric Tam
007989423
CS154
2/6/2015
*/

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Operations {

    public static <T> Set<T> intersect(Set<T> a, Set<T> b) {
        Set c = new HashSet<T>();
        for (T i : a) {
            if (b.contains(i)) {
                c.add(i);
            }
        }
        return c;
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set c = new HashSet<T>();
        for (T i : a) {
            c.add(i);
        }
        for (T i : b) {
            c.add(i);
        }
        return c;
    }

    public static <T> Set<T> diff(Set<T> a, Set<T> b) {
        Set c = new HashSet<T>();
        for (T i : a) {
            c.add(i);
        }
        for (T i : b) {
            c.remove(i);
        }
        return c;
    }

    public static <T> boolean subset(Set<T> a, Set<T> b) {
        Boolean answer = true;
        for (T i : a) {
            if (!b.contains(i)) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static <T> Set<T> filter(Set<T> a, Predicate<T> f) {
        Set c = new HashSet<T>();
        for (T i : a) {
            if (f.test(i)) {
                c.add(i);
            }
        }
        return c;
    }

    public static <T> Set<T> map(Set<T> a, UnaryOperator<T> f) {
        Set c = new HashSet<T>();
        for (T i : a) {
            c.add(f.apply(i));
        }
        return c;
    }

    public static <T> Set<Set<T>> power(Set<T> a) {
        Set answer = new HashSet<Set<T>>();
        if (a.isEmpty()) {
            answer.add(new HashSet<T>());
            return answer;
        }
        ArrayList<T> tempList = new ArrayList<T>(a);
        Set<T> b = new HashSet<T>(tempList.subList(1, tempList.size()));
        Set<Set<T>> c = power(b);
        for(Set i : c){
            Set addset = new HashSet<T>();
            addset.addAll(i);
            addset.add(tempList.get(0));
            answer.add(i);
            answer.add(addset);
        }
        return answer;
    }
    
    public static String digitToUnicode(Integer a) throws Exception{
        if(a>=10 || a<0) throw new Exception("integer out of range");
        Map<Integer,String> data = new TreeMap<Integer,String>();
        for(int i = 0;i<10;i++){
            data.put(i, "00"+3+i);
        }
        return data.get(a);
    }

}
