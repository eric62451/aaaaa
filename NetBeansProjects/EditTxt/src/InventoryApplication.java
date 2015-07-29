import java.io.FileNotFoundException;

public class InventoryApplication {

    public static void main(String argv[]) throws FileNotFoundException {
        InventorySystem a = new InventorySystem("FootHill Inventory System");
        a.init();
        a.run();
    }

}
