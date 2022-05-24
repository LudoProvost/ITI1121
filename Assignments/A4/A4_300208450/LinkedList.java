/*******************************/
/*Students numbers: Ludovic Provost
/*Students full names: 300208450
/*******************************/
public class LinkedList<E extends Comparable<E>>{

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size=0;

    public boolean isEmpty() {
        return head == null;
		//or
		//return size == 0;
    }
	
    public void addFirst(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        head = new Node<E>(elem, head);
        size++;
    }

    public void addLast(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            head = new Node<E>(elem, null);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(elem, null);
        }
        size++;
    }
	
	//adding at a specific index
    public void add(E elem, int index) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            head = new Node<E>(elem, head);
        } else {
            Node<E> p = head;
            for (int i=0; i<(index-1); i++) {
                p = p.next;
            }
            p.next = new Node<E>(elem, p.next);
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        E saved = head.value;
        head = head.next;
        size--;
        return saved;
    }

    public E removeLast() {
        if (head == null) {
            throw new NullPointerException();
        }
        E saved;
        if (head.next == null) {
            saved = head.value;
            head = null;
        } else {
            Node<E> p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            saved = p.next.value;
            p.next = null;
        }
        size--;
        return saved;
    }

    public int size() {
        return size;
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
//*****************************************************	
//Do Not change anything above this line
//Add your code below this line
//*****************************************************

	//orderList() returns a list ordered in ascending order(smallest to greatest)
	//called by isComprisedBetween(E v1, E v2)
	
    public LinkedList<E> orderList() {
		LinkedList<E> orderedList= new LinkedList<>();

        E prev = null;
        E largest = null;
		for (int i = 0; i < size(); i++) {
		    E smallest = (i == 0) ? head.value : largest;

            Node<E> node = head;
		    for (int j = 0; j < size(); j++) {
		        if (i == 0 && (largest == null || largest.compareTo(node.value) < 0)) {
		            largest = node.value;
                }
		        
		        if (node.value.compareTo(smallest) < 0 && (prev == null || node.value.compareTo(prev) > 0)) {
		            smallest = node.value;
                }
		        node = node.next;
            }
            orderedList.add(smallest, i);
            prev = smallest;
        }
		return orderedList;
	}
	
    public LinkedList<E> isComprisedBetween(E v1, E v2) {
		
		LinkedList<E> newList= new LinkedList<E>();

		newList = orderList();
		LinkedList<E> comprisedList = new LinkedList<E>();
        Node<E> node = orderList().head;

		for (int i = 0; i < size(); i++) {
            if (node.value == v1) {

                int count = 0;
                while (node.value != v2) {
                    comprisedList.add(node.value, count);
                    node = node.next;
                    count++;
                }
                comprisedList.add(node.value, count);
                break;
            }
            node = node.next;
        }

        return comprisedList;
    }
	
		
}
