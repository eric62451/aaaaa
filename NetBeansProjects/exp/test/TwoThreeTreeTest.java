
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class TwoThreeTreeTest {
    

    public TwoThreeTreeTest() {
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
    public void Tree()
    {
        TwoThreeTree t = new TwoThreeTree();
        t.insert(1);
        t.insert(9);
        t.insert(15);
        t.insert(13);
        t.insert(20);
        t.insert(7);
        t.insert(4);
        assertEquals("9", t.search(9));
        assertEquals("1", t.search(1));
        assertEquals("15", t.search(15));
        assertEquals("13", t.search(13));
        assertEquals("4", t.search(4));
        assertEquals("13", t.search(12));
    }
     @Test
    public void insertTesting() {
        TwoThreeTree a = new TwoThreeTree();
        for (int i = 1; i < 200; i++) {
            assertTrue(a.insert(i));
        }
        for (int i = 1; i < 200; i++) {
            assertFalse(a.insert(i));
        }
    }
    @Test
    public void emptySearch() {
        TwoThreeTree t = new TwoThreeTree();
        assertEquals("", t.search(10));
    }
    @Test
    public void randomSearch() {
        TwoThreeTree t = new TwoThreeTree();
        for (int i = 1; i < 350; i++) {
            t.insert(i);
        }
        for (int i = -100; i <100; i++) {
            assertNotNull(t.search(i));
        }
    }

    }
