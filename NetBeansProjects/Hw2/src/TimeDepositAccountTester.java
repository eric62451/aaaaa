/**
 * Tester for TimeDepoisitAccount
 * @author Kathleen O'Brien
 *
 */
public class TimeDepositAccountTester
{

   public static void main(String[] args)
   {

      TimeDepositAccount account = new TimeDepositAccount(3, 2);
      account.deposit(1000);
      System.out.println(account.getBalance());
      System.out.println("Expected: 1000");
      account.addInterest();
      account.addInterest();
      System.out.println(account.getBalance());
      System.out.println("Expected: 1060.9");
      account.withdraw(40);
      System.out.println(account.getBalance());
      System.out.println("Expected: 1020.9000000000001");


      account = new TimeDepositAccount(1, 12);
      account.deposit(100);
      System.out.println(account.getBalance());
      System.out.println("Expected: 100");
      account.addInterest();
      account.addInterest();
      System.out.println(account.getBalance());
      System.out.println("Expected: 102.01");
      account.withdraw(40);
      System.out.println(account.getBalance());
      System.out.println("Expected: 42.010000000000005");
   }
}