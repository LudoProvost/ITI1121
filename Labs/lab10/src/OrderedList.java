public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

        private Comparable value;
        private Node previous;
        private Node next;

        private Node(Comparable value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private final Node dummy = new Node(null, null, null);

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
    }

    // Calculates the size of the list

    public int size() {
        int counter = 0;
        Node x = head;

        while (x != null && x != dummy) {
            x = x.next;
            counter++;
        }
        return counter;
    }


    public Object get(int pos) {
        Node x = head;

        if (head == null || pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < pos; i++) {
            x = x.next;
            if (x == dummy) {
                throw new IndexOutOfBoundsException();
            }
        }
        return x.value;
    }

    // Adding an element while preserving the order

    public boolean add(Comparable o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }

        if (head == null) {
            head = new Node(o, dummy, dummy);
            dummy.previous = head;
            dummy.next = head;
            return true;
        }

        Node x = head;

        while (o.compareTo(x.value) > 0) {
            if (x.next == dummy) {
                x.next = new Node(o, x, dummy);
                return true;
            }
            x = x.next;
        }

        if (o.compareTo(x.value) == 0) {
            return false;
        }

        Node node = new Node(o, x.previous, x);
        x.previous.next = node;
        x.previous = node;

        if (x == head) {
            head = node;
        }

        return true;

    }

    //Removes one item from the position pos.

    public void remove(int pos) {
        if (pos < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (pos == 0) {
            head = head.next;
            head.previous = dummy;
            dummy.next = head;
            return;
        }

        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        Node x = head;

        for (int i = 0; i < pos; i++) {
            x = x.next;
            if (x == dummy) {
                throw new IndexOutOfBoundsException();
            }
        }
        // prev -- x (rem) -- x.next;

        x.previous.next = x.next;
        x.next.previous = x.previous;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge(OrderedList other) {
        Node x = other.head;
        while (x != other.dummy) {
            this.add(x.value);
            x = x.next;
        }
    }

    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        list.remove(1);

    }
}