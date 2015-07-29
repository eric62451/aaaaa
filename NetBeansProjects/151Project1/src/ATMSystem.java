
import java.util.Scanner;

/**
 *  Eric Tam
 *  CS151
 *  Section 1
 *  Project 1
 */
public class ATMSystem {
    /**
     * Initialize 5 ATM with pre-initialized cash cards and bank acounts
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Initializing ATM\n");
        System.out.print("Enter Maximum Daily Withdrawal: \n");
        int dailyMax = in.nextInt();
        System.out.print("Enter Maximum amount per transaction: \n");
        int maxPtrans = in.nextInt();
        System.out.print("Enter Minimum cash in ATM to allow transactions: \n");
        int minimumCash = in.nextInt();
        System.out.print("Enter ATM's staring fund: \n");
        int fund = in.nextInt();
        ATM[] atm = new ATM[5];
        atm[0] = new ATM(in, dailyMax, maxPtrans, minimumCash, fund);
        atm[1] = new ATM(in, dailyMax, maxPtrans, minimumCash, fund);
        atm[2] = new ATM(in, dailyMax, maxPtrans, minimumCash, fund);
        atm[3] = new ATM(in, dailyMax, maxPtrans, minimumCash, fund);
        atm[4] = new ATM(in, dailyMax, maxPtrans, minimumCash, fund);
        System.out.print("ATM Initialized\n");
        int choice = 1;
        while(choice != 0){
            System.out.print("Choose which of the 5 ATM to use, to choose enter from 1-5, to exit enter 0: \n");
            choice = in.nextInt();
            if(choice != 0) atm[choice-1].useATM();
        }
    }
}
