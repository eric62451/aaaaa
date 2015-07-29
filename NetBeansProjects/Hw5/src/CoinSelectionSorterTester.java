import java.util.Arrays;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kathleen
 */
public class CoinSelectionSorterTester
{

    public static void main(String[] args)
    {
        Coin[] coins = {new Coin(.25, "quarter"),
                        new Coin(.01, "penny"),
                        new Coin(-.10,"dime"),
                        new Coin(.05, "dollar"),
                        new Coin(0, "nickel")
                       };

        CoinSelectionSorter sorter = new CoinSelectionSorter(coins);
        sorter.sort();

        System.out.println(Arrays.toString(coins));
        System.out.println("Expected: [Coin[value=0.01,name=penny], Coin[value=0.05,name=nickel], Coin[value=0.1,name=dime], Coin[value=0.25,name=quarter], Coin[value=1.0,name=dollar]]");
    }

}
