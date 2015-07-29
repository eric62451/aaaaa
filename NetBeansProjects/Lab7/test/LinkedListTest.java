
import java.util.Arrays;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays.*;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class LinkedListTest {

    private LinkedList sampleList;

    @BeforeClass
    public static void start() {
        Logger.global.addHandler(new StreamHandler(System.out, new SimpleFormatter()));
    }

    @Before
    public void setUp() {
        sampleList = new LinkedList();
        sampleList.addFirst("lamb");
        sampleList.addFirst("little");
        sampleList.addFirst("a");
        sampleList.addFirst("had");
        sampleList.addFirst("mary");
    }

    @Test
    public void testGet() {
        Object result = sampleList.get(3);
        assertEquals(result, "little");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBounds() {
        sampleList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBounds2() {
        sampleList.get(5);
    }

    @Test
    public void testAdd() {
        sampleList.add(4, "lazy");
        assertEquals(sampleList.get(3), "little");
        assertEquals(sampleList.get(4), "lazy");
        assertEquals(sampleList.get(5), "lamb");
    }

        @Test
    public void testAdd1() {
        sampleList.add(5, "lazy");
        assertEquals(sampleList.get(4), "lamb");
        assertEquals(sampleList.get(5), "lazy");
        assertEquals(sampleList.get(3), "little");
    }
}
