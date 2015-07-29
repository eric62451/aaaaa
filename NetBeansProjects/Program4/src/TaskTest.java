/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class TaskTest {

    public static void main(String[] args)
    {
        TaskSet ts = new TaskSet();
ts.addTask(8); //adds task 0 with time 8
ts.addTask(3); //adds task 1 with time 3
ts.addTask(5); //adds task 2 with time 5
System.out.println(ts.minCompletionTime()); //should return 8, since task 0 takes time 8 to complete.
/* Note it is not the min completion time of any task, but the earliest the entire set can complete. */
ts.addConstraint(0, 2); //task 2 must precede task 0
System.out.println(ts.minCompletionTime()); //should return 13 (task 0 cannot start until time 5)
ts.addConstraint(0, 1); //task 1 must precede task 0
System.out.println(ts.minCompletionTime()); //should return 13
System.out.println(ts.getStartTime(0)); //should return 5
System.out.println(ts.getStartTime(1)); //should return 0
System.out.println(ts.getStartTime(2)); //should return 0
ts.addConstraint(1, 2); //task 2 must precede task 1
System.out.println(ts.minCompletionTime()); //should return 16
System.out.println(ts.getStartTime(0)); //should return 8
System.out.println(ts.getStartTime(1)); //should return 5
System.out.println(ts.getStartTime(2)); //should return 0
ts.addConstraint(1, 0); //task 0 must precede task 1 (creates loop)
System.out.println(ts.minCompletionTime()); //should return -1
System.out.println(ts.getStartTime(0)); //should return -1
System.out.println(ts.getStartTime(1)); //should return -1
System.out.println(ts.getStartTime(2)); //should return 0 (no loops in prerequisites)
    }

}