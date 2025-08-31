import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

public class UserManagement {
    private static final int MAX_USERS = 10;
    private List<User> users;
    private Scanner scanner;

    public UserManagement() {
        this.users = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nWelcome to User Management");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = -1;
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("\nExiting Program.");
                    return;
                default:
                    System.out.println("\nInvalid option. Please try again.");
                    break;
            }
        }
    }

    private void registerUser() {
        if (users.size() >= MAX_USERS) {
            System.out.printf("\nMaximum %d users are supported! No more registrations allowed!\n", MAX_USERS);
            return;
        }

        System.out.println("\nRegister a new user");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful!");
    }

    private void loginUser() {
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                System.out.printf("\nLogin successful! Welcome, %s!\n", user.getUsername());
                return;
            }
        }
        System.out.println("\nLogin failed! Incorrect username or password.");
    }

    public static void main(String[] args) {
        UserManagement manager = new UserManagement();
        manager.run();
    }
}