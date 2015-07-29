import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * An implementation of the AddressBook interface that uses an array list to
 * store the data.
 */
public class Main {

    public static void main(String[] args) {
        String[] lines = new String[10];
        int NumCases = 0;
        Scanner in = null;
        try {
            in = new Scanner(new File("A-large.in"));
            NumCases = in.nextInt();
            in.nextLine();

        } catch (IOException ex) {
        }
        for(int i = 0; i<NumCases; i++){
            boolean answer = false;
            lines[0]= in.nextLine();
            lines[1]= in.nextLine();
            lines[2]= in.nextLine();
            lines[3]= in.nextLine();
            lines[4]= lines[0].substring(0, 1) + lines[1].substring(0, 1) + lines[2].substring(0, 1) + lines[3].substring(0, 1);
            lines[5]= lines[0].substring(1, 2) + lines[1].substring(1, 2) + lines[2].substring(1, 2) + lines[3].substring(1, 2);
            lines[6]= lines[0].substring(2, 3) + lines[1].substring(2, 3) + lines[2].substring(2, 3) + lines[3].substring(2, 3);
            lines[7]= lines[0].substring(3, 4) + lines[1].substring(3, 4) + lines[2].substring(3, 4) + lines[3].substring(3, 4);
            lines[8]= lines[0].substring(0, 1) + lines[1].substring(1, 2) + lines[2].substring(2, 3) + lines[3].substring(3, 4);
            lines[9]= lines[3].substring(0, 1) + lines[2].substring(1, 2) + lines[1].substring(2, 3) + lines[0].substring(3, 4);
            if(in.hasNextLine())in.nextLine();
            for(int j = 0; j<10; j++){
                if(!(lines[j].contains(".") || lines[j].contains("X"))) {
                    System.out.println("Case #"+(i+1)+": O won");
                    answer = true;
                    break;
                }
                if(!(lines[j].contains(".") || lines[j].contains("O"))) {
                    System.out.println("Case #"+(i+1)+": X won");
                    answer = true;
                    break;
                }
            }
            if(!answer){
                for(int j = 0; j<4; j++){
                    if(lines[j].contains(".")) {
                        System.out.println("Case #"+(i+1)+": Game has not completed");
                        answer = true;
                        break;
                    }
                }
                if(!answer) System.out.println("Case #"+(i+1)+": Draw");
            }
        }
    }


}
