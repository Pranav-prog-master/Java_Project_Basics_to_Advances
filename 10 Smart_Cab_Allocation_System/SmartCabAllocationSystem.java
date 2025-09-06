import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a 2D location
class Location {
    double x;
    double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}

// Represents a Cab
class Cab {
    int cabId;
    Location location;
    boolean available;

    public Cab(int id, double x, double y) {
        this.cabId = id;
        this.location = new Location(x, y);
        this.available = true;
    }
}

// Represents a User with their credentials
class User {
    String username;
    long hashedPassword;

    public User(String username, long hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }
}

// Manages all registered users
class UserManager {
    private List<User> users = new ArrayList<>();

    public void registerUser(String username, String password) {
        long hashedPassword = hashPassword(password);
        users.add(new User(username, hashedPassword));
        System.out.println("\nUser registered successfully!");
    }

    public boolean authenticate(String username, String password) {
        long hashedPassword = hashPassword(password);
        for (User user : users) {
            if (user.username.equals(username) && user.hashedPassword == hashedPassword) {
                return true;
            }
        }
        return false;
    }

    // Simple hashing function (djb2 algorithm)
    private long hashPassword(String password) {
        long hash = 5381;
        for (char c : password.toCharArray()) {
            hash = ((hash << 5) + hash) + c; 
        }
        return hash;
    }
}

// Manages admin operations and cab data
class Admin {
    private final String username = "admin";
    private final String password = "admin123";
    private List<Cab> cabs = new ArrayList<>();

    public boolean isAuthorized(String enteredName, String enteredPassword) {
        return username.equals(enteredName) && password.equals(enteredPassword);
    }

    public void addCab(Cab cab) {
        cabs.add(cab);
    }

    public List<Cab> getAllCabs() {
        return cabs;
    }
}

// The main class that runs the entire application
public class SmartCabAllocationSystem {
    private UserManager userManager = new UserManager();
    private Admin admin = new Admin();
    private String currentUsername = null;
    private boolean isAdminLoggedIn = false;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            showMainMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    adminRoute();
                    if (isAdminLoggedIn) {
                        adminFunctionality();
                    }
                    break;
                case 2:
                    userRoute();
                    if (currentUsername != null) {
                        userFunctionality();
                    }
                    break;
                case -1:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n--- Welcome to Smart Cab Allocation System ---");
        System.out.println("1. Admin login");
        System.out.println("2. User login/register");
        System.out.println("-1. Exit from the system");
        System.out.print("Enter your choice: ");
    }

    private void adminRoute() {
        System.out.println("\n--- Admin Login ---");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (admin.isAuthorized(username, password)) {
            System.out.println("\nWelcome Admin!");
            isAdminLoggedIn = true;
        } else {
            System.out.println("\nAdmin login failed. Please retry.");
            isAdminLoggedIn = false;
        }
    }

    private void userRoute() {
        while (true) {
            System.out.println("\n--- User Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("-1. Back to main menu");
            System.out.print("Enter your choice: ");
            int choice = getIntInput();

            if (choice == 1) {
                System.out.print("\nEnter a username: ");
                String username = scanner.nextLine();
                System.out.print("Enter a password: ");
                String password = scanner.nextLine();
                userManager.registerUser(username, password);
                System.out.println("Now login to access our features.");
            } else if (choice == 2) {
                System.out.print("\nEnter your username: ");
                String username = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();
                if (userManager.authenticate(username, password)) {
                    System.out.println("\nAuthentication successful!");
                    currentUsername = username;
                    return; 
                } else {
                    System.out.println("\nAuthentication failed. Please check your credentials.");
                }
            } else if (choice == -1) {
                return; 
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void adminFunctionality() {
        int choice = 0;
        while (choice != -1) {
            System.out.println("\n--- Admin Functionality ---");
            System.out.println("1. Add Cab");
            System.out.println("2. Get all cabs details");
            System.out.println("-1. Logout");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            if (choice == 1) {
                System.out.print("Enter the cab id: ");
                int id = getIntInput();
                System.out.print("Enter the cab location (x y): ");
                double x = getDoubleInput();
                double y = getDoubleInput();
                admin.addCab(new Cab(id, x, y));
                System.out.println("Cab added successfully!");
            } else if (choice == 2) {
                List<Cab> cabs = admin.getAllCabs();
                if (cabs.isEmpty()) {
                    System.out.println("No cabs in the system yet.");
                } else {
                    System.out.println("\n--- List of all cabs ---");
                    for (Cab cab : cabs) {
                        System.out.printf("Cab ID: %d, Location: %s, Available: %s\n",
                                cab.cabId, cab.location, cab.available ? "Yes" : "No");
                    }
                }
            } else if (choice == -1) {
                isAdminLoggedIn = false;
                System.out.println("Admin logged out.");
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void userFunctionality() {
        System.out.printf("\nWelcome %s! Hope you like our services.\n", currentUsername);
        System.out.println("(User functionality is not yet implemented.)");
        System.out.println("Logging out...\n");
        currentUsername = null; 
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
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); 
            }
        }
    }

    public static void main(String[] args) {
        SmartCabAllocationSystem system = new SmartCabAllocationSystem();
        system.start();
    }
}
