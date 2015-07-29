
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class CountryTester {

    public static void main(String[] args) {
        Comparator a = Country.createComparatorByArea(true);
        Comparator b = Country.createComparatorByArea(false);
        Comparator c = Country.createComparatorByName(true);
        Comparator d = Country.createComparatorByName(false);

        ArrayList<Country> array = new ArrayList<Country>();
        array.add(new Country("United States", 1));
        array.add(new Country("Canada", 2));
        array.add(new Country("Mexico", 3));
        array.add(new Country("France", 1));
        ArrayList<Country> temp = array;
        System.out.println("United States, 1");
        System.out.println("Canada, 2");
        System.out.println("Mexico, 3");
        System.out.println("France, 1");
        ArrayList<Country> answer = new ArrayList<Country>();
        Country max;
        int maxN;
        int j;
        System.out.println("Increasing Area");
        while(array.size() != 0){
            max = array.get(0);
            maxN = 0;
            for(j = 0; j<array.size();j++){
                if(a.compare(max, array.get(j)) == -1){
                    max = array.get(j);
                    maxN = j;
                }
            }
            answer.add(max);
            array.remove(maxN);
        }
        for(Country i : answer){
            System.out.println(i.getName());
        }
        array.add(new Country("United States", 1));
        array.add(new Country("Canada", 2));
        array.add(new Country("Mexico", 3));
        array.add(new Country("France", 1));
        answer.clear();
        System.out.println("Decreasing Area");
        while(!array.isEmpty()){
            max = array.get(0);
            maxN = 0;
            for(j = 0; j<array.size();j++){
                if(b.compare(max, array.get(j)) == -1){
                    max = array.get(j);
                    maxN = j;
                }
            }
            answer.add(max);
            array.remove(maxN);
        }
        for(Country i : answer){
            System.out.println(i.getName());
        }
        array.add(new Country("United States", 1));
        array.add(new Country("Canada", 2));
        array.add(new Country("Mexico", 3));
        array.add(new Country("France", 1));
        answer.clear();
        System.out.println("Increasing Name");
        Collections.sort(array, c);
        for(Country i : array){
            System.out.println(i.getName());
        }
        System.out.println("Decreasing Name");
        Collections.sort(array, d);
        for(Country i : array){
            System.out.println(i.getName());
        }
    }

}
