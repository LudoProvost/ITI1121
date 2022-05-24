/*******************************/
/*Students numbers: 300208450
/*Students full names: Ludovic Provost
/*******************************/

import java.util.HashMap;
import java.util.Scanner;

public class A3Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String again = "y";

		LinkedItems<Item> linkedItems = new LinkedItems<>();

		while (again.equalsIgnoreCase("Y")) {
			Item item;
			String[] item_list;
		    System.out.print("Enter an item: ");
            item_list = sc.nextLine().split(" ");
		    try {
		    	item = new Item(item_list[0], Integer.parseInt(item_list[1]), Float.parseFloat(item_list[2]));
				linkedItems.add(item);
			} catch (NumberFormatException|ArrayIndexOutOfBoundsException ignored) { }

			System.out.println("Is there another item to enter: (Y/N)");
			again = sc.nextLine();
        }
		System.out.println("The linked list as entered by the user: \n" + linkedItems);
		removeDuplicates(linkedItems);
		printStockValue(linkedItems);
		printMostExpensive(linkedItems);
		printLeastExpensive(linkedItems);
	}

	public static void removeDuplicates(LinkedItems<Item> list) {
		HashMap<String, Item> seenLabels = new HashMap<>();
		int i = 0;
		while (i < list.getSize()) {
			Item item = list.get(i);
			if (!seenLabels.containsKey(item.getLabel())) {
				seenLabels.put(item.getLabel(), item);
				i++;
			} else {
				// Label already seen, update quantity and minimum price, if necessary
				Item firstItem = seenLabels.get(item.getLabel());
				firstItem.setQuantity(firstItem.getQuantity() + item.getQuantity());
				firstItem.setPrice(Math.min(firstItem.getPrice(), item.getPrice()));
				list.remove(i);
			}
		}

		System.out.println("The linked list after eliminating duplicates:\n" + list);
	}

	public static void printStockValue(LinkedItems<Item> list) {
		float stockValue = 0;
		for (int i = 0; i < list.getSize(); i++) {
			Item item = list.get(i);
			stockValue += (item.getPrice() * item.getQuantity());
		}
		System.out.println("The total value of stored items: " + stockValue);
	}

	public static void printMostExpensive(LinkedItems<Item> list) {
		if (list.getSize() == 0) {
			System.out.println("No items were added.");
			return;
		}

		Item mostExpensive = list.get(0);
		for (int i = 1; i < list.getSize(); i++) {
			Item item = list.get(i);
			if (item.getPrice() > mostExpensive.getPrice()) {
				mostExpensive = item;
			}
		}
		System.out.printf("The most expensive item is: %s - %.1f%n", mostExpensive.getLabel(), mostExpensive.getPrice());
	}

	public static void printLeastExpensive(LinkedItems<Item> list) {
		if (list.getSize() == 0) {
			System.out.println("No items were added.");
			return;
		}

		Item leastExpensive = list.get(0);
		for (int i = 1; i < list.getSize(); i++) {
			Item item = list.get(i);
			if (item.getPrice() < leastExpensive.getPrice()) {
				leastExpensive = item;
			}
		}
		System.out.printf("The least expensive item is: %s - %.1f%n", leastExpensive.getLabel(), leastExpensive.getPrice());
	}
}

