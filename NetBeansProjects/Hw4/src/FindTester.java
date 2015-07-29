public class FindTester
{
    public static void main(String[] args)
    {
       Sentence sentence = new Sentence("but");
       System.out.println(sentence.find(new String("butter")));
       System.out.println("Expected: false");

       sentence = new Sentence("butterfly");
       System.out.println(sentence.find(new String("butter")));
       System.out.println("Expected: true");

       sentence = new Sentence("beware");
       System.out.println(sentence.find(new String("car")));
       System.out.println("Expected: false");
    }
}