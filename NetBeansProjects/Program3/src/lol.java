/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class lol {
public static int maxcycle(int i, int j){
            int max = 0;
        int length;
        while (i <= j) {
            long n = i;
            length = 1;
            while (n != 1) {
                n = (n % 2 == 1) ? 3 * n + 1 : n / 2;
                length++;
            }
            max = (length > max) ? length : max;
            i++;
        }
        return max;
}
}
