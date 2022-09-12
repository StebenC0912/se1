package Week1_TranKhacLinh_2001040121;
public class IntBag extends IntSet {
    private int[] elements;
    private int size;

    /**
     * @effects: Make this contain 0
     */

    public IntBag() {
        elements = new int[10];
        size = 0;
    }

    /**
     * @modifies this
     * @effects: Add x to this
     */

    public void insert(int x) {
        if (size == elements.length) {
            int[] newElements = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[size] = x;
        size++;
    }

    /**
     * @modifies this
     * @effects: Remove x from this
     */

    public void remove(int x) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == x) {
                elements[i] = elements[size - 1];
                size--;
                return;
            }
        }
    }

    /**
     * @effects: Return the number of elements in this
     */

    public int size() {
        return size;
    }

    /**
     * @effects: Return true if x is in this
     */

    public boolean isIn(int x) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * @effects: Return the number of elements in this
     */

    public int cardinality() {
        return size;
    }

    /**
     * @effects: Return true if this and s have the same elements
     */

    public boolean equals(IntSet s) {
        if (size != s.cardinality()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!s.isIn(elements[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @effects: Return a new IntBag that contains the elements of this and s
     */

    public IntSet union(IntSet s) {
        IntBag result = new IntBag();
        for (int i = 0; i < size; i++) {
            result.insert(elements[i]);
        }
        return result;
    }


    
}
