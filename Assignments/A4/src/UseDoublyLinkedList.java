/*******************************/
/*Students numbers: Ludovic Provost
/*Students full names: 300208450
/*******************************/
public class UseDoublyLinkedList {

	private static DoublyLinkedList<String> getList() {
		DoublyLinkedList<String> l = new DoublyLinkedList<String>();
		l.addLast("ITI1121");
		l.addLast("Hello");
		l.addLast("ITI1121");
		l.addLast("Summer");
		return l;
	}

	private static DoublyLinkedList<String> getList2() {
		DoublyLinkedList<String> l = new DoublyLinkedList<String>();
		l.addLast("Hi");
		l.addLast("AddMe");
		return l;
	}


	private static void testCase1() {
		System.out.println("testCase1: list with multiple elements");
		DoublyLinkedList<String> myList = getList();
		System.out.println("initial list: " + myList);
		DoublyLinkedList<String> someList = getList2();

		myList.addSpecific("ITI1121", someList);
		System.out.println("new myList: " + myList);

		System.out.println("new someList: " + someList);
		System.out.println();
	}



	private static void testCase2() {

		System.out.println("testCase2: list with multiple elements");
		DoublyLinkedList<String> myList = getList();
		System.out.println("initial list: " + myList);
		DoublyLinkedList<String> someList = getList2();

		myList.addSpecific("boo", someList);
		System.out.println("new myList: " + myList);

		System.out.println("new someList: " + someList);
		System.out.println();

		System.out.println();
	}

	private static void testCase3() {
		System.out.println("testCase3:   ");
		//your code here

		System.out.println();
	}
  
  public static void main(String[] args) {

	  System.out.println("-------------------------------------");
	  System.out.println("* Student name: Ludovic Provost     *");
	  System.out.println("* Student number: 300208450         *");
	  System.out.println("-------------------------------------");
	  System.out.println();
    
	testCase1();

	testCase2();
 
  }
}
