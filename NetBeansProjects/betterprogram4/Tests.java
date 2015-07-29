/*
 * Eric Tam
 * CS146
 * Program 3 J-Unit
 */

import java.lang.Math;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void Test1() {
        TaskSet ts = new TaskSet();
        ts.addTask(1);
        for (int i = 2; i < 3000; i++) {
            ts.addTask(i);
            ts.addConstraint(i - 2, i - 1);
        }
        assertEquals(4498500, ts.minCompletionTime());
    }

    @Test
    public void LastTest() {
        TaskSet ts = new TaskSet();
        ts.addTask(5);
        ts.addTask(10);
        ts.addTask(2);
        ts.addTask(15);
        ts.addTask(20);
        ts.addConstraint(0, 1);
        ts.addConstraint(0, 2);
        ts.addConstraint(1, 3);
        ts.addConstraint(3, 1);
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(0, ts.getStartTime(2));

    }

    @Test
    public void buggy() {
        TaskSet ts = new TaskSet();
        ts.addTask(5);
        ts.addTask(10);
        ts.addTask(2);
        ts.addTask(15);
        ts.addTask(20);
        ts.addConstraint(0, 2);
        ts.addConstraint(2, 1);
        ts.addConstraint(0, 1);
        ts.addConstraint(1, 3);
        ts.addConstraint(3, 4);
        ts.addConstraint(3, 1);
        ts.addConstraint(4, 3);
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(1));
        assertEquals(-1, ts.getStartTime(2));
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(4));
    }

    @Test
    public void handgraph() {
        TaskSet ts = new TaskSet();
        ts.addTask(5);
        ts.addTask(10);
        ts.addTask(2);
        ts.addTask(15);
        ts.addTask(20);
        ts.addTask(31);
        ts.addTask(7);
        ts.addConstraint(0, 2);
        ts.addConstraint(0, 1);
        ts.addConstraint(1, 3);
        ts.addConstraint(2, 3);
        ts.addConstraint(1, 4);
        ts.addConstraint(2, 4);
        ts.addConstraint(4, 3);
        ts.addConstraint(1, 6);
        ts.addConstraint(4, 6);
        ts.addConstraint(4, 5);
        ts.addConstraint(5, 6);
        ts.addConstraint(5, 3);
        ts.addConstraint(2, 6);
        ts.addConstraint(3, 6);
        assertEquals(88, ts.minCompletionTime());
        assertEquals(83, ts.getStartTime(0));
        assertEquals(73, ts.getStartTime(2));
        assertEquals(73, ts.getStartTime(1));


    }

    @Test
    public void graph() {
        TaskSet ts = new TaskSet();
        ts.addTask(1);
        ts.addTask(13);
        ts.addTask(20);
        ts.addTask(25);
        ts.addTask(16);
        ts.addTask(7);
        ts.addTask(5);
        ts.addTask(31);
        ts.addTask(19);
        ts.addConstraint(0, 8);
        assertEquals(19, ts.getStartTime(0));
        assertEquals(31, ts.minCompletionTime());
        ts.addConstraint(0, 6);
        assertEquals(19, ts.getStartTime(0));
        assertEquals(31, ts.minCompletionTime());
        ts.addConstraint(8, 2);
        assertEquals(39, ts.getStartTime(0));
        assertEquals(20, ts.getStartTime(8));
        assertEquals(40, ts.minCompletionTime());
        ts.addConstraint(8, 5);
        assertEquals(39, ts.getStartTime(0));
        assertEquals(20, ts.getStartTime(8));
        assertEquals(40, ts.minCompletionTime());
        ts.addConstraint(1, 0);
        assertEquals(40, ts.getStartTime(1));
        assertEquals(53, ts.minCompletionTime());
        ts.addConstraint(7, 4);
        ts.addConstraint(4, 7);
        assertEquals(-1, ts.minCompletionTime());
        ts.addConstraint(2, 7);
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(1));
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(8));
        assertEquals(-1, ts.getStartTime(2));
        assertEquals(0, ts.getStartTime(5));
        assertEquals(0, ts.getStartTime(6));
        ts.addConstraint(6, 5);
        ts.addConstraint(5, 6);
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(1));
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(8));
        assertEquals(-1, ts.getStartTime(2));
        assertEquals(-1, ts.getStartTime(5));
        assertEquals(-1, ts.getStartTime(6));
        ts.addConstraint(2, 4);
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(1));
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(8));
        assertEquals(-1, ts.getStartTime(2));
        assertEquals(-1, ts.getStartTime(5));
        assertEquals(-1, ts.getStartTime(6));
        ts.addConstraint(1, 4);
        ts.addConstraint(4, 1);
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(1));
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(8));
        assertEquals(-1, ts.getStartTime(2));
        assertEquals(-1, ts.getStartTime(5));
        assertEquals(-1, ts.getStartTime(6));
        ts.addTask(33);
        ts.addTask(66);
        ts.addTask(80);
        ts.addTask(75);
        ts.addTask(100);
        assertEquals(0, ts.getStartTime(9));
        assertEquals(0, ts.getStartTime(10));
        assertEquals(0, ts.getStartTime(11));
        assertEquals(0, ts.getStartTime(12));
        assertEquals(0, ts.getStartTime(13));
        assertEquals(-1, ts.minCompletionTime());
        ts.addConstraint(9, 10);
        ts.addConstraint(10, 11);
        ts.addConstraint(11, 12);
        ts.addConstraint(12, 13);
        assertEquals(-1, ts.minCompletionTime());
        assertEquals(321, ts.getStartTime(9));
        assertEquals(255, ts.getStartTime(10));
        assertEquals(175, ts.getStartTime(11));
        assertEquals(100, ts.getStartTime(12));
        assertEquals(0, ts.getStartTime(13));
        assertEquals(-1, ts.minCompletionTime());
        ts.addConstraint(13, 0);
        //assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(9));
        assertEquals(-1, ts.getStartTime(10));
        assertEquals(-1, ts.getStartTime(11));
        assertEquals(-1, ts.getStartTime(12));
        assertEquals(-1, ts.getStartTime(13));
    }

    @Test
    public void NoConstraint() {
        TaskSet ts = new TaskSet();
        for (int i = 1; i < 1000; i++) {
            ts.addTask(i);
            assertEquals(0, ts.getStartTime(i - 1));
            assertEquals(i, ts.minCompletionTime());
        }

        for (int i = 2000; i > 1000; i--) {
            ts.addTask(i);
            assertEquals(0, ts.getStartTime(i - 1001));
            assertEquals(2000, ts.minCompletionTime());
        }
        for (int i = 1; i < 1000; i++) {
            ts.addTask(i);
            assertEquals(0, ts.getStartTime(i - 1));
        }
        assertEquals(2000, ts.minCompletionTime());

    }

    @Test
    public void LoopTest() {
        TaskSet ts = new TaskSet();
        for (int i = 1; i < 100; i++) {
            ts.addTask(i);
        }
        ts.addConstraint(8, 9);
        ts.addConstraint(9, 8);
        ts.addConstraint(0, 8);
        ts.addConstraint(7, 0);
        ts.addConstraint(7, 10);
        ts.addConstraint(10, 7);
        //assertEquals(-1, ts.minCompletionTime());
        assertEquals(-1, ts.getStartTime(7));
        assertEquals(-1, ts.getStartTime(0));
        assertEquals(-1, ts.getStartTime(8));
        assertEquals(-1, ts.getStartTime(9));
        assertEquals(-1, ts.getStartTime(10));
        assertEquals(-1, ts.minCompletionTime());
    }

    @Test
    public void Test2() {
        TaskSet ts = new TaskSet();
        ts.addTask(1);
        ts.addTask(2);
        ts.addTask(3);
        ts.addTask(4);
        ts.addTask(5);
        ts.addTask(6);
        ts.addTask(7);
        ts.addTask(8);
        ts.addTask(9);
        ts.addConstraint(0, 1);
        assertEquals(2, ts.getStartTime(0));
        ts.addConstraint(1, 2);
        ts.addConstraint(2, 3);
        assertEquals(9, ts.getStartTime(0));
    }
}
