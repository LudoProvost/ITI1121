public class Cashier {

    private ArrayQueue<Customer> queue = new ArrayQueue<>();
    private Customer customer;
    private int totalCustomerWaitTime, customersServed, totalItemsServed;

    public Cashier() {
        totalItemsServed = 0;
        totalCustomerWaitTime = 0;
        customersServed = 0;
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    public int getQueueSize() {
        return queue.size();
    }

    public void serveCustomers(int currentTime) {
        if (customer == null && !queue.isEmpty()) {
            customer = queue.dequeue();
        }

        if (customer == null) {
            return;
        }

        customer.serve();

        if (customer.getNumberOfItems() == 0) {
            totalItemsServed += customer.getNumberOfServedItems();
            totalCustomerWaitTime += (currentTime - customer.getArrivalTime());
            customer = null;
            customersServed++;
        }

    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() {
        return customersServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }
}
