
import javax.swing.*;

/**
 *
 * @author Jay
 */
public class Main {

    public static void main(String[] args) {
        Runnable r1 = new Car(50);
        Runnable r2 = new Car(10);
        Runnable r3 = new Car(30);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        
        t1.start();
        t2.start();
        t3.start();
    }
}