
import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class tester {
    public static void main(String[] args)
   {
        Prog3 a = new Prog3();
        ThreeNPlusOne b = new ThreeNPlusOne();
        for(int i = 1; i<1000000;i++){
            a.cycleLength(i);
            b.cycleLength(i);
            if(!Arrays.equals(a.retu(), b.retu())) {
                System.out.println(i);
            }
        }
    }

}
