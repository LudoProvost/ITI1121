	/*******************************/
/*Students numbers: 
/*Students full names: 
/*******************************/
public class UseList {

    private static LinkedList<Integer> getList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.addLast(8);
        l.addLast(2);
        l.addLast(1);
		l.addLast(6);
		l.addLast(9);
		l.addLast(3);
		l.addLast(7);
		l.addLast(4);
		l.addLast(5);
        return l;
    }
	
    private static void testCase1() {
        System.out.println("testCase1: list with multiple elements.");
        LinkedList<Integer> l = getList();
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(5,7));

        System.out.println("initial list unchanged: " + l);
        System.out.println();
    }



    private static void testCase2() {

		System.out.println("testCase2: empty list.");
		//your code here
		LinkedList<Integer> l = new LinkedList<Integer>();
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(5,7));

        System.out.println("initial list unchanged: " + l);	

        System.out.println();
    }

    private static void testCase3_1() {
		System.out.println("testCase3_1: list with one element - isComprisedBetween(5,7).");
		//your code here
        LinkedList<Integer> l = new LinkedList<Integer>();		
		l.addFirst(100);

        System.out.println();
		
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(5,7));

        System.out.println("initial list unchanged: " + l);

        System.out.println();		
    }
	
    private static void testCase3_2() {
		System.out.println("testCase3_2: list with one element - isComprisedBetween(1,200)");
		//your code here
        LinkedList<Integer> l = new LinkedList<Integer>();		
		l.addFirst(100);

        System.out.println();
		
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(0,200));

        System.out.println("initial list unchanged: " + l);

        System.out.println();		
    }	
		//your code here
    private static void testCase4() {
		System.out.println("testCase3: v1 and v2 don't exist in the list");	

        LinkedList<Integer> l = new LinkedList<Integer>();		
		l.addLast(4);
		l.addLast(7);
		l.addLast(1);
		l.addLast(2);
		l.addLast(9);
		l.addLast(3);
        System.out.println();
		
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(6,8));

        System.out.println("initial list unchanged: " + l);

        System.out.println();		
    }	
    private static void testCase5() {
		System.out.println("testCase3: already ordered list  ");

        LinkedList<Integer> l = new LinkedList<Integer>();		
		l.addLast(1);
		l.addLast(2);
		l.addLast(3);
		l.addLast(4);
		l.addLast(5);
		l.addLast(6);
		l.addLast(7);
		l.addLast(8);
		l.addLast(9);
        System.out.println();
		
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(7,9));

        System.out.println("initial list unchanged: " + l);

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
		

        testCase1();

		testCase2();
		
		//call your other tests here
		
		testCase3_1();

		testCase3_2();		

		testCase4();

		testCase5();


			

    }
}
