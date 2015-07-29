/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class Tester {

    public static void main(String[] args) {
        TwoThreeTree a = new TwoThreeTree();
        for (int i = -100; i < 500; i++) {
            a.insert(i);
        }
        System.out.println("done");
    }
}
