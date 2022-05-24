import java.util.StringJoiner;

/*******************************/
/*Students numbers: 300208450
/*Students full names: Ludovic Provost
/*******************************/

public class LinkedItems<E> {

    class Elem<T> {
        public T value;
        public Elem<T> next;

        Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> top;
    private Elem<E> last;
    public int size = 0;

    public LinkedItems(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void add(E item) {
        if (isEmpty()) {
            top = new Elem<>(item, null);
            last = top;
        }
        else {
            last.next = new Elem<>(item, null);
            last = last.next;
        }
        size++;
    }

    public E remove(int pos) {
        if (pos >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E saved;
        Elem<E> r;
        if (pos ==0) {
            r = top;
            top = top.next;
        } else {
            Elem<E> p;
            p = top;
            for (int i = 0; i < (pos - 1); i++) {
                p = p.next;
            }
            r = p.next;
            p.next = r.next;
        }
        size--;
        return r.value;
    }

    public E get(int index) {

        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Elem<E> item = top;
        for (int i = 0; i < index; i++) {
            item = item.next;
        }
        return item.value;
    }

    public String toString() {
        StringJoiner str = new StringJoiner("\n");
        Elem<E> item = top;
        while (item != null) {
            str.add(item.value.toString());
            item = item.next;
        }
        return str.toString();
    }

    public int getSize() {
        return size;
    }
}
