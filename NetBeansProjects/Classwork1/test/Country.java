/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
/**
   A country with a name and area.
*/
public class Country implements Comparable
{
   private String name;
   private double area;
   private int population;

   /**
      Constructs a country.
      @param aName the name of the country
      @param anArea the area of the country
    * @param pop the population
   */
   public Country(String aName, double anArea, int pop)
   {
      name = aName;
      area = anArea;
      population = pop;
   }

   /**
      Gets the name of the country.
      @return the name
   */
   public String getName()
   {
      return name;
   }

   /**
      Gets the area of the country.
      @return the area
   */
   public double getArea()
   {
      return area;
   }

      /**
      Gets the population of the country.
      @return the population
   */
   public int getPopulation()
   {
      return population;
   }

   /**
      Compares two countries by area.
      @param other the other country
      @return a negative number if this country has a smaller
      area than otherCountry, 0 if the areas are the same,
      a positive number otherwise
   */
   public int compareTo(Object otherObject)
   {
      Country other = (Country) otherObject;
      if (area < other.area) return -1;
      if (area > other.area) return 1;
      return 0;
   }
}