
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class FilterTester {

    public static String[] filter(String[] a, Filter f) {
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            if (f.accept(a[i])) {
                temp.add(a[i]);
            }
        }
        String[] answer = new String[temp.size()];
        int j = 0;
        for (String i : temp) {
            answer[j] = i;
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a = new String[10];
        a[0] = "abcd";
        a[1] = "123";
        a[2] = "water";
        a[3] = "fire";
        a[4] = "ice";
        a[5] = "one";
        a[6] = "two";
        a[7] = "three";
        a[8] = "four";
        a[9] = "six";
        String[] b = filter(a, new Filter() {

            public boolean accept(String x) {
                if (x.length() < 4) {
                    return true;
                }
                return false;
            }
        });
        for(int i = 0; i<b.length;i++){
            System.out.println(b[i]);
        }


    }
}
