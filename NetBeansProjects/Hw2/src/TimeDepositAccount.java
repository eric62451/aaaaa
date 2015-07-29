/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class TimeDepositAccount extends SavingsAccount {

    private int yearRemaining;
    final private int EARLY_WITHDRAWAL_FEE = 20;

    public TimeDepositAccount(double rate, int years) {
        super(rate);
        yearRemaining = years;
    }

    @Override
    public void addInterest() {
        super.addInterest();
        yearRemaining--;
    }

    @Override
    public void withdraw(double amount) {
        if (yearRemaining > 0) {
            super.withdraw(amount + EARLY_WITHDRAWAL_FEE);
        } else {
            super.withdraw(amount);
        }
    }
}
