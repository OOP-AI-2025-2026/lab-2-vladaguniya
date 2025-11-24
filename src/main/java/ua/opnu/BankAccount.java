public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee = 0;

    public BankAccount(String name, double balance) {
        if (name == null || name.isEmpty() || balance < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.balance = balance;
    }

    public void setTransactionFee(double fee) {
        if (fee < 0) return;
        this.transactionFee = fee;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) return false;

        double total = amount + transactionFee;
        if (balance >= total) {
            balance -= total;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) {
            return false;
        }

        double total = amount + transactionFee;

        if (balance >= total) {
            balance -= total;
            receiver.balance += amount;
            return true;
        }

        return false;
    }
}
