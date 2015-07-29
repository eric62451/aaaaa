
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class CPIConverter {

    private static final int FIRST_YEAR = 1913;
    private static final int LAST_YEAR = 2003;
    private double[] cpi;

    public void read(String location) throws MalformedURLException, IOException {
        cpi = new double[LAST_YEAR - FIRST_YEAR + 1];
        URL cpiURL = new URL(location);
        InputStream cpiIn = cpiURL.openStream();
        Scanner in = new Scanner(cpiIn);
        Map<String, Integer> freqs = new TreeMap<String, Integer>();
        while (in.hasNext()) {
            String word = in.next();
            freqs.put(word, freqs.get(word) + 1);
        }

        for (int i = 1913; i <= 2003; i++) {
            in.next();
            cpi[i - FIRST_YEAR] = Double.parseDouble(in.next());
        }
    }

    public double equivalentAmount(double amount, int fromYear, int toYear) {
        amount = (amount / cpi[fromYear - FIRST_YEAR]) * cpi[toYear - FIRST_YEAR];
        return amount; // We'll fix this later
    }
}
