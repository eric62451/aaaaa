
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eric Tam
 */
public class BankAccountTester {

    public static ArrayList sort(ArrayList<BankAccount> o) {
        ArrayList<BankAccount> answer = new ArrayList<BankAccount>();
        BankAccount max;
        int maxN;
        int j;
        while (o.size() != 0) {
            max = o.get(0);
            maxN = 0;
            for (j = 0; j < o.size(); j++) {
                if (max.compareTo(o.get(j)) == -1) {
                    max = o.get(j);
                    maxN = j;
                }
            }
            answer.add(max);
            o.remove(maxN);
        }
        return answer;
    }

            public static void main(String[] args) {
        ArrayList<BankAccount> a = new ArrayList<BankAccount>();
        a.add(new BankAccount(5));
        a.add(new BankAccount(20));
        a.add(new BankAccount(3));
        a.add(new BankAccount(50));
        a.add(new BankAccount(70.5));
        a.add(new BankAccount(60));
        a.add(new BankAccount(0));
        a.add(new BankAccount(0));
        ArrayList<BankAccount> b = BankAccountTester.sort(a);
        System.out.println(b.get(0).getBalance());
        System.out.println("Expected: 70.5");
        System.out.println(b.get(1).getBalance());
        System.out.println("Expected: 60");
        System.out.println(b.get(2).getBalance());
        System.out.println("Expected: 50");
        System.out.println(b.get(3).getBalance());
        System.out.println("Expected: 20");
        System.out.println(b.get(4).getBalance());
        System.out.println("Expected: 5");
        System.out.println(b.get(5).getBalance());
        System.out.println("Expected: 3");
        System.out.println(b.get(6).getBalance());
        System.out.println("Expected: 0");
        System.out.println(b.get(7).getBalance());
        System.out.println("Expected: 0");
    }
}
