
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String content;
        PrintWriter out;
        int group = 3;
        int[] times = new int[group];
        //boolean[] TF = new boolean[group];
        for (int i = 0; i < group; i++) {
            times[i] = 0;
        }
        boolean change = false;
        while (true) {
            content = new Scanner(new File("rooms.ini")).useDelimiter("\\Z").next();
            for (int i = 0; i < group; i++) {
                if (content.contains("Status_"+(i+1)+"=0")) {
                    if (times[i]==8) {
                        content = content.replace("Status_"+(i+1)+"=0", "Status_"+(i+1)+"=" + (int) (1 + (Math.random() * 2)));
                        System.out.println((i+1));
                        times[i] = 0;
                        change = true;
                    } else {
                        times[i]++;
                     //   System.out.println(":"+i);
                    }
                } else {
                    times[i] = 0;
                }
            }
            if (change) {
                out = new PrintWriter("rooms.ini");
                out.print(content);
                out.close();
                change = false;
            }
            Thread.sleep(30000);
        }


    }
}
