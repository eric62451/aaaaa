/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class A {

    public static void main(String[] args) {
        int N = 5;
        int avg[] = new int[N];
        for (int j = 0; j < 100; j++) {
            int a[] = Simulator(N);
            for (int i = 0; i < a.length; i++) {
                avg[i] = avg[i] + a[i];
            }
        }
        for (int i = 0; i < avg.length; i++) {
            System.out.println(avg[i]/(double)100);
        }
    }

    static int[] Simulator(int number) {
        int backTimes[] = new int[number];
        Node stations[] = new Node[number];
        for (int i = 0; i < number; i++) {
            stations[i] = new Node();
        }
        int T = 0;
        int finished = 0;
        int count = 0;
        while (backTimes[number - 1] == 0) {
            for (int i = 0; i < number; i++) {
                if (stations[i].time == T) {
                    count++;
                }
            }
            if (count == 1) {
                backTimes[finished] = T;
                finished++;
            } else if (count > 1) {
                for (int i = 0; i < number; i++) {
                    if (stations[i].time == T) {
                        int time = T + 1;
                        for (int j = 0; j <= stations[i].number; j++) {
                            time = time + (int) (((int)(Math.random() + 0.5)) * Math.pow(2.0, j));
                        }
                        stations[i].time = time;
                        stations[i].number++;
                    }
                }
            }
            count = 0;
            T++;
        }
        return backTimes;
    }

    static class Node {

        int number = 0;
        int time = 0;
    }
}
