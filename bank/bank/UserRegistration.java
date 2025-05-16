package bank;

import java.util.Scanner;

public class UserRegistration {
    private Scanner sc;

    public UserRegistration() {
        sc = new Scanner(System.in);
    }

    // Function to register a new user
    public Account registerNewUser() {
        System.out.println("Welcome to the Registration System!");

        System.out.print("Enter your full name: ");
        String name = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        System.out.print("Enter your initial deposit: $");
        double initialDeposit = sc.nextDouble();

        // Create a new account with the provided details
        Account newAccount = new Account(name, password);
        newAccount.deposit(initialDeposit);

        System.out.println("Account created successfully for " + name + " with an initial deposit of $" + initialDeposit);
        return newAccount;
    }
}
