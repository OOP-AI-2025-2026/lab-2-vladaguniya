public class BankAccount {
    private String name;
    private double balance;
    private double transactionFee = 0;

    public BankAccount(String name, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не може бути від'ємним");
        }
        this.name = name;
        this.balance = balance;
    }

    public void setTransactionFee(double fee) {
        if (fee < 0) {
            throw new IllegalArgumentException("Комісія не може бути від'ємною");
        }
        this.transactionFee = fee;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сума депозиту повинна бути > 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сума повинна бути > 0");

        double total = amount + transactionFee;

        if (total > balance) return;

        balance -= total;
    }

    public void transfer(BankAccount receiver, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Сума повинна бути > 0");

        double total = amount + transactionFee;

        if (total > balance) return;

        this.balance -= total;   // знімаємо у відправника
        receiver.balance += amount;  // додаємо отримувачу
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
