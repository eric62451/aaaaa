/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chris
 */
public class Hw5b {
    static int []c;
    static int counter;
    public static int swappedPairs(int a[]){
        c= a;
        helper();
        return counter;
    }
    private static void helper()
    {
        while(isInOrder() == false)
        {
            int s = misIndex();

            swap(s,s+1);
            System.out.println(c[s+1]+","+c[s]);
            counter++;
        }
    }
    private static boolean isInOrder()
    {
        for (int i=0; i< c.length-1; i++)
        {
            if(c[i] > c[i+1]&& i != c.length-1)
            {

                return false;
            }
        }
        return true;
    }
    private static int misIndex()
    {
        int position=0;
        for (int i=0; i< c.length-1; i++)
        {
            if(c[i] > c[i+1]&& i != c.length-1)
            {

                position = i;
            }

        }
        return position;
    }
    private static void swap(int a, int b)
     {

        int temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
