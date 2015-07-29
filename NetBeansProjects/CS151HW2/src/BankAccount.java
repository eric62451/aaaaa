/**
 *  Eric Tam
 *  CS151
 *  Section 1
 *  Project 1
 */

/**
   A bank account has a balance that can be changed by
   deposits and withdrawals.
*/
public class BankAccount implements Comparable
{
   private double balance;

   /**
      Constructs a bank account with a zero balance.
   */
   public BankAccount()
   {
      balance = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public BankAccount(double initialBalance)
   {
      balance = initialBalance;
      if(initialBalance<0) throw new IllegalArgumentException("Negative initial balance "+initialBalance);
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {
      balance = balance + amount;
      if(amount<0) throw new IllegalArgumentException("Negative deposit "+amount);
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {
      if(amount<0 || amount>balance) throw new IllegalArgumentException("Invalid withdrawal "+amount);
      balance = balance - amount;
      
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {
      return balance;
   }

    public int compareTo(Object o) {
        BankAccount a = (BankAccount) o;
        if(balance>a.getBalance()) return 1;
        if(balance<a.getBalance()) return -1;
        return 0;
    }


}
