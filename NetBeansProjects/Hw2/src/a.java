
import java.awt.Rectangle;
import java.lang.Object;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class a {

    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10, 20, 30);
        Object s = r.toString();
        if (s instanceof Rectangle) {
            System.out.println(s);
        }

    }
}
