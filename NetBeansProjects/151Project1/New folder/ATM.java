import java.util.Calendar;
import java.util.Scanner;

/**
 *  Eric Tam
 *  CS151
 *  Section 1
 *  Project 1
 */
public class ATM {

    private int bankID;
    private int card;
    private String pass;
    private double MAXCASH;
    private double MAXTRAN;
    private double availableCash;
    private double minimumCash;
    Scanner in;
    private static BankComputer connect;

    private boolean validation(int bankID, int Card, String pass) {
        int valid = connect.validate(bankID, Card, pass);
        if (valid == 1) {
            System.out.print("Sorry, your card is not supported by this ATM\n");
            System.out.print("Please take back your card\n");
            return false;
        }
        if (valid == 2) {
            System.out.print("Your Card is invalid\n");
            System.out.print("Please take back your card\n");
            return false;
        }
        int count = 1;
        while (valid == 3) {
            if (count > 2) {
                System.out.print("Invalid Password, your card will not be returned, please contact the bank\n");
                return false;
            }
            System.out.print("Invalid Password, please enter your password again (4 digits): \n");
            pass = in.next();
            valid = connect.validate(bankID, Card, pass);
            count++;
        }
        return true;
    }

    private void initialize() {
        boolean valid = false;
        //Calendar cal = Calendar.getInstance();
        while (valid == false) {
            System.out.print("Please enter your Bank ID: \n");
            bankID = in.nextInt();
            System.out.print("Please enter your Card Number: \n");
            card = in.nextInt();
            System.out.print("Please enter your Card's Expiry Date (MMYY): \n");
            int expiry = in.nextInt();
            if (13 <= (expiry % 100)) {
                if (13 == (expiry % 100) && 9 > (expiry / 100)) {
                    System.out.print("Card Expired\n");
                    System.out.print("Please take back your card\n");
                } else {
                    System.out.print("Initializing Authorization\n");
                    System.out.print("Please enter your Card's Password (4 digit): \n");
                    pass = in.next();
                    System.out.print("Validating...\n");
                    valid = validation(bankID, card, pass);
                }
            } else {
                System.out.print("Card Expired\n");
                System.out.print("Please take back your card\n");
            }
        }
    }

    private void withdraw() {
        int choice = 1;
        if (card / 1000 != 3451) {
            System.out.print("1: Checking Account\n" + "2: Savings Account\n" + "Please choose which account you will like to withdraw from (1 or 2): \n");
            choice = in.nextInt();
        }
        System.out.print("Please enter the amount you will like to withdraw in bills of 20: \n");
        int amount = in.nextInt();
        while (amount % 20 != 0 || amount > MAXTRAN) {
            if (amount > MAXTRAN) {
                System.out.print("Sorry, your amount exeeds the limit per transaction, please enter another amount or enter \"0\" to exit: \n");
            } else {
                System.out.print("Sorry, the ATM can only dispense in bill of 20, please enter another amount or enter \"0\" to exit: \n");
            }
            amount = in.nextInt();
        }
        if (amount == 0) {
            System.out.print("Please take back your card\n");
            return;
        }
        boolean success = false;
        while (success == false) {
            int result = connect.withdraw(card, amount, choice);
            while (result != 0) {
                while (result == 1) {
                    System.out.print("Sorry, exceeds your daily limit, please enter another amount or enter \"0\" to exit: \n");
                    amount = in.nextInt();
                    while (amount % 20 != 0 || amount > MAXTRAN) {
                        if (amount > MAXTRAN) {
                            System.out.print("Sorry, your amount exeeds the limit per transaction, please enter another amount or enter \"0\" to exit: \n");
                        } else {
                            System.out.print("Sorry, the ATM can only dispense in bill of 20, please enter another amount or enter \"0\" to exit: \n");
                        }
                        amount = in.nextInt();
                    }
                    if (amount == 0) {
                        System.out.print("Please take back your card\n");
                        return;
                    }
                    result = connect.withdraw(card, amount, choice);
                }
                while (result == 2) {
                    System.out.print("Sorry, exceeds your account balance, please enter another amount or enter \"0\" to exit: \n");
                    amount = in.nextInt();
                    while (amount % 20 != 0 || amount > MAXTRAN) {
                        if (amount > MAXTRAN) {
                            System.out.print("Sorry, your amount exeeds the limit per transaction, please enter another amount or enter \"0\" to exit: \n");
                        } else {
                            System.out.print("Sorry, the ATM can only dispense in bill of 20, please enter another amount or enter \"0\" to exit: \n");
                        }
                        amount = in.nextInt();
                    }
                    if (amount == 0) {
                        System.out.print("Please take back your card\n");
                        return;
                    }
                    result = connect.withdraw(card, amount, choice);
                }
            }
            System.out.print("Withdrawal successful, please take your money\n");
            availableCash = availableCash - amount;
            success = true;
            System.out.print("Please take back your card\n");
        }

    }
    /**
     * Construct an ATM
     * @param n Scanner for the ATM to communicate with the user
     * @param dailyMax  Maximum amount that a card can withdraw in a day
     * @param maxPtrans Maximum amount withdrawable in one transaction
     * @param minCash   Minimum cash available in the ATM to be able to operate
     * @param fund
     */
    public ATM(Scanner n, double dailyMax, double maxPtrans, double minCash, double fund) {
        in = n;
        connect = new BankComputer(dailyMax);
        MAXTRAN = maxPtrans;
        availableCash = fund;
        minimumCash = minCash;
    }
    /**
     * Starts dialogue with user
     */
    public void useATM() {
        if (availableCash < minimumCash) {
            System.out.print("ATM out of cash\n");
            return;
        }
        initialize();
        withdraw();
    }
}
