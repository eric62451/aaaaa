import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * An implementation of the AddressBook interface that uses an array list to
 * store the data.
 */
public class C {

    public static void main(String[] args) {
        int NumCases = 0;
        Scanner in = null;
        try {
            in = new Scanner(new File("C-large-1.in"));
            NumCases = in.nextInt();
            in.nextLine();

        } catch (IOException ex) {
        }
        for (int i = 0; i < NumCases; i++) {
            long A = in.nextLong();
            long B = in.nextLong();
            int count = 0;
            for (A = A; A <= B; A++) {
                if(isPalindrome(Long.toString(A))){
                    long C = (long) Math.sqrt(A);
                    if(C*C == A && isPalindrome(Long.toString(C))) count++;
                }
            }
            System.out.println("Case #"+(i+1)+": "+count);
        }
    }

    public static boolean isPalindrome(String text) {

        Stack<String> back = new Stack<String>();
        Queue<String> front = new LinkedList<String>();
        for (int i = 0; i < text.length(); i++) {
            if ("0123456789".contains(text.subSequence(i, i + 1))) {
                back.add(text.substring(i, i + 1));
                front.add(text.substring(i, i + 1));
            }
        }
        while (!(back.size() == 0)) {
            if (!(back.pop().equalsIgnoreCase(front.remove()))) {
                return false;
            }
        }
        return true;
    }
}
