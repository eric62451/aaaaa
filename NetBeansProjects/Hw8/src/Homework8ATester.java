public class Homework8ATester
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        System.out.println(list.toString());
        System.out.println("Expected: [D]");

    }
}