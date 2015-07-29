/*
 * Eric Tam
 * CS146
 * Program 3
 */


public class Prog3 {
    static int[] answers = new int[1000000];

    public static int cycleLength(int n){
        int count = 1;
        answers[0] = 1;
        if(10000000<=n){
            long temp;
            temp = n;
            while(temp>10000000){
                if(temp%2==0){
                    temp = temp/2;
                    count++;
                } else{
                    temp = (temp*3)+1;
                    count++;
                }
            }
            n = (int) temp;
        }
        if(n<=answers.length && answers[n-1]!=0){
            return answers[n-1];
        } else if(n%2 == 0) count = count + cycleLength(n/2);
        else count = count + cycleLength((n*3)+1);
        if(n<answers.length)answers[n-1] = count;
        return count;
}
    public static int maximumCycle(int i, int j){
        int max = 0;
        if(i>j){
            max = j;
            j = i;
            i = max;
            max = 0;
        }
        while(i<=j){
                int temp = cycleLength(i);
                if(temp>max)
                max = temp;
                i++;
        }
        return max;
    }
}