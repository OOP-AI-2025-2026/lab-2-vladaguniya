public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee = 0;

    public BankAccount(String name, double balance) {
        if (balance < 0) throw new IllegalArgumentException();
        this.name = name;
        this.balance = balance;
    }

    public void setTransactionFee(double fee) {
        if (fee < 0) return;
        this.transactionFee = fee;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) return;

        double total = amount + transactionFee;

        if (balance >= total) {
            balance -= total;
        }
    }

    public void transfer(BankAccount receiver, double amount) {
        if (receiver == null || amount <= 0) return;

        double total = amount + transactionFee;

        if (balance < total) return; // недостатньо коштів

        // знімаємо з поточного
        balance -= total;

        // додаємо до отримувача
        receiver.balance += amount;
    }
}
