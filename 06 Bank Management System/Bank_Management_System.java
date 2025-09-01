import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Account implements Serializable {
    private static final long serialVersionUID = 1L; 
    String name;
    int accNo;
    double balance;

    public Account(String name, int accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }
}

public class Bank_Management_System {
    private static final String ACCOUNT_FILE = "account.dat";
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n\n*** Bank Management System ***");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: checkBalance(); break;
                case 5:
                    System.out.println("\nClosing the Bank, Thanks for your visit.");
                    return;
                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        }
    }

    private void createAccount() {
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your account number: ");
        int accNo = getIntInput();
        
        List<Account> accounts = readAccounts();
        accounts.add(new Account(name, accNo, 0.0));
        writeAccounts(accounts);
        
        System.out.println("\nAccount created successfully!");
    }

    private void depositMoney() {
        System.out.print("Enter your account number: ");
        int accNo = getIntInput();
        System.out.print("Enter amount to deposit: ");
        double money = getDoubleInput();

        List<Account> accounts = readAccounts();
        boolean found = false;
        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                acc.balance += money;
                found = true;
                System.out.printf("Successfully deposited Rs.%.2f. New balance is Rs.%.2f\n", money, acc.balance);
                break;
            }
        }

        if (found) {
            writeAccounts(accounts);
        } else {
            System.out.println("Money could not be deposited as Account No. " + accNo + " was not found.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter your account number: ");
        int accNo = getIntInput();
        System.out.print("Enter amount to withdraw: ");
        double money = getDoubleInput();

        List<Account> accounts = readAccounts();
        boolean found = false;
        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                found = true;
                if (acc.balance >= money) {
                    acc.balance -= money;
                    System.out.printf("Successfully withdrawn Rs.%.2f. Remaining balance is Rs.%.2f\n", money, acc.balance);
                } else {
                    System.out.println("Insufficient balance!");
                }
                break;
            }
        }

        if (found) {
            writeAccounts(accounts);
        } else {
            System.out.println("Money could not be withdrawn as Account No. " + accNo + " was not found.");
        }
    }

    private void checkBalance() {
        System.out.print("Enter your account number: ");
        int accNo = getIntInput();

        List<Account> accounts = readAccounts();
        boolean found = false;
        for (Account acc : accounts) {
            if (acc.accNo == accNo) {
                System.out.printf("\nYour current balance is Rs.%.2f\n", acc.balance);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nAccount No. " + accNo + " was not found.");
        }
    }

    @SuppressWarnings("unchecked")
    private List<Account> readAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE))) {
            accounts = (List<Account>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return accounts;
    }

    private void writeAccounts(List<Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    private int getIntInput() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a whole number: ");
                scanner.nextLine(); 
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Bank_Management_System bank = new Bank_Management_System();
        bank.run();
    }
}
