
public class Item implements Comparable {

    private String name;
    private String key;
    private String value;

    public Item(String name, String key, String value) {
        this.name = name;
        this.key = key;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public int compareTo(Object o) {
        Item other = (Item) o;
        int compare = name.compareTo(other.name);
        if (compare == 0) {
            compare = key.compareTo(other.key);
        }
        if (compare == 0) {
            value.compareTo(other.value);
        }
        return compare;
    }

    @Override
    public String toString() {
        return this.getName()+this.getKey();
    }

    @Override
    public boolean equals(Object obj) {
        Item other = (Item) obj;
        if(!name.equals(other.name)) return false;
        if(!key.equals(other.key)) return false;
        if(!value.equals(other.value)) return false;
        return true;
    }

}


