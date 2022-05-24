import java.util.Scanner;

public class A3Q2 {
	
	public static void main(String[] args) 
	{
		//your code here
		String moreItems = "Y";
		String[] lineArray;
		String currentLine;
		boolean inputError = false;
		Item currentItem;
		Item mostExpensiveItem, leastExpensiveItem;
		LinkedItems<Item> linkedItems = new LinkedItems<Item>();
		Scanner line = new Scanner(System.in);
		
		//loop over all the items the user wants to enter
		while(moreItems.toLowerCase().equals("y") && (!inputError)){
			//get one item at a time with its quantity and price
			System.out.print("Enter an item: ");
			currentLine = line.nextLine();
			lineArray = currentLine.split(" ");
			
			try{
				//parse the input entered
				currentItem = new Item(lineArray[0],Integer.parseInt(lineArray[1]),Float.parseFloat(lineArray[2]));
				//add the item to our list
				linkedItems.add(currentItem);
				//check if there is more input to get
				System.out.print("Do you have more items? (Y/N) : ");
				moreItems = line.nextLine();				
			}
			catch(NumberFormatException e) {
				inputError = true;
				System.out.println("NumberFormatException "+e.getMessage());
			}
			catch(ArrayIndexOutOfBoundsException e){
				inputError = true;
				System.out.println("IndexOutOfBoundsException "+e.getMessage());
			}
			catch(NullPointerException e){
				inputError = true;
				System.out.println("NullPointerException "+e.getMessage());
			}	
		}
		if (!inputError){
			try{
				//items entered by the user
				System.out.println("The linked list as entered by the user:");
				linkedItems.display();
				//remove the duplicates
				eliminateDuplicates(linkedItems);
				System.out.println("The linked list after eliminating duplicates:");
				linkedItems.display();	
				//total value of all the remaining items
				System.out.print("The total value of stored items: ");
				System.out.println(calculateStoredValue(linkedItems));
				//most expensive item
				System.out.print("The most expensive item is: ");
				mostExpensiveItem = findMostExpensiveItem(linkedItems);
				System.out.println(mostExpensiveItem.displayItemLabelAndPrice());
				//least expensive item
				System.out.print("The least expensive item is: ");
				leastExpensiveItem = findLeastExpensiveItem(linkedItems);
				System.out.println(leastExpensiveItem.displayItemLabelAndPrice());
			}
			catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			catch(IndexOutOfBoundsException e){
				System.out.println(e.getMessage());
			}
			catch(NullPointerException e){
				System.out.println(e.getMessage());
			}		
		}
		else{
			System.out.println("There was an error in the input, please try again.");
		}
	}
	//Method to eliminate the duplicates from the list of items
	public static void eliminateDuplicates(LinkedItems<Item> linkedItems){
		LinkedItems<Item>.Elem<Item> elementProcessed;//points at the elements of the list one at a time
		LinkedItems<Item>.Elem<Item> elementToCheck;//element to check if it is a duplicate of "elementProcessed"
		LinkedItems<Item>.Elem<Item> previousElementToCheck;//points at the previous element, so we can eliminate the next one if it is a duplicate.
		int newQuantity = 0;
		float minPrice = 0;
		
		elementProcessed = linkedItems.getFirstElement();//elementProcessed will start at the beginning of the list
		while(elementProcessed!=null){
			//we need to get the next of the current element being processed
			elementToCheck = elementProcessed.next;
			previousElementToCheck = elementProcessed;//keep it to eliminate elementToCheck if it is a duplicate
			while(elementToCheck!=null){
				//if it is a duplicate we get into the if statement
				if(elementToCheck.value.getLabel().equals(elementProcessed.value.getLabel())) {
					//the quantity is the sum of both quantities
					newQuantity = elementProcessed.value.getQuantity() + elementToCheck.value.getQuantity();
					elementProcessed.value.setQuantity(newQuantity);
					//the price will be the minimum of both prices
					minPrice = Math.min(elementProcessed.value.getPrice(), elementToCheck.value.getPrice());
					elementProcessed.value.setPrice(minPrice);
					// now we need to eliminate elementToCheck
					previousElementToCheck.next = elementToCheck.next;
				}
				else{//not a duplicate, point to the next one
					previousElementToCheck = previousElementToCheck.next;
				}
				//move to the next element to check whether it is a duplicate or not
				elementToCheck = elementToCheck.next;				
			}	
			//move to the next element to check if it has duplicates
			elementProcessed = elementProcessed.next;
		}		
	}
	//method to calculate the total value of all stored items
	public static float calculateStoredValue(LinkedItems<Item> linkedItems){
		float storedValue =0;
		LinkedItems<Item>.Elem<Item> elementProcessed = linkedItems.getFirstElement();
		//loop through all the elements, get their price and multiply it by the quantity 
		//and add it the the total value
		while(elementProcessed!=null){
			storedValue+= elementProcessed.value.getPrice()*elementProcessed.value.getQuantity();
			elementProcessed = elementProcessed.next;
		}
		
		return storedValue;
	
	}
	//find the most expensive item in the list
	public static Item findMostExpensiveItem(LinkedItems<Item> linkedItems){
		float highestPrice = 0;
		LinkedItems<Item>.Elem<Item> elementProcessed = linkedItems.getFirstElement();
		LinkedItems<Item>.Elem<Item> mostExpensiveElement = elementProcessed;
		//loop through all the elements, get their price and compare it to the max so far 
		//and keep the current price if it is higher than the max
		while(elementProcessed!=null){
			if (highestPrice < elementProcessed.value.getPrice()){
				highestPrice = elementProcessed.value.getPrice();
				mostExpensiveElement = elementProcessed;
			}
			elementProcessed = elementProcessed.next;
		}
		
		return mostExpensiveElement.value;
	}
	//find the least expensive item in the list
	public static Item findLeastExpensiveItem(LinkedItems<Item> linkedItems){
		LinkedItems<Item>.Elem<Item> elementProcessed = linkedItems.getFirstElement();
		LinkedItems<Item>.Elem<Item> leastExpensiveElement = elementProcessed;
		float lowestPrice = leastExpensiveElement.value.getPrice();
		//loop through all the elements, get their price and compare it to the min so far 
		//and keep the current price if it is lower than the min		
		while(elementProcessed!=null){
			if (lowestPrice > elementProcessed.value.getPrice()){
				lowestPrice = elementProcessed.value.getPrice();
				leastExpensiveElement = elementProcessed;
			}
			elementProcessed = elementProcessed.next;
		}
		
		return leastExpensiveElement.value;
	}	
}
