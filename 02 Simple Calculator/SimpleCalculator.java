import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class SimpleCalculator {

    private Scanner scanner;

    public SimpleCalculator() {
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            printMenu();
            choice = getMenuChoice();

            if (choice == 7) {
                break;
            }

            if (choice < 1 || choice > 7) {
                System.err.println("Invalid Menu Choice.");
                continue;
            }

            double first = getNumber("Please enter the first number: ");
            double second = getNumber("Now, enter the second number: ");
            double result = 0.0;
            boolean calculationValid = true;

            switch (choice) {
                case 1: // Add
                    result = first + second;
                    break;
                case 2: // Subtract
                    result = first - second;
                    break;
                case 3: // Multiply
                    result = first * second;
                    break;
                case 4: // Divide
                    if (second == 0) {
                        System.err.println("Error: Cannot divide by zero.");
                        calculationValid = false;
                    } else {
                        result = first / second;
                    }
                    break;
                case 5: // Modulus
                     if (second == 0) {
                        System.err.println("Error: Cannot perform modulus by zero.");
                        calculationValid = false;
                    } else {
                        result = first % second;
                    }
                    break;
                case 6: // Power
                    result = Math.pow(first, second);
                    break;
            }

            if (calculationValid) {
                System.out.printf("\nResult of operation is: %.2f\n", result);
            }

        } while (choice != 7);
        
        System.out.println("\nCalculator is exiting. Goodbye!");
        scanner.close(); 
    }

    private void printMenu() {
        System.out.println("\n\n---------------------------------");
        System.out.println("Welcome to Simple Calculator");
        System.out.println("\nChoose one of the following options:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        System.out.println("6. Power");
        System.out.println("7. Exit");
        System.out.print("Now, enter your choice: ");
    }

    private double getNumber(String prompt) {
        double num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }
        }
        return num;
    }

    private int getMenuChoice() {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number for your choice: ");
                scanner.next();
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.run();
    }
}
