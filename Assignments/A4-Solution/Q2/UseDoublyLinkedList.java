/*******************************/
/*Students numbers: 
/*Students full names: 
/*******************************/
public class UseDoublyLinkedList {
  
  //develop your tests here 
    private static void testCase1() {
        System.out.println("testCase1: list with multiple elements.");
        DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		DoublyLinkedList<String> someList = new DoublyLinkedList<String>();
		myList.addLast("ITI1121");
		myList.addLast("Hello");
		myList.addLast("ITI1121");
		myList.addLast("Summer");	

		someList.addLast("Hi");
		someList.addLast("AddMe");
	

		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the values " + someList);
		System.out.println("The call: myList.addSpecific(\"ITI1121\", someList) will change the lists as follows:");
		myList.addSpecific("ITI1121", someList);
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the value(s) " + someList);
		System.out.println();
    }
	
    private static void testCase2() {
        System.out.println("testCase2: empty list");
        DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		DoublyLinkedList<String> someList = new DoublyLinkedList<String>();

		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the values " + someList);
		System.out.println("The call: myList.addSpecific(\"ITI1121\", someList) will change the lists as follows:");
		myList.addSpecific("ITI1121", someList);
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the value(s) " + someList);
		System.out.println();
    }	
  
    private static void testCase3() {
        System.out.println("testCase3: beforeMe does not exist in myList");
        DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		DoublyLinkedList<String> someList = new DoublyLinkedList<String>();

		myList.addLast("Seasons");
		myList.addLast("Fall");
		myList.addLast("Winter");
		myList.addLast("Spring");
		myList.addLast("Summer");	

		someList.addLast("firstElement");
		someList.addLast("lastElement");
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the values " + someList);
		System.out.println("The call: myList.addSpecific(\"ITI1121\", someList) will change the lists as follows:");
		myList.addSpecific("ITI1121", someList);
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the value(s) " + someList);
		System.out.println();
    }	
	
    private static void testCase4() {
        System.out.println("testCase4: one occurrence of beforeMe in myList");
        DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		DoublyLinkedList<String> someList = new DoublyLinkedList<String>();

		myList.addLast("Seasons");
		myList.addLast("Fall");
		myList.addLast("Winter");
		myList.addLast("Spring");
		myList.addLast("Summer");	

		someList.addLast("someElement");
		someList.addLast("Four");
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the values " + someList);
		System.out.println("The call: myList.addSpecific(\"Seasons\", someList) will change the lists as follows:");
		myList.addSpecific("Seasons", someList);
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the value(s) " + someList);
		System.out.println();
    }		
    private static void testCase5() {
        System.out.println("testCase5: multiple occurences of beforeMe in myList");
        DoublyLinkedList<String> myList = new DoublyLinkedList<String>();
		DoublyLinkedList<String> someList = new DoublyLinkedList<String>();

		myList.addLast("it works");
		myList.addLast("it works");
		myList.addLast("it works");
		myList.addLast("it works");
		myList.addLast("it works");	

		someList.addLast("some element");
		someList.addLast("some other element");
		someList.addLast("that's good");
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the values " + someList);
		System.out.println("The call: myList.addSpecific(\"it works\", someList) will change the lists as follows:");
		myList.addSpecific("it works", someList);
		System.out.println("myList has the values " + myList);
		System.out.println("and the list someList has the value(s) " + someList);
		System.out.println();
    }	
  public static void main(String[] args) {

	 System.out.println("-------------------------------------");
	 System.out.println("* Student name:                     *");
	 System.out.println("* Student number:                   *");
	 System.out.println("-------------------------------------");
	 System.out.println("* Student name:                     *");
	 System.out.println("* Student number:                   *");
	 System.out.println("-------------------------------------");
	 System.out.println();
    
	// call your tests here
	testCase1();
	System.out.println("---------------------------------------------------------------");
	testCase2();
	System.out.println("---------------------------------------------------------------");
	testCase3();
	System.out.println("---------------------------------------------------------------");
	testCase4();
	System.out.println("---------------------------------------------------------------");
	testCase5();
  }
}
