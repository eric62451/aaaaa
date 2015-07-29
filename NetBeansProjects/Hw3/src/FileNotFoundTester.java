public class FileNotFoundTester
{
    public static void main(String[] args)
    {

        DuplicateNames.main(new String[] { "nosuchfile.txt" });

        System.out.println("Expected: File not found: nosuchfile.txt");
    }
}