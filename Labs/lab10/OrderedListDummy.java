//public class OrderedListDummy implements OrderedStructure {
//
//    // Implementation of the doubly linked nodes (nested-class)
//
//    private static class Node {
//
//        private Comparable value;
//        private Node previous;
//        private Node next;
//
//        private Node(Comparable value, Node previous, Node next) {
//            this.value = value;
//            this.previous = previous;
//            this.next = next;
//        }
//    }
//
//    private int[] elems; // stores the elements of this queue
//    private int front, rear, size;
//    private Node head;
//
//    // Representation of the empty list.
//
//    public OrderedListDummy() {
//        front = 0;
//        rear = -1;
//        size = 0;
//    }
//
//    // Calculates the size of the list
//
//    public int size() {
//        return (MAX_LIST_SIZE - front + rear + 1) % MAX_LIST_SIZE;
//    }
//
//
//    public Object get(int pos) {
//        if (elems[pos] == 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        try {
//            return elems[pos];
//        } catch (ArrayIndexOutOfBoundsException e) {
//            throw new IndexOutOfBoundsException();
//        }
//    }
//
//    // Adding an element while preserving the order
//
//    public boolean add(Comparable o) {
//        // Remove line below and add your implementation.
//        throw new UnsupportedOperationException("not implemented yet!");
//    }
//
//    //Removes one item from the position pos.
//
//    public void remove(int pos) {
//        if (elems[pos] == 0) {
//            throw new IndexOutOfBoundsException();
//        }
//        try {
//            elems[pos] = 0;
//        } catch (ArrayIndexOutOfBoundsException e) {
//            throw new IndexOutOfBoundsException();
//        }
//    }
//
//    // Knowing that both lists store their elements in increasing
//    // order, both lists can be traversed simultaneously.
//
//    public void merge(OrderedList other) {
//        // Remove line below and add your implementation.
//        throw new UnsupportedOperationException("not implemented yet!");
//    }
//
//}