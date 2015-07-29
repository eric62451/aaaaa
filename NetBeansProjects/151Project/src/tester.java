/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class tester {
    public static void main(String[] args){
        Scheduler sched = new Scheduler();
        sched.add(new Event("2", 18, 11, 2013, 5, 30, "6:00"));
        sched.add(new Event("1", 17, 11, 2013, 5, 30, "6:00"));
        if(!sched.add(new Event("1", 17, 11, 2013, 5, 30, "6:00"))){
            System.out.println("false");
        }

    }

}
