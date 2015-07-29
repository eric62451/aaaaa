
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Dict {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(args[0]));
        in.useDelimiter("[^A-Za-z0-9_]+");
        Map<String, Set<Integer>> index = new TreeMap<String, Set<Integer>>();
        /*
        while (in.hasNext()) {
        System.out.println(in.next());
        }*/
        int lineNumber = 0;
        while (in.hasNextLine()) {
            lineNumber++;
            String line = in.nextLine();
            Scanner in2 = new Scanner(line);
            in2.useDelimiter("[^A-Za-z0-9_]+");
            while (in2.hasNext()) {
                String word = in2.next();
                if (!(index.get(word) == null)) {
                    index.get(word).add(lineNumber);
                } else {
                    index.put(word, new TreeSet<Integer>());
                    index.get(word).add(lineNumber);
                }
            }
        }
        for(String s : index.keySet()){
            System.out.print(s+" ");
            for(int a : index.get(s)){
                System.out.print(a+ " ");
            }
            System.out.println("");
        }
    }
}
