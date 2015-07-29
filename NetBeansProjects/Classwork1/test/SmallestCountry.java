/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class SmallestCountry {

    public static void main(String[] args) {
        Comparable[] countries = new Comparable[3];
        countries[0] = new Country("Mexico", 761602, 113724226);
        countries[1] = new Country("Brazil", 3286470, 203429773);
        countries[2] = new Country("Bolivia", 424162, 10118683);
        Comparable smallest = Util.smallest(countries); //write to code to print the name of the smallest country
        System.out.println(((Country) smallest).getName());

    }
}
