public class ObjectLinearSearcherTester
{
    public static void main(String[] args)
    {
        String[] names = {};
        ObjectLinearSearcher searcher = new ObjectLinearSearcher(names);
        String target = new String("Alice");
        int index = searcher.search(target);
        printResults(index, target);
        System.out.println("Expected: Alice is in the array at index 3");

        target = new String("Kathleen");
        index = searcher.search(target);
        printResults(index, target);
        System.out.println("Expected: Kathleen is NOT in the array");
    }

    static void printResults(int index, Object target)
    {
       System.out.print(target + " is ");
       if (index >=0)
       {
          System.out.println("in the array at index " + index);
       }
       else
       {
          System.out.println("NOT in the array");
       }
    }
}
