/*******************************/
/*Students numbers: 
/*Students full names: 
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
	
	public LinkedItems(){
		top = null;
	}
	
    public boolean isEmpty(){
		return top == null;
	}
	//your code here
}
