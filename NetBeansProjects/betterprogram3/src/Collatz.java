
public class Collatz
{
    final static int limit=1000001;
    private static int[] table=new int[limit];

    public static int cycleLength(int n)
    {
        return collatz((long)n);
    }

    private static int collatz(long n)
    {
    int result;
    if (n == 1)
        return 1;
    else if (n < limit && table[(int)n]!=0)
        return table[(int)n];
    else if (n % 2 == 0)
        result=1+collatz(n/2);
     else
        result=1+collatz(3*n+1);
    if (n < limit && table[(int)n]==0)
        table[(int)n] = result;
    return result;
    }

    public static int maximumCycle(int i, int j)
    {
        int max=Math.max(i,j);
        int min=Math.min(i,j);
        int result=cycleLength(min);
        for(int k=min+1;k<max;k++)
            result=Math.max(result, cycleLength(k));
        return result;
    }
}
