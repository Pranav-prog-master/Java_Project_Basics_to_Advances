import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DigitalClock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int format = inputFormat(scanner);

        DateTimeFormatter timeFormatter;
        if (format == 1) {
            timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        } else {
            timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

        try {
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                clearScreen();
                
                System.out.println("Current Time: " + now.format(timeFormatter));
                System.out.println("Date: " + now.format(dateFormatter));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("Clock thread was interrupted.");
            Thread.currentThread().interrupt(); 
        } finally {
            scanner.close(); 
        }
    }

    private static int inputFormat(Scanner scanner) {
        int format = 2; 
        while (true) {
            try {
                System.out.println("\nChoose the time format:");
                System.out.println("1. 24 Hour format");
                System.out.println("2. 12 Hour format (default)");
                System.out.print("Make a choice (1/2): ");
                int choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    format = choice;
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
        return format;
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Failed to clear screen: " + e.getMessage());
        }
    }
}
