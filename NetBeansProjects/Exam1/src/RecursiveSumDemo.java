import java.util.ArrayList;

public class RecursiveSumDemo
{
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(8);
        list.add(16);
        list.add(32);
        list.add(64);

        System.out.println(sum(list));
        System.out.println("Expected: 126");
    }

    public static int sum(ArrayList<Integer> list)
    {
       if (list.size()==1) return list.get(0); // Base case
       ArrayList<Integer> smallerList = new ArrayList<Integer>();
       /* copy all but the first element to smallerList
          Add the first element to the sum of the smallerList
      */
       int i = 0;
       for(int s : list){
           if(i>0){
               smallerList.add(s);
           }
           i++;
           }
       return list.get(0) + sum(smallerList);
        }//... your code goes here
}