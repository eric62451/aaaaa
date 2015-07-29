
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException, IOException {
        String content = new Scanner(new File("Accounts.txt")).useDelimiter("\\Z").next();
        String in = "   aasdad  415-777-8844 asdadsa  (415)888-8888";
        //System.out.println(in.matches("(.*[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9].*)"));
        //File dir = new File("nameoffolder");
        //dir.mkdir();
        content = content.replace("|", ":");

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        System.out.println(a.contains(1));



        PrintWriter out = new PrintWriter("output.txt");
        out.print(content);
        out.close();



    }
}
