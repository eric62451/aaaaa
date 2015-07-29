
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

    public static void main(String args[]) throws FileNotFoundException {
        //FileInputStream fis = new FileInputStream("smallNames.txt");
        String inputStreamString = new Scanner(System.in,"UTF-8").useDelimiter("\\A").next();
        System.out.println(inputStreamString);
    }
}