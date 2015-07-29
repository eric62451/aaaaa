public class ExceptionTester
{
    public static void main(String[] args)
    {
       //test negative opening balance
       try
       {
          BankAccount account = new BankAccount(-1000);
       }
       catch (IllegalArgumentException  e)
       {
          System.out.println(e.getMessage());
          System.out.println( "Expected: Negative initial balance -1000.0");
       }

       //test negative deposit
          BankAccount account = new BankAccount(1000);
          account.deposit(100);
       try
       {
          account.deposit(-100);
       }
       catch (IllegalArgumentException  e)
       {
          System.out.println(e.getMessage());
          System.out.println( "Expected: Negative deposit -100.0");
       }

       account.withdraw(100);
       //test negative withdrawal
       try
       {
          account.withdraw(-100);
       }
       catch (IllegalArgumentException  e)
       {
          System.out.println(e.getMessage());
          System.out.println( "Expected: Invalid withdrawal -100.0");
       }

       //test overdraft
       try
       {
          account.withdraw(account.getBalance() + 1);
       }
       catch (IllegalArgumentException  e)
       {
          System.out.println(e.getMessage());
          System.out.println( "Expected: Invalid withdrawal 1001.0 ");
       }
    }
}