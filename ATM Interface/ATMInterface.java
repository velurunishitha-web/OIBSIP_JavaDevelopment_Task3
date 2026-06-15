import java.util.Scanner;

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ATM Login Details
        int userId = 12345;
        int userPin = 1234;

        // Balance
        double balance = 10000;

        // Transaction History
        String transactionHistory = "";

        System.out.println("===== ATM INTERFACE =====");

        // Login
        System.out.print("Enter User ID: ");
        int enteredId = sc.nextInt();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        // Check Login
        if (enteredId == userId && enteredPin == userPin) {

            System.out.println("Login Successful!");

            int choice;

            do {
                // Menu
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Quit");

                System.out.print("Choose an option: ");
                choice = sc.nextInt();

                switch (choice) {

                    // Transaction History
                    case 1:
                        if (transactionHistory.equals("")) {
                            System.out.println("No transactions yet.");
                        } else {
                            System.out.println("Transaction History:");
                            System.out.println(transactionHistory);
                        }
                        break;

                    // Withdraw
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();

                        if (withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            transactionHistory += "Withdraw: Rs." + withdrawAmount + "\n";
                            System.out.println("Withdrawal Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    // Deposit
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = sc.nextDouble();

                        balance += depositAmount;
                        transactionHistory += "Deposit: Rs." + depositAmount + "\n";
                        System.out.println("Deposit Successful!");
                        break;

                    // Transfer
                    case 4:
                        System.out.print("Enter Account Number: ");
                        int accountNumber = sc.nextInt();

                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();

                        if (transferAmount <= balance) {
                            balance -= transferAmount;
                            transactionHistory += "Transfer to A/C "
                                    + accountNumber + ": Rs."
                                    + transferAmount + "\n";

                            System.out.println("Transfer Successful!");
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    // Check Balance
                    case 5:
                        System.out.println("Current Balance: Rs." + balance);
                        break;

                    // Quit
                    case 6:
                        System.out.println("Thank You for Using ATM!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 6);

        } else {
            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}