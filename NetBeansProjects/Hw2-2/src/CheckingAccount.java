/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eric Tam
 */
public class CheckingAccount extends AbstractBankAccount {

    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;

    public CheckingAccount(double amount) {
        super.deposit(amount);
        transactionCount = 0;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactionCount++;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        transactionCount++;
    }

    @Override
    void endOfMonthProcessing() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fees = TRANSACTION_FEE* (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }
}
