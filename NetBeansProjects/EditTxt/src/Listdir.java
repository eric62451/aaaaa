
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class Listdir {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("./Teleporter/");
        File[] a = f.listFiles();
        int search = 0;
        Random gen = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            array.add(i);
        }
        Collections.shuffle(array);
        String content = "";
        int ran = -1;
        while (search != a.length) {
            ran = array.get(search);
            content = new Scanner(a[ran]).useDelimiter("\\Z").next();
            if (content.contains(" yes")) {
                break;
            } else if (search == a.length - 1) {
                ran = -1;
                break;
            }
            search++;
        }
    }
}
