import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class A
{
    private String source;
    public A(){
    }
    }
    public void load(String sourceName) {
        source = sourceName;
        try {
            Scanner in = new Scanner(new File(source));
            System.out.println(in.nextLine());

        }
        catch (IOException ex) {

        }
    }
}