import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueTester
{
    public static void main(String[] args)
    {
        Queue queue = new Queue();

        queue.add("A");
        queue.add("B");
        queue.add("C");


        System.out.println(queue.size());
        System.out.println("Expected: 3");

        System.out.println(queue);
        System.out.println("Expected: [A, B, C]");

        System.out.println(queue.remove());
        System.out.println("Expected: A");

        queue.remove();

        System.out.println(queue.remove());
        System.out.println("Expected: C");

        try
        {
           queue.remove();
        }
        catch(NoSuchElementException e)
        {
           System.out.println(e.getMessage());
           System.out.println("Expected: Queue is Empty");
        }
    }
}