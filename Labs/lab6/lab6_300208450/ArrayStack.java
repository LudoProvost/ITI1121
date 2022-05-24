
public class ArrayStack<E> implements Stack<E> {


    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private int capacity;    // Designates the capacity of the Array

    @SuppressWarnings( "unchecked" )

    // Constructor

    public ArrayStack( int capacity ) {
        elems = (E[]) new Object[ capacity ];
        top = 0;
        this.capacity = capacity;
    }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() {

        // pre-conditions: ! isEmpty()
        if (!isEmpty()) {
            return elems[ top-1 ];
        }
        return null;
    }

    // Removes and returns the top element of this stack

    public E pop() {

        if (!isEmpty()) {

            E saved = elems[--top];
            elems[top] = null;
            return saved;
        }
        return null;
    }

    // Puts the element onto the top of this stack.

    public void push( E element ) {

        if ( top < elems.length ) {
            elems[ top++ ] = element;
        }
    }


    // Gets current capacity of the array (for testing purpose)
    public int getCapacity() {
        return elems.length;
    }

    public void clear() {
        elems = (E[]) new Object[capacity];
        top = 0;
    }
}
