/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public abstract class AbstractBankAccount {

    private double balance;

    /**
    Deposits money into the bank account.
    @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
    Withdraws money from the bank account.
    @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    /**
    Gets the current balance of the bank account.
    @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
    Transfers money from the bank account to another account
    @param amount the amount to transfer
    @param other the other account
     */
    public void transfer(double amount, AbstractBankAccount other) {
        withdraw(amount);
        other.deposit(amount);
    }

    abstract void endOfMonthProcessing();
}
