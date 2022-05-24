import java.util.Random;

public class Customer {

    private int arrivalTime, initialNumberOfItems, numberOfItems;
    private int MAX_NUM_ITEMS = 6;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;

        Random generator;
        generator = new Random();

        initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
        numberOfItems = initialNumberOfItems;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return initialNumberOfItems - numberOfItems;
    }

    public void serve() {
        numberOfItems--;
    }

}
