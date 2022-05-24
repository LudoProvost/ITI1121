//Ludovic Provost
//300208450

import java.util.Scanner;

public class A1Q3 {
	
	public static void main(String[] args) {
        System.out.println("Please enter the items names separated by commas : "); //asks user to enter item names
        Scanner sc = new Scanner(System.in);
        String[] array1 = sc.nextLine().split(",\s?"); //scan and split user input to strings
        System.out.println("Please enter the items quantities separated by commas : "); //asks user to enter item quantities
        String[] array2 = sc.nextLine().split(",\s?"); //scan and split user input to strings
        int maxIndex = Math.max(array1.length, array2.length); //find which array is longest
        Item[] items = new Item[maxIndex]; //create array of items of length == to length of longest array

        for (int i=0; i < maxIndex; i++) {

            //more quantities than names
            if (i >= array1.length) {
                items[i] = new Item("unknown", Integer.parseInt(array2[i]));
            }

            //more names than quantities
            else if (i >= array2.length) {
                items[i] = new Item(array1[i], 0);
            }

            //same number of names and quantities
            else {
                items[i] = new Item(array1[i], Integer.parseInt(array2[i]));
            }
            items[i].display(); //displays all items in succession
        }
	}
}

// Create a class Item with
// name and quantity as attributes
class Item {
  
    private String name;
    private int quantity;
  
    // Item class constructor
    Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
	}

    // display() method to display Item information
    public void display() {
        System.out.print(this.name + " : " + this.quantity+" - ");
    }  
}