
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Testing {

    public static void main(String[] args) {
        Queue<String> s = new LinkedList<String>();
        Stack<String> d = new Stack<String>();
        s.add("A");
        s.add("B");
        s.add("C");
        s.add("X");
        s.add("Y");
        s.add("Z");
        d.add(s.remove());
        d.add(s.remove());
        d.add(s.remove());
        d.add(s.remove());
        d.add(s.remove());
        d.add(s.remove());
        System.out.print(d.pop());
        System.out.print(d.pop());
        System.out.print(d.pop());
        System.out.print(d.pop());
        System.out.print(d.pop());
        System.out.print(d.pop());
    }
}
