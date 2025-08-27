import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GuessingGame {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the world of Guessing Numbers");
        
        int randomNumber = rand.nextInt(100) + 1;
        int guess = 0;
        int numberOfGuesses = 0;

        do {
            System.out.print("\nPlease enter your Guess between (1 to 100): ");
            
            try {
                guess = scanner.nextInt();
                numberOfGuesses++;

                if (guess < randomNumber) {
                    System.out.println("Guess a larger number.");
                } else if (guess > randomNumber) {
                    System.out.println("Guess a smaller number.");
                } else {
                    System.out.printf("\nCongratulations!!! You have successfully guessed the Number in %d attempts\n", numberOfGuesses);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); 
            }

        } while (guess != randomNumber);

        System.out.println("\nBye Bye, Thanks for Playing.");
        System.out.println("Developed by: KGCoding");    
        scanner.close();
    }
}
