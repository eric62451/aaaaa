/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class neww {

    public int ComputeOddAverage(int n){
        int average = 0;
        int sum = 0;
        int i = 0;
        while(((i*2)+1)<n){
            sum = sum + ((i*2)+1);
            i++;
        }
        average = sum/i;
        return average;
    }

    public static void main(String[] args){
        int x = 1;
        int y = 3;
        int z = 4;
        int option = 2;
        switch(option){
            case 1: System.out.format("%10.3f%n", x);
            case 2: System.out.format("%03d%n", x);
            case 3: System.out.format("%03d%n", y);
            default: System.out.format("%03d%n", z);
            break;

        }
    }

}
