
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class main {
public static void main(String[] args){
        try {
            CPIConverter conv = new CPIConverter();
            conv.read("ftp://ftp.bls.gov/pub/special.requests/cpi/cpiai.txt");
            double amount = 100000;
            double adjusted = conv.equivalentAmount(amount, 1961, 2003);
            System.out.printf("Adjusted amount: %10.0f\n", adjusted);
        } catch (IOException ex) {
            // Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("IOException Error");
        }
}

}
