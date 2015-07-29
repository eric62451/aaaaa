
import javax.swing.*;

public class FruitMachine extends JFrame {

    String title = "Fruit Machine";
    String input = "";
    int credit = 0;

    public FruitMachine() {

        while (!input.equals("Quit")) {
            String[] sport = new String[]{"Play", "Deposit", "Quit"};
            input = (String) JOptionPane.showInputDialog(FruitMachine.this, "        Welcome to FRUIT MACHINE\n\n Your Credit: " + credit + "\n Please select your option:", title, JOptionPane.PLAIN_MESSAGE, null, sport, "Play");
            if (input == null) {
                break;
            }
            if (input.equals("Play")) {
                if (credit >= 4) {
                    credit = credit - 4;
                    try {
                        JOptionPane.showMessageDialog(null, "Fuit Machine is generating symbols ... Please wait ..");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                    }
                    String symbols = generate();
                    String message = "";
                    if (symbols.equals("O D D")) {
                        message = "You won 10000 coins";
                        credit = credit + 10000;
                    } else if (symbols.equals("J A V")) {
                        message = "You won 5000 coins";
                        credit = credit + 5000;
                    } else if (symbols.equals("A A A")) {
                        message = "You won 200 coins";
                        credit = credit + 200;
                    } else if (symbols.equals("D D D")) {
                        message = "You won 200 coins";
                        credit = credit + 200;
                    } else if (symbols.equals("J J J")) {
                        message = "You won 200 coins";
                        credit = credit + 200;
                    } else if (symbols.equals("O O O")) {
                        message = "You won 200 coins";
                        credit = credit + 200;
                    } else if (symbols.equals("V V V")) {
                        message = "You won 200 coins";
                        credit = credit + 200;
                    } else if (symbols.contains("O O")) {
                        message = "You won 100 coins";
                        credit = credit + 100;
                    } else if (symbols.contains("J J")) {
                        message = "You won 50 coins";
                        credit = credit + 50;
                    } else {
                        message = "Sorry, you didnt win";
                    }

                    JOptionPane.showMessageDialog(null, "Symbols generated: " + symbols + "\n" + message);


                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, not enough credit. Please make a deposit");
                }
            }
            if (input.equals("Deposit")) {
                handleDeposit();
            }

        }
        handleQuit();
        System.exit(0);

    }

    public static void main(String argv[]) {
        new FruitMachine();
        return;
    }

    private void handleDeposit() {
        String add = (String) JOptionPane.showInputDialog(FruitMachine.this, "Enter a deposit in $:", title, JOptionPane.INFORMATION_MESSAGE);
        credit = credit + (int) (Double.parseDouble(add) * 4);
    }

    private void handleQuit() {
        JOptionPane.showMessageDialog(null, "GoodBye! Your Cash-out value is: $" + String.format("%.2f", credit / 4.0));
    }

    private String generate() {
        String symbols = (int) (Math.random() * 5) + " " + (int) (Math.random() * 5) + " " + (int) (Math.random() * 5);
        symbols = symbols.replace("0", "A");
        symbols = symbols.replace("1", "D");
        symbols = symbols.replace("2", "J");
        symbols = symbols.replace("3", "O");
        symbols = symbols.replace("4", "V");
        return symbols;

    }
}
