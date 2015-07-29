public class SentenceTester
{
    public static void main(String[] args)
    {
        Sentence sentence = new Sentence("A");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: A");

        sentence = new Sentence ("Radar");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: radaR");

        System.out.println(sentence.isPalindrome());
        System.out.println("Expected: true");

    }
}