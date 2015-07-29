/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eric Tam
 */
public class Tests {

    public Tests() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertTesting() {
        TwoThreeTree a = new TwoThreeTree();
        for (int i = -100; i < 200; i++) {
            assertTrue(a.insert(i));
        }
        for (int i = 500; i >= 200; i--) {
            assertTrue(a.insert(i));
        }
        for (int i = -100; i < 500; i++) {
            assertFalse(a.insert(i));
        }
    }

    @Test
    public void randomSearch() {
        TwoThreeTree a = new TwoThreeTree();
        for (int i = -100; i < 500; i++) {
            a.insert(i);
        }
        for (int i = -105; i < 505; i++) {
            assertNotNull(a.search(i));
        }

    }

    @Test
    public void emptySearch() {
        TwoThreeTree a = new TwoThreeTree();
        String result = a.search(7);
        String expected = "";
        assertEquals(expected, result);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
