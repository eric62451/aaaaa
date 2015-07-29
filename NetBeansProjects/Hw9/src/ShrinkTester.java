public class ShrinkTester
{
    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
        System.out.println(list.size() + " / " + list.capacity());
        System.out.println("Expected: 0 / 10");

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println(list.removeLast());
        System.out.println("Expected: C");

        System.out.println(list.size() + " / " + list.capacity());
        System.out.println("Expected: 2 / 5");

        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.addLast("F");
        list.addLast("G");
        list.addLast("H");
        list.addLast("I");
        list.addLast("J");
        list.addLast("K");

        System.out.println(list.removeLast());
        System.out.println("Expected: K");

        System.out.println(list.size() + " / " + list.capacity());
        System.out.println("Expected: 10 / 20");

        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();
        System.out.println(list.size() + " / " + list.capacity());
        System.out.println("Expected: 2 / 5");


        System.out.println(list.removeLast());
        System.out.println("Expected: B");

        System.out.println(list.size() + " / " + list.capacity());
        System.out.println("Expected: 1 / 3");
    }
}
