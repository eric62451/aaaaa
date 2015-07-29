
import java.util.NoSuchElementException;

public class StackTester
{
    public static void main(String[] args)
    {
        Stack stack = new Stack();

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");

        System.out.println(stack.size());
        System.out.println("Expected: 10");

        stack.push("K");
        System.out.println(stack.toString());
        System.out.println("Expected: [A, B, C, D, E, F, G, H, I, J, K]");

        System.out.println(stack.pop());
        System.out.println("Expected: K");

        while (stack.size() > 1)
        {
           stack.pop();
        }

        System.out.println(stack.pop());
        System.out.println("Expected: A");

        try
        {
           stack.pop();
        }

        catch (NoSuchElementException e)
        {
           System.out.println(e.getMessage());
           System.out.println("Expected: Stack is Empty");
        }

        System.out.println(stack.empty());
        System.out.println("Expected: true");
    }
}