public class NotEnoughMoneyException extends IllegalStateException {
    private double balance;
    private double amount;

    public NotEnoughMoneyException(double balance, double amount) {
        super("You have not enought money to withdraw " + amount + "$");
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }

    public double getMissingAmount() {
        return amount - balance;
    }
}
