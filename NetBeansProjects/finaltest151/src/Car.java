
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Jay
 */
public class Car implements Runnable {

    private final double width;
    private Lock testLock = new ReentrantLock();
    private Lock test2 = new ReentrantLock();

    public Car(double w) {
        width = w;
    }

    @Override
    public void run() {
        try {
            
            Thread.sleep(10000);
            System.out.println(1);
        
        } catch (InterruptedException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
