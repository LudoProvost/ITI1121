/*******************************/
/*Students numbers: Ludovic Provost
/*Students full names: 300208450
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
        System.out.println("testCase1: list with multiple elements");
        LinkedList<Integer> l = getList();
        System.out.println("initial list: " + l);

        System.out.println("new list: "+l.isComprisedBetween(5,7));

        System.out.println("initial list unchanged: " + l);
        System.out.println();
    }



    private static void testCase2() {

		System.out.println("testCase2:   ");
		//your code here

        System.out.println();
    }

    private static void testCase3() {
		System.out.println("testCase3:   ");
		//your code here

        System.out.println();
    }
	
	//your code here
	
	
	
    public static void main(String[] args) {
		
		System.out.println("-------------------------------------");
		System.out.println("* Student name: Ludovic Provost     *");
		System.out.println("* Student number: 300208450         *");
		System.out.println("-------------------------------------");
		System.out.println();

        testCase1();
			
		testCase2();
		
		testCase3();

			

    }
}
