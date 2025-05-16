package bank;

public class Account {
    public String name;
    public String password;
    public double balance;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.balance = 0.0;
    }

    public void deposit(double amount) {

        balance += amount;
        System.out.println("Deposited $" + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }
}
