import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to the Bank Account Management System");
            
            System.out.println("1. Create a new account");
            System.out.println("2. View all acounts");
            System.out.println("3. Search account by account number");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Check balance");
            System.out.println("7. Delete account");
            System.out.println("8. Exit");

            System.out.println("Please select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    viewAccounts();
                    break;

                case 3:
                    searchAccount();
                    break;

                case 4:
                    depositMoney();
                    break;

                case 5:
                    withdrawMoney();
                    break;

                case 6:
                    checkBalance();
                    break;

                case 7:
                    deleteAccount();
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");


            }

            

            



        }

        
    }

    public static void createAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accountHolderName = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, balance);
        accounts.add(newAccount);
        System.out.println("Account created sucessfully!");
                
    }

    public static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. ");
        } else {
            System.out.println("List of all accounts: ");
            for (BankAccount account : accounts) {
                System.out.println(account);

            }

        }
        
    }

    public static void searchAccount() {
        System.out.print("Enter an Account Number: ");
        int accountNumber  = sc.nextInt();

        boolean found = false;
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println("Account found: " + account);
                found = true;
                break;
                
            }     
        }

        if(!found) {
            System.out.println("Account not found.");
            
        }


    }

    public static void depositMoney() {
        System.out.print("Enter account number:");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (BankAccount account : accounts ) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter amount to deposit: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                
                account.deposit(amount);
                System.out.println("Deposit successful. New balance: " + account.getBalance());
                found =true;
                break;
            
            }

        }

        if(!found) {
            System.out.println("Account not found.");

        }

        
    }
    public static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter amount to withdraw: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                account.withdraw(amount);
                found = true;
                break;

            }

        }
        
        if(!found) {
            System.out.println("Account not found. ");

        }
    }

    public static void checkBalance() {
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for(BankAccount account : accounts) {
            if(account.getAccountNumber() == accountNumber) {
                System.out.println("Current balance: " + account.getBalance());
                found = true;
                break;  
            }

        }
        if(!found){
            System.out.println("Account not found. ");
        }

    }
    public static void deleteAccount() {
        System.out.print("Enter account number to delete: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.remove(i);
                System.out.println("Account deleted successfully. ");
                found = true;
                break;

            }
        }
        if(!found) {
            System.out.println("Account not found. ");
        }
    }

}