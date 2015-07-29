
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** An implementation of the AddressBook interface that uses
 *   an array list to store the data.
 */
public class ArrayListAddressBook implements AddressBook {

    private ArrayList<Item> items = new ArrayList<Item>();
    private String source;
    private boolean modified;

    public void load(String sourceName) {
        source = sourceName;
        try {
            Scanner in = new Scanner(new File(source));
            items = new ArrayList<Item>();
            while (in.hasNextLine()) {
                items.add(new Item(in.nextLine(), in.nextLine(), in.nextLine()));

            }
        } catch (IOException ex) {
            ex.printStackTrace();
            source = null;
            items = new ArrayList<Item>();
        }
    }

    public String get(String name, String key) {
        for (Item it : items) {
            if (name.equals(it.getName()) && key.equals(it.getKey())) {
                return it.getValue();

            }
        }
        return null;
    }

    public String put(String name, String key, String value) {
        modified = true;
        for (Item it : items) {
            if (name.equals(it.getName()) && key.equals(it.getKey())) {
                String oldValue = it.getValue();
                it.setValue(value);
                return oldValue;
            }
        }
        items.add(new Item(name, key, value));
        return null;
    }

    public void save() {
        if (!modified) {
            return;

        }
        try {
            PrintWriter out = new PrintWriter(source);
            for (Item it : items) {
                out.println(it.getName());
                out.println(it.getKey());
                out.println(it.getValue());
            }
            out.close();
            modified = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String remove(String name, String key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Item getFirst() {
        return Collections.min(items);
    }

    /**
     * Returns True if the param is contained in the items array
     * @param Item that want to check if it is contained in items array
     * @return true if it is contained, false if not
     */
    public boolean contains(Item anItem) {
        for (Item it : items) {
            if (it.equals(anItem)) {
                return true;

            }
        }
        return false;
    }

    public Item getNext(Item previous) {
        Item[] itemArray = new Item[items.size()];
        items.toArray(itemArray);
        Comparable result = Util.smallestAfter(itemArray, previous);
        return (Item) result;
    }

    public ArrayList getItems() {
        return items;
    }
}
