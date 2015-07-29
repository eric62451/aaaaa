
import java.util.Map;
import java.util.TreeMap;

/**
 *  Eric Tam
 *  CS151
 *  Section 1
 *  Project 1
 */
public class Bank {

    private Map<Integer, BankAccount> accounts = new TreeMap<Integer, BankAccount>();

    public Bank() {
        load();
    }

    /**
     * Adds a bank account with initial balance
     * @param accountNumber account number of the bank account
     * @param amount initial amount of the new bank account
     * @return false if account number is already taken or initial amount is negative, else true
     */
    public boolean AddAccount(int accountNumber, double amount) {
        if (accounts.get(accountNumber) == null && amount >= 0) {
            accounts.put(accountNumber, new BankAccount(amount));
            return true;
        }
        return false;
    }
    /**
     * Check if account exists
     * @param accountNumber the account number of the bank account you want to check
     * @return true if the bank account exist, else false
     */
    public boolean checkAccount(int accountNumber){
        if(accounts.get(accountNumber)==null) return false;
        return true;
    }

    /**
     * Withdraws an amount from the specified account
     * @param accountNumber number of the account to withdraw from
     * @param amount amount to withdraw from the account
     * @return false if account doesn't exist, negative amount to withdraw or amount exceeds account's balance
     */
    public boolean withdraw(int accountNumber, double amount) {
        BankAccount temp = accounts.get(accountNumber);
        if (temp != null && amount >= 0) {
            if (temp.getBalance() >= amount) {
                temp.withdraw(amount);
                return true;
            }
        }
        return false;
    }

    /**
     * initialize some accounts
     */
    private void load(){
        AddAccount(1, 0);
        AddAccount(5, 980);
        AddAccount(10, 10000);
        AddAccount(15, 5000);
        AddAccount(20, 50);
        AddAccount(25, 74);
        AddAccount(30, 2000);
        AddAccount(35, 40);
        AddAccount(40, 300);
        AddAccount(45, 99.99);
        AddAccount(50, 1);

    }
}
