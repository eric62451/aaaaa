/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class TaxData
{
   private int year;
   private double topMarginalRate;
   private double topMarginalThreshold;

    public double getTopMarginalThreshold() {
        return topMarginalThreshold;
    }

    public double getTopMarginalRate() {
        return topMarginalRate;
    }

    public int getYear() {
        return year;
    }

    public TaxData(int year, double topMarginalRate, double topMarginalThreshold) {
        this.year = year;
        this.topMarginalRate = topMarginalRate;
        this.topMarginalThreshold = topMarginalThreshold;
    }

}
