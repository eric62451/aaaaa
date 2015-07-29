/**
 * Eric Tam
 * 007989423
 * CS166
 * 2/5/2015
 */

import java.util.Scanner;

public class SubstitutionCipherDecodeHelper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Ciphertext: ");
        String ciphertext = in.nextLine();
        char letter = 65;
        System.out.println("Letter Frequency: ");
        for (int i = 0; i < 26; i++) {
            int count = 0;
            for (int j = 0; j < ciphertext.length(); j++) {
                if (ciphertext.charAt(j) == letter) {
                    count++;
                }
            }
            System.out.println(letter + ": " + count);
            letter++;
        }
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            plaintext = plaintext + "-";
        }
        System.out.println("Choose a letter to replace: ");
        char change = in.nextLine().charAt(0);
        System.out.println("Input replacement: ");
        char replace = in.nextLine().charAt(0);
        String guesses = "Guesses:\n" + change + "->" + replace;
        for (int j = 0; j < ciphertext.length(); j++) {
            if (ciphertext.charAt(j) == change) {
                plaintext = plaintext.substring(0, j) + replace + plaintext.substring(j + 1);
            }
        }
        System.out.println(guesses);
        System.out.println("Current progress:\n" + plaintext);
        boolean loop = true;
        String input;
        while (loop) {
            System.out.println("Input \"replace\" to replace another letter, \"fix\" to fix previous replacements and \"quit\" to exit: ");
            input = in.nextLine();
            if (input.equalsIgnoreCase("replace")) {
                System.out.println("Choose a letter to replace: ");
                change = in.nextLine().charAt(0);
                System.out.println("Input replacement: ");
                replace = in.nextLine().charAt(0);
                guesses = guesses+"\n"+change+"->"+replace;
                for (int j = 0; j < ciphertext.length(); j++) {
                    if (ciphertext.charAt(j) == change) {
                        plaintext = plaintext.substring(0, j) + replace + plaintext.substring(j + 1);
                    }
                }
                System.out.println(guesses);
                System.out.println("Current progress:\n" + plaintext);
            } else if (input.equalsIgnoreCase("fix")) {
                System.out.println("Choose letter to fix, example F->C input \"C\": ");
                change = in.nextLine().charAt(0);
                System.out.println("Input replacement: ");
                replace = in.nextLine().charAt(0);
                guesses = guesses.replace("->"+change, "->"+replace);
                for (int j = 0; j < ciphertext.length(); j++) {
                    if (ciphertext.charAt(j) == guesses.charAt(guesses.indexOf("->"+replace)-1)) {
                        plaintext = plaintext.substring(0, j) + replace + plaintext.substring(j + 1);
                    }
                }
                System.out.println(guesses);
                System.out.println("Current progress:\n" + plaintext);
            } else if (input.equalsIgnoreCase("quit")) {
                loop = false;
            }
        }

    }
}
