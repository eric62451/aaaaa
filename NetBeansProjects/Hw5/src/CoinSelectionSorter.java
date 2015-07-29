
public class CoinSelectionSorter {

    private Coin[] coin;

    /**
    Constructs a selection sorter.
    @param anArray the array to sort
     */
    public CoinSelectionSorter(Coin[] anArray) {
        coin = anArray;
    }

    /**
    Sorts the array managed by this selection sorter.
     */
    public void sort() {

        for (int i = 0; i < coin.length - 1; i++) {
            int minPos = minimumPosition(i);
            swap(minPos, i);
        }
    }

    /**
    Finds the smallest element in a tail range of the array.
    @param from the first position in a to compare
    @return the position of the smallest element in the
    range a[from] . . . a[a.length - 1]
     */
    private int minimumPosition(int from) {
        int minPos = from;
        for (int i = from + 1; i < coin.length; i++) {
            if (coin[i].getValue() < coin[minPos].getValue()) {
                minPos = i;
            }
        }
        return minPos;
    }

    /**
    Swaps two entries of the array.
    @param i the first position to swap
    @param j the second position to swap
     */
    private void swap(int i, int j) {
        Coin temp = coin[i];
        coin[i] = coin[j];
        coin[j] = temp;
    }
}
