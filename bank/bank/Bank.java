package bank;
import java.util.Scanner;

public class Bank {
    private Account account;
    private Scanner sc;
    private UserRegistration userRegistration;

    public Bank() {
        // Create a default account
        account = new Account("user", "1234");
        sc = new Scanner(System.in);
        userRegistration = new UserRegistration();
    }

    public void start() {
        System.out.println("Welcome to ATM!");
        System.out.println("1. Login\n2. Register as a new user");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        if (choice == 1) {
            if (login()) {
                menu();
            } else {
                System.out.println("Login failed. Exiting...");
            }
        } else if (choice == 2) {
            account = userRegistration.registerNewUser();  // Register a new user
            menu();
        } else {
            System.out.println("Invalid option. Exiting...");
        }
    }
    private boolean login() {
        System.out.print("Enter username: ");
        String inputName = sc.nextLine();
        System.out.print("Enter password: ");
        String inputPass = sc.nextLine();

        return inputName.equals(account.name) && inputPass.equals(account.password);
    }

    private void menu() {
        int choice;
        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> account.checkBalance();
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    account.deposit(amt);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                }
                case 4 -> System.out.println("Thank you for using our ATM.");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
