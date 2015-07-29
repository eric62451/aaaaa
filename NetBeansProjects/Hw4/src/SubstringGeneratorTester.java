import java.util.ArrayList;

public class SubstringGeneratorTester
{
    public static void main(String[] args)
    {
        SubstringGenerator generator = new SubstringGenerator("");
        ArrayList<String> substrings = generator.getSubstrings();
        System.out.println(substrings);
        System.out.println("Expected: []");

        generator = new SubstringGenerator("be");
        substrings = generator.getSubstrings();
        System.out.println(substrings);
        System.out.println("Expected: [b, be, e, ]");
    }
}