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
	
    public Elem<E> getFirstElement(){
		return top;
	}
	
    public E remove(){
		E temp = top.value;
		top = top.next;
		return temp;
	}
	
    public void add( E value){

		Elem<E> element = top;
		//if adding the very first element of the list
		if (element == null){
			top = new Elem<E>(value,null);
		}else{//not the first
			while(element.next !=null){
				element = element.next;
			}
			element.next = new Elem<E>(value,null);
		}



	}
    public void display( ){

		Elem<E> current = top;

		while(current != null){
			System.out.println(current.value);
			current = current.next;
		}		
	}
}