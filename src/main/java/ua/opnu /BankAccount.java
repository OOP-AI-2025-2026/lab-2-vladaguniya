package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }
    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0 || balance < amount + transactionFee) return false;
        balance -= amount + transactionFee;
        return true;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0 || balance < amount + transactionFee) return false;
        balance -= amount + transactionFee;
        receiver.balance += amount;
        return true;
    }
}
