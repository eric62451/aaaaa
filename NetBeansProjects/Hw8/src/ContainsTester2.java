public class ContainsTester2
{
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        System.out.println(list.contains("A"));
        System.out.println("Expected: true");

        System.out.println(list.contains("D"));
        System.out.println("Expected: true");

        System.out.println(list.contains("C"));
        System.out.println("Expected: true");

        System.out.println(list.contains("X"));
        System.out.println("Expected: false");
    }
}