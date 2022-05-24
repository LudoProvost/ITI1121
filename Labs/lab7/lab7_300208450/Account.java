public class Account {

    private double balance;

    public Account() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(balance);
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new NotEnoughMoneyException(balance, amount);
        }
        balance -= amount;
        System.out.println(balance);
    }

    public double getBalance() {
        return balance;
    }
}
