import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class DuplicateNames {

    public static void main(String[] args) {
        try {
            String location = "";
            if (args.length == 0) {
                System.out.println("Usage: java DupicateNames URL");
                System.exit(1);
            } else {
                location = args[0];
            }
            URL nameURL = new URL(location);
            InputStream nameIn = nameURL.openStream();
            Scanner in = new Scanner(nameIn);
            ArrayList<String> boys = new ArrayList<String>();
            ArrayList<String> girls = new ArrayList<String>();
            while (in.hasNext()) {
                in.next();
                boys.add(in.next());
                in.next();
                in.next();
                girls.add(in.next());
                in.next();
                in.next();
            }
            for (String s : boys) {
                // System.out.println(s);
                for (String g : girls) {
                    if(s.equalsIgnoreCase(g)) System.out.println(s);
                }
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println("URL not found");
        }

    }
}
