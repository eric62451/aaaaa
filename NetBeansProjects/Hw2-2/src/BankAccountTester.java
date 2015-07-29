import java.util.ArrayList;

public class BankAccountTester
{

   public static void main(String[] args)
   {
      ArrayList<AbstractBankAccount> bank = new ArrayList<AbstractBankAccount>();
      bank.add(new SavingsAccount(1.5));
      bank.add(new CheckingAccount(2000));

      for (AbstractBankAccount account : bank)
      {
         account.deposit(1000);
         account.deposit(75.50);
         account.withdraw(20);
         account.withdraw(10);
      }

      AbstractBankAccount account = bank.get(0);

      System.out.printf("%.2f%n", account.getBalance());
      System.out.printf("Expected: 1045.50");
      account.endOfMonthProcessing();
      System.out.printf("%n%.2f%n", account.getBalance());
      System.out.printf("Expected: 1061.18");

      account = bank.get(1);

      System.out.printf("%n%.2f%n", account.getBalance());
      System.out.printf("Expected: 3045.50");
      account.endOfMonthProcessing();
      System.out.printf("%n%.2f%n", account.getBalance());
      System.out.printf("Expected: 3043.50%n");
   }
}