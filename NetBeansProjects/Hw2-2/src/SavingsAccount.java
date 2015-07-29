/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class SavingsAccount extends AbstractBankAccount {

    private double interestRate;

    public SavingsAccount(double rate) {
        interestRate = rate;
    }

    @Override
    void endOfMonthProcessing() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}
