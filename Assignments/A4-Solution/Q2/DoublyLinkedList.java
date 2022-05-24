/*******************************/
/*Students numbers: 
/*Students full names: 
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

	//your code here

		if ( beforeMe == null || someList == null ) {
			return;
		}
		if ((isEmpty()) || (someList.isEmpty())){
			return;
		}
		
		Node<E> p=head;
		Node<E> savePosition=null;
		int numberOccurences = 0;
		Node<E> someListP = someList.head;
		E valueToAdd;
		
		if (beforeMe.equals( head.value )){
			numberOccurences++;
			savePosition = head;
		}

		//parsing until the end
		while (p.next != null){
			p = p.next;
			if (beforeMe.equals( p.value )){
				numberOccurences++;
				savePosition = p;
			}
		}
		if (numberOccurences==0){
			System.out.println("specific element not found");
			return;
		}
		//if we are still here then there is at least one beforeMe in the list
		//we want to get the value to add before the last occurence of beforeMe
		
		while ( someListP.next != null) {
			someListP = someListP.next;
		}

		//we are pointed at the last element of someList, let's add its value  to the list
		if(savePosition == head) {
			head = new Node<E>(someListP.value,null,head);
		} else {
			Node<E> before = savePosition.previous;
			Node<E> after  = savePosition;
			before.next = new Node<E>(someListP.value,savePosition.previous,savePosition);
			after.previous = before.next;
		}
		size++;	
		//removing the last element of someList
		if(someListP.previous != null) {
			someListP.previous.next = null;
			someList.size--;
		} else {
			someList.head = null;
			someList.size = 0;
		}
	

    }
}
 