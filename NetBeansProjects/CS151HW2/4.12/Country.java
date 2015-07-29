
import java.util.Comparator;

/**
A country with a name and area.
 */
public class Country implements Comparable<Country> {

    /**
    Constructs a country.
    @param aName the name of the country
    @param anArea the area of the country
     */
    public Country(String aName, double anArea) {
        name = aName;
        area = anArea;
    }

    /**
    Gets the name of the country.
    @return the name
     */
    public String getName() {
        return name;
    }

    /**
    Gets the area of the country.
    @return the area
     */
    public double getArea() {
        return area;
    }

    /**
    Compares two countries by area.
    @param other the other country
    @return a negative number if this country has a smaller
    area than otherCountry, 0 if the areas are the same,
    a positive number otherwise
     */
    public int compareTo(Country other) {
        if (area < other.area) {
            return -1;
        }
        if (area > other.area) {
            return 1;
        }
        return 0;
    }
    private String name;
    private double area;

    public static Comparator<Country> createComparatorByName(final boolean increasing) {
        if (increasing) {
            return new Comparator<Country>() {

                public int compare(Country one, Country two) {
                    return one.getName().compareTo(two.getName());
                }
            };
        }
        return new Comparator<Country>(){

            public int compare(Country one, Country two) {
                return two.getName().compareTo(one.getName());
            }

        };

    }

    public static Comparator<Country> createComparatorByArea(final boolean increasing) {
        if (increasing) {
            return new Comparator<Country>() {
                public int compare(Country one, Country two) {
                    return one.compareTo(two);
                }

            };
        }
        return new Comparator<Country>(){

            public int compare(Country one, Country two) {
                return two.compareTo(one);
            }

        };
    }
}
