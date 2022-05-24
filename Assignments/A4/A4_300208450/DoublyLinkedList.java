/*******************************/
/*Students numbers: Ludovic Provost
/*Students full names: 300208450
/*******************************/
public class DoublyLinkedList<E>{

    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public void add(E elem, int index) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            head = new DoublyLinkedList.Node<E>(elem, head.previous, head);
        } else {
            DoublyLinkedList.Node<E> p = head;
            for (int i=0; i<(index-1); i++) {
                p = p.next;
            }
            p.next = new DoublyLinkedList.Node<E>(elem, p.previous, p);
        }
        size++;
    }
	

    public void addLast(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            head = new Node<E>(elem, null, null);
        } else {
			Node<E> p = head;
			while(p.next != null){
				p = p.next;
			}
            p.next = new Node<E>(elem, p, null);
        }
        size++;
    }
	
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        String str = "[";
        Node<E> p = head;
        while (p!=null) {
            if (p != head) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "]";
        return str;
    }
//Do Not change anything above this line
//**************************************************************************
// your code after this line

   public void addSpecific( E beforeMe, DoublyLinkedList<E> someList ) {

        Node someListNode = someList.head;
        Node myListNode = head;
        int count = 0;

        for (int i = 1; i < someList.size; i++) {
            someListNode = someListNode.next;
        }

       try {
           while (myListNode.value != beforeMe) {
               myListNode = myListNode.previous;
               count++;
           }
       } catch (NullPointerException e) {
           System.out.println("specific element not found");
       }

        Node newNode = new Node(someListNode.value, myListNode.previous, myListNode);

        add((E) newNode.value, count);


        if (myListNode.previous != null) {
            myListNode.previous.next = newNode;
            myListNode.previous = newNode;
        } else {
            myListNode.previous = null;
        }

        someListNode.previous.next = null;
    }

    // prev new node
    // node.previous.next = new done
    // new.previous = node.previous done
    // new.next = node done


    //        addLast((E) newNode.value);
//
//        int count = 0;
//
//        while (count > size() || myListNode.value != beforeMe) {
//            myListNode = myListNode.previous;
//            count++;
//        }
//        if (count > size()) {
//            System.out.println("specific element not found");
//            return;
//        }
//        for (int i = 0; i < count; i++) {
//
//        }
}
 