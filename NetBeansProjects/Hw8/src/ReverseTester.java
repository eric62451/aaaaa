public class ReverseTester
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
                list.addFirst("E");
        list.reverse();
        System.out.println(list.toString());
        System.out.println("Expected: [A, B, C, D]");

        list = new LinkedList();
        list.addFirst("one");
        list.reverse();
        System.out.println(list.toString());
        System.out.println("Expected: [one]");

        list = new LinkedList();
        list.reverse();
        System.out.println(list.contains("x"));
        System.out.println(list.toString());
        System.out.println("Expected: []");
    }

}