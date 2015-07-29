
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework3A {

    public static void main(String[] args) throws FileNotFoundException //...
    {

        //process the command line arguments
        String filename = "";

        if (args.length == 0) {
            System.out.println("Usage: java Homework3A filename");
            System.exit(1);
        } else {
            filename = args[0];
        }

        Scanner in = new Scanner(new File(filename), "UTF-8");
        in.nextLine();
        String line;
        int gdp = 0;
        int population = 0;
        ArrayList<Integer> gdpCapita = new ArrayList<Integer>();
        ArrayList<String> countries = new ArrayList<String>();
        while (in.hasNextLine()) {
            line = in.nextLine();
            countries.add(line.substring(0, line.indexOf("$") - 1));
            gdp = gdp + clean(line.substring(line.indexOf("$")+1, line.indexOf(" ", line.indexOf("$")+1)));
            population = population + clean(line.substring(line.indexOf(" ", line.indexOf(" ", line.indexOf("$")+1)+1)+1,line.indexOf(" ",line.indexOf(" ", line.indexOf(" ", line.indexOf("$")+1)+1)+1)));
            gdpCapita.add(clean(line.substring(line.indexOf(" ", line.indexOf("$")+1)+1,line.indexOf(" ", line.indexOf(" ", line.indexOf("$")+1)+1))));


        }
        for (String s : countries) {
            System.out.println(s);
        }
        System.out.printf("$%,d%n", gdp);
        System.out.printf("%,d%n", population);
        int min = gdpCapita.get(0);
        for(int i:gdpCapita){
            if(i<min) min = i;
        }
        System.out.printf("$%,d%n", min);


    }

    private static int clean(String s) {
        String cleaned = s.replace("$", "");
        cleaned = cleaned.replace(",", "");
        //extra protection
        try {
            return Integer.parseInt(cleaned);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
