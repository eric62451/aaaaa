
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class Paging {

    public static void main(String[] args) {
        System.out.println(mfu(100));

    }

    public static int randomPage(int i) {
        Random r = new Random();
        if (i == -1) { // -1 means the i doesnt have a value, give random number from 0-9
            i = r.nextInt(10);
        } else {
            if (r.nextInt(10) < 7) { // 70% chance to for the new value to be (i,i+1,i-1)
                i = i + r.nextInt(2 + 1) - 1;
                if (i == -1) { //wraps around
                    i = 9;
                }
                if (i == 10) { //wraps around
                    i = 0;
                }
            } else {
                i = i + ((r.nextInt(7) + 2) * (int) Math.pow(-1, r.nextInt(2)));
                if (i > 9) {
                    i = i - 10;
                }
                if (i < 0) {
                    i = i + 10;
                }
            }
        }
        return i;
    }

    public static double fifo(int numReference) {
        int i = -1; // starting number, -1 means the program just started
        int hit = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int j = 0; j < numReference; j++) {
            i = randomPage(i);
            System.out.println("Pages in memory: " + queue.toString());
            System.out.println("Page referenced: " + i);
            if (queue.contains(i)) {
                hit++;
            } else {
                if (queue.size() < 4) {
                    queue.add(i);
                } else {
                    queue.remove();
                    queue.add(i);
                }
            }
        }
        System.out.println("Pages in memory: " + queue.toString());
        return ((double) hit) / numReference;
    }

    public static double randomPick(int numReference) {
        int i = -1; // starting number, -1 means the program just started
        int hit = 0;
        Random r = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int j = 0; j < numReference; j++) {
            i = randomPage(i);
            System.out.println("Pages in memory: " + array.toString());
            System.out.println("Page referenced: " + i);
            if (array.contains(i)) {
                hit++;
            } else {
                if (array.size() < 4) {
                    array.add(i);
                } else {
                    array.remove(r.nextInt(4));
                    array.add(i);
                }
            }
        }
        System.out.println("Pages in memory: " + array.toString());
        return ((double) hit) / numReference;
    }

    public static double mfu(int numReference) {
        int i = -1; // starting number, -1 means the program just started
        int hit = 0;
        int[] frequency = {0,0,0,0};
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int j = 0; j < numReference; j++) {
            i = randomPage(i);
            System.out.println("Pages in memory: " + array.toString());
            System.out.println("Page referenced: " + i);
            if (array.contains(i)) {
                hit++;
                frequency[array.indexOf(i)]++;
            } else {
                if (array.size() < 4) {
                    array.add(i);
                    frequency[array.indexOf(i)]++;
                } else {
                    int max = frequency[0];
                    int maxIndex = 0;
                    for(int k = 1; k<4;k++){
                        if(max<frequency[k]){
                            max = frequency[k];
                            maxIndex = k;
                        }
                    }
                    array.remove(maxIndex);
                    for(int k = maxIndex; k<3;k++){
                        frequency[k] = frequency[k+1];
                    }
                    frequency[3] = 1;
                    array.add(i);
                }
            }
        }
        System.out.println("Pages in memory: " + array.toString());
        return ((double) hit) / numReference;
    }
}
