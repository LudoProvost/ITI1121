import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        count = 0;
        elems = new Pair[INITIAL_CAPACITY];
    }

    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        if (count == elems.length) {
            increaseCapacity();
        }

        // Similarly to the array-based implementation
        // of a stack, I am adding elements at the end
        elems[count] = new Pair(key, value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] temp = new Pair[elems.length + INCREMENT];
        for (int i = 0; i < count; i++) {
            temp[i] = elems[i];
        }
        elems = temp;
    }

    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < count; i++) {
            if (key.equals(elems[i].getKey())) {
                return true;
            }
        }
        return false;
    }

    public Integer get(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        for (int i = count - 1; i >= 0; i--) {
            if (key.equals(elems[i].getKey())) {
                return elems[i].getValue();
            }
        }
        throw new NoSuchElementException();
    }

    public void replace(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        for (int i = count - 1; i >= 0; i--) {
            if (key.equals(elems[i].getKey())) {
                elems[i].setValue(value);
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public Integer remove(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int index = -1;
        Integer value = 0;
        for (int i = count - 1; i >= 0; i--) {
            if (key.equals(elems[i].getKey())) {
                index = i;
                value = elems[i].getValue();
                break;
            }
        }
        if (index == -1) {
            throw new NoSuchElementException();
        }

        for (int i = index; i < count - 1; i++) {
            elems[i] = elems[i+1];
        }

        elems[--count] = null;
        return value;
    }

    public String toString() {
        String res;
        res = "Dictionary: {elems = [";
        for (int i = count-1; i >= 0 ; i--) {
            res += elems[i];
            if(i > 0) {
                res += ", ";
            }
        }
        return res +"]}";
    }

}
