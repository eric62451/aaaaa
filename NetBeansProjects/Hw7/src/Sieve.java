
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sieve {

    Set<Integer> primes = new TreeSet<Integer>();//instance variables if needed
    private int max;

    /**
     * Constructs a Sieve to handle the specified number
     * @param maxPrime the maximum prime to find
     */
    public Sieve(int maxPrime) {
        max = maxPrime;

    }

    /**
     * Gets primes less than the value of this Sieve
     * @return the primes less than the value of this Sieve
     */
    public Set<Integer> getPrimes() {
        int temp;
        for (int i = 2; i < max; i++) {
            primes.add(i);
        }
        int i = 2;
        while (i < Math.sqrt(max)) {
            Iterator<Integer> iter = primes.iterator();
            while(iter.hasNext()){
                temp = iter.next();
                if((temp % i == 0) && !(temp == i)) iter.remove(); 
            }
            i++;
            }
        return primes;
    }
}
