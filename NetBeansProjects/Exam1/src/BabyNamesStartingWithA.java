
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BabyNamesStartingWithA {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java BabyNamesStartingWithA filename");
        } else {
            try {
                int totalFrequency = 0;
                int frequency;
                String name;
                String filename = args[0];
                Scanner in = new Scanner(new File(filename), "UTF-8");
                while (in.hasNext()) {
                    in.next();
                    in.next();
                    in.next();
                    in.next();
                    name = in.next();
                    frequency = in.nextInt();
                    if(name.substring(0, 1).equalsIgnoreCase("a")){
                        System.out.println(name);
                        totalFrequency = totalFrequency + frequency;
                    }
                    in.next();
                }
                System.out.println(totalFrequency);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found: " + args[0]);
            }
        }
    }
}
