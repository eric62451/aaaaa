
import java.util.Map;
import java.util.TreeMap;

/**
 *  Eric Tam
 *  CS151
 *  Section 1
 *  Project 1
 */
public class BankComputer {

    private final int BANKID = 4567;
    private final int CARDCODE = 3451000;
    private double DAILYLIMIT;
    static Bank link;
    private double[] limitKeeper = new double[5000000];
    private String[] passwords = new String[5000000];

    /**
     * Construct a bank computer
     * @param limit daily limit that a card can withdraw
     */
    public BankComputer(double limit) {
        link = new Bank();
        DAILYLIMIT = limit;
        load();
    }

    /**
     * Validates the card
     * @param id ID of the bank
     * @param card  Number of the card
     * @param Password password of the card
     * @return 1 if bank ID is not supported, 2 if card is invalid, 3 if password is wrong and 0 for valid card
     */
    public int validate(int id, int card, String Password) {
        if (id != BANKID) {
            return 1;
        }
        if ((!link.checkAccount(card % 100)) || String.valueOf(card).length() != 7) {
            return 2;
        }
        if (!passwords[card].equals(Password)) {
            return 3;
        }
        return 0;
    }

    /**
     * Withdraw using a card
     * @param card Number of the card
     * @param amount Amount to withdraw
     * @param choice 1= checking account, 2= savings account
     * @return 0 for success withdrawal, 1 for exceed daily limit and 2 for exceed account balance
     */
    public int withdraw(int card, double amount, int choice) {
        if (limitKeeper[card] + amount <= DAILYLIMIT) {
            if (choice == 1 && link.withdraw(card % 100, amount)) {
                limitKeeper[card] = limitKeeper[card] + amount;
                return 0;
            } else if (choice == 2 && link.withdraw((card - CARDCODE) / 100, amount)) {
                limitKeeper[card] = limitKeeper[card] + amount;
            } else {
                return 2;
            }
            return 0;
        }
        return 1;
    }

    private void load() {
        passwords[CARDCODE + 1] = "0005";
        passwords[CARDCODE + 5] = "0025";
        passwords[CARDCODE + 10] = "0050";
        passwords[CARDCODE + 15] = "0075";
        passwords[CARDCODE + 20] = "0100";
        passwords[CARDCODE + 25 + (30 * 100)] = "0275";
        passwords[CARDCODE + 35 + (40 * 100)] = "0375";
        passwords[CARDCODE + 50 + (45 * 100)] = "0475";
    }
}
