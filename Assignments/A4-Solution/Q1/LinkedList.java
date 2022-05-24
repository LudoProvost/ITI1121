/*******************************/
/*Students numbers: 
/*Students full names: 
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
		LinkedList<E> orderedList= new LinkedList<E>();
		
		//your code here

		//first we make a copy of the list because we want it to remain unchanged
		Node<E> current;
		Node<E> orderedCurrent;
		//if it is empty no need to do anything
		if (isEmpty()){
			return orderedList;
		}
		
		orderedList.head = new Node<E>(head.value, null);
		current = head.next;
		orderedCurrent = orderedList.head;
		//we loop over all the emenents of the original list and make a copy into orderedList
		while (current != null) {
			//we make a new node in orderedList for each existing node in original list
			orderedCurrent.next = new Node<E>(current.value, null);	
			orderedList.size++;
			current = current.next;
			orderedCurrent = orderedCurrent.next;
		}		
		
		//now we sort the orderedList
		E saveValue;//used to do a permutation of values
		orderedCurrent = orderedList.head;
		current = orderedCurrent;

		while (orderedCurrent!= null) {
			current = orderedCurrent.next;
			while (current != null) {
				//if two elements are out of order-> re-order them by making a permutation
				if (orderedCurrent.value.compareTo(current.value) >= 0) {
					saveValue = current.value;
					current.value = orderedCurrent.value;
					orderedCurrent.value = saveValue;
				}
				current = current.next;
			}
			orderedCurrent = orderedCurrent.next;
		}		
		
		//return the ordered list
		return orderedList;
	}
	
    public LinkedList<E> isComprisedBetween(E v1, E v2) {
		
		LinkedList<E> newList= new LinkedList<E>();

		//your code here
		if (isEmpty()){
			return newList;
		}
		if ((v1 == null) || (v2 == null)){
			return newList;
		}		
		LinkedList<E> orderedList = orderList();
		System.out.println("orderedList:"+orderedList);
		Node<E> current = orderedList.head;
		Node<E> newListCurrent=newList.head;
		
		while(current != null) {
			//check if the current value is between v1 and v2
			if (v1.compareTo(current.value) <= 0 && v2.compareTo(current.value) >= 0) {
				//it is comprised between them so add it to newList!
				if(newList.isEmpty()){
					//first element of the list
					newList.head = new Node<E>(current.value, null);
					newListCurrent = newList.head;
				}else{
					//add the current value as the next element in the new list
					newListCurrent.next = new Node<E>(current.value, null);
					newListCurrent = newListCurrent.next;
					
				}
				newList.size++;
			}
			current = current.next;
			
		}
		
        return newList;
    }
	
		
}
