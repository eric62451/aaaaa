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
    public void MaximumCycleTesting() {
            System.out.println(Collatz.maximumCycle(1, 1000000));
            assertTrue(true);
        }


    @Test
    public void LengthTesting() {
        for(int i = 0; i<=19; i++){
            assertEquals(i+1, Collatz.cycleLength((int)Math.pow(2, i)));
            if(i!= 0 && i!= 2 && (Math.pow(2, i)-1)%3==0) {
                assertEquals(i+2, Collatz.cycleLength((int)((Math.pow(2, i))-1)/3));
            }
        }
        }

    @Test
    public void sampleTest(){

   assertEquals(16, Collatz.cycleLength(22));

   assertEquals(20, Collatz.maximumCycle(1, 10));

   assertEquals(125, Collatz.maximumCycle(100, 200));

   assertEquals(89, Collatz.maximumCycle(201, 210));

   assertEquals(174, Collatz.maximumCycle(900, 1000));

}
    }

  
