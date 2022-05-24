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

    @Override
    public void put(String key, Integer value) {
//        for (int i = 0; i < count; i++) {
//            if (key.equals(elems[i].getKey())) {
//                elems[i].setValue(value);
//                return;
//            }
//        }
        if (count >= elems.length) {
            increaseCapacity();
        }
        elems[count++] = new Pair(key, value);
    }

    private void increaseCapacity() {
        Pair[] temp = new Pair[elems.length + INCREMENT];
        for (int i = 0; i < count; i++) {
            temp[i] = elems[i];
        }
        elems = temp;
    }

    @Override
    public boolean contains(String key) {
        for (int i = 0; i < count; i++) {
            if (key.equals(elems[i].getKey())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        for (int i = count - 1; i >= 0; i--) {
            if (key.equals(elems[i].getKey())) {
                return elems[i].getValue();
            }
        }
        return null;
    }

    @Override
    public void replace(String key, Integer value) {
        for (int i = count - 1; i >= 0; i--) {
            if (key.equals(elems[i].getKey())) {
                elems[i].setValue(value);
                return;
            }
        }
    }

    @Override
    public Integer remove(String key) {
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
            return null;
        }

        for (int i = index; i < count - 1; i++) {
            elems[i] = elems[i+1];
        }

        elems[--count] = null;
        return value;
    }

    @Override
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
