
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InventorySystem extends JFrame {

    String title = "";
    String input = "";
    eMerchandiseItem[] merchArray;
    final int max = 4096;
    int itemCount = 0;

    public InventorySystem() {
        merchArray = new eMerchandiseItem[max];
    }

    public InventorySystem(String storeName) {
        title = storeName;
        merchArray = new eMerchandiseItem[max];
    }

    public void run() {

        while (!input.equals("Quit")) {
            String[] choice = new String[]{"List all merchandise", "Add merchandise", "Query merchandise", "Process order", "Quit"};
            input = (String) JOptionPane.showInputDialog(InventorySystem.this, "Please select an option:", title, JOptionPane.PLAIN_MESSAGE, null, choice, "List all merchandise");
            if (input == null) {
                break;
            } else if (input.equals("List all merchandise")) {
                listItems();
            } else if (input.equals("Add merchandise")) {
                addItem();
            } else if (input.equals("Query merchandise")) {
                queryItem();
            } else if (input.equals("Process order")) {
                processOrder();
            }

        }
        System.exit(0);

    }

    private int checkline(String a) {
        if (a.contains(":")) {
            return 2;
        } else if (a.contains(";")) {
            return 1;
        } else {
            return 0;
        }
    }

    public void init() throws FileNotFoundException {
        Scanner in = new Scanner(new File("text.txt"));
        Order[] array = new Order[32];
        int orderCount = 0;
        boolean lastOrder = false;
        eMerchandiseItem two = new eMerchandiseItem();
        while (in.hasNextLine()) {

            String temp = in.nextLine();
            int b = checkline(temp);
            switch (b) {
                case 2:
                    if (lastOrder) {
                        two.setOrders(array);
                        array = new Order[32];
                        orderCount = 0;
                        lastOrder = false;
                    }
                    two = new eMerchandiseItem(temp.substring(0, temp.indexOf(":")), temp.substring(temp.indexOf(":") + 1, temp.indexOf(":", temp.indexOf(":") + 1)), Double.parseDouble(temp.substring(temp.indexOf(":", temp.indexOf(":") + 1) + 1, temp.indexOf(":", temp.indexOf(":", temp.indexOf(":") + 1) + 1 + 1))), Integer.parseInt(temp.substring(temp.indexOf(":", temp.indexOf(":", temp.indexOf(":") + 1) + 1 + 1) + 1, temp.lastIndexOf(":"))), Integer.parseInt(temp.substring(temp.lastIndexOf(":") + 1)), null);
                    merchArray[itemCount] = two;
                    itemCount++;
                    break;
                case 1:
                    array[orderCount] = new Order(temp.substring(0, temp.indexOf(";")), temp.substring(temp.indexOf(";") + 1, temp.indexOf(";", temp.indexOf(";") + 1)), temp.substring(temp.indexOf(";", temp.indexOf(";") + 1) + 1, temp.lastIndexOf(";")), Integer.parseInt(temp.substring(temp.lastIndexOf(";") + 1)));
                    lastOrder = true;
                    orderCount++;
                    break;
                default:
                    break;
            }

        }
        two.setOrders(array);
        array = new Order[32];
        sort();
    }

    private void sort() {
        eMerchandiseItem[] array = new eMerchandiseItem[this.max];
        int last = Integer.MIN_VALUE;
        int temp = 0;
        int count = 0;
        while (count != itemCount) {
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < itemCount; i++) {
                if (merchArray[i].getMerchandiseID().hashCode() < max && merchArray[i].getMerchandiseID().hashCode() > last) {
                    max = merchArray[i].getMerchandiseID().hashCode();
                    temp = i;
                }
            }
            last = max;
            array[count] = merchArray[temp];
            count++;
        }
        merchArray = array;

    }

    public void listItems() {
        String output = "";
        for (int i = 0; i < itemCount; i++) {
            output = output + merchArray[i].toString() + "\n";
        }
        JOptionPane.showMessageDialog(InventorySystem.this, output, title, JOptionPane.PLAIN_MESSAGE);
    }

    private eMerchandiseItem findItem(String merchandiseID) {
        int bot = 0;
        int top = itemCount;
        int num;
        while (bot + 1 < top) {
            num = (bot + top) / 2;
            if (merchArray[num].getMerchandiseID().hashCode() > merchandiseID.hashCode()) {
                top = num;
            } else {
                bot = num;
            }
        }
        if (merchArray[bot].getMerchandiseID().equals(merchandiseID)) {
            return merchArray[bot];
        }
        return null;
    }

    public void setCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getCount() {
        return itemCount;
    }

    public void queryItem() {
        String merchandiseID = JOptionPane.showInputDialog(InventorySystem.this, "Enter merchandise ID (case sensitive):", title, JOptionPane.PLAIN_MESSAGE);
        eMerchandiseItem temp = findItem(merchandiseID);
        if (temp != null) {
            String output = temp.toString() + "\n";
            Order[] orders = temp.getOrders();
            for (int i = 0; i < temp.getTotalOrders(); i++) {
                if(!orders[i].getOrderNumber().equals("-1"))output = output + orders[i].toString() + "\n";
            }
            JOptionPane.showMessageDialog(InventorySystem.this, output, title, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(InventorySystem.this, "No item found", title, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void processOrder() {
        String merchandiseID = JOptionPane.showInputDialog(InventorySystem.this, "Enter merchandise ID (case sensitive):", title, JOptionPane.PLAIN_MESSAGE);
        eMerchandiseItem temp = findItem(merchandiseID);
        if (temp != null) {
            String a = JOptionPane.showInputDialog(InventorySystem.this, "Enter order number (case sensitive):", title, JOptionPane.PLAIN_MESSAGE);
            int c = temp.handleOrder(a);
            if(c == 2) JOptionPane.showMessageDialog(InventorySystem.this, "Insuficcient Inventory", title, JOptionPane.PLAIN_MESSAGE);
            else if(c == 1) JOptionPane.showMessageDialog(InventorySystem.this, "Order not found", title, JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(InventorySystem.this, "No item found", title, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void addItem() {
        String temp = JOptionPane.showInputDialog(InventorySystem.this, "Enter merchandise ID (case sensitive):", title, JOptionPane.PLAIN_MESSAGE);
        if (temp != null) {
            eMerchandiseItem a = findItem(temp);
            if (a != null) {
                temp = JOptionPane.showInputDialog(InventorySystem.this, "Please insert new quantity", title, JOptionPane.PLAIN_MESSAGE);
            } else {
                if (itemCount == max) {
                    JOptionPane.showMessageDialog(InventorySystem.this, "Inventory Full!", title, JOptionPane.PLAIN_MESSAGE);
                } else {
                    a = new eMerchandiseItem();
                    merchArray[itemCount] = a;
                    itemCount++;
                    a.setMerchandiseID(temp);
                    a.setDescription(JOptionPane.showInputDialog(InventorySystem.this, "Merchandise Description:", title, JOptionPane.PLAIN_MESSAGE));
                    a.setPrice(Double.parseDouble(JOptionPane.showInputDialog(InventorySystem.this, "Merchandise price:", title, JOptionPane.PLAIN_MESSAGE)));
                    a.setQuantity(Integer.parseInt(JOptionPane.showInputDialog(InventorySystem.this, "Merchandise quantity:", title, JOptionPane.PLAIN_MESSAGE)));
                    a.setTotalOrders(Integer.parseInt(JOptionPane.showInputDialog(InventorySystem.this, "Total orders:", title, JOptionPane.PLAIN_MESSAGE)));
                    Order[] orders = new Order[32];
                    for (int i = 0; i < a.getTotalOrders(); i++) {
                        temp = JOptionPane.showInputDialog(InventorySystem.this, "Please enter order information:\n(customer;city;order number;order quantity)", title, JOptionPane.PLAIN_MESSAGE);
                        orders[i] = new Order(temp.substring(0, temp.indexOf(";")), temp.substring(temp.indexOf(";") + 1, temp.indexOf(";", temp.indexOf(";") + 1)), temp.substring(temp.indexOf(";", temp.indexOf(";") + 1) + 1, temp.lastIndexOf(";")), Integer.parseInt(temp.substring(temp.lastIndexOf(";") + 1)));
                    }
                    a.setOrders(orders);
                    sort();
                }

            }

        }
    }
}
