public class SentenceTester2
{
    public static void main(String[] args)
    {
        Sentence sentence;


        sentence = new Sentence("A");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: A");

        sentence = new Sentence("Be");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: eB");

        sentence = new Sentence ("Cat");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: taC");

        sentence = new Sentence ("Beware of dog!");
        sentence.reverse();
        System.out.println(sentence.getText());
        System.out.println("Expected: !god fo eraweB");
    }

}
