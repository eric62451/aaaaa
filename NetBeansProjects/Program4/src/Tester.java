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
        TaskSet ts = new TaskSet();
        ts.addTask(8); //adds task 0 with time 8
        ts.addTask(3); //adds task 1 with time 3
        ts.addTask(5); //adds task 2 with time 5
        ts.addConstraint(0, 1);
        ts.addConstraint(1, 2);
        System.out.println(ts.getStartTime(0));
        ts.addConstraint(2, 0);
        System.out.println(ts.getStartTime(0));
        ts.addTask(6);
        ts.addTask(7);
        ts.addTask(8);
        ts.addTask(9);
        ts.addConstraint(3, 4);
        System.out.println(ts.getStartTime(3));
        ts.addConstraint(3, 6);
        System.out.println(ts.getStartTime(3));
        ts.addConstraint(3, 5);
        System.out.println(ts.getStartTime(3));
        ts.addConstraint(3, 1);
        System.out.println(ts.getStartTime(3));
    }
}
