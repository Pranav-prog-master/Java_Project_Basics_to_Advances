import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Registration implements Serializable {
    private static final long serialVersionUID = 1L;
    int who;
    int l_no;
    String name;
    int registration_no;
    int hostel_no;
    int room_no;
    char block;
    long mobile_no;
    int password;

    public Registration(int who, String name, int regNo, int hostel, char block, int room, long mobile, int pass) {
        this.who = who;
        this.name = name;
        this.registration_no = regNo;
        this.hostel_no = hostel;
        this.block = block;
        this.room_no = room;
        this.mobile_no = mobile;
        this.password = pass;
    }
}

public class LaundryManagementSystem {
    private static final String FILENAME = "laundry_book.dat";
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("Welcome To Laundry Management System");
            System.out.println("Press 1 for Login");
            System.out.println("Press 2 for Registration");
            
            int choice = getIntInput();

            if (choice == 1) {
                if (loginUser()) {
                    System.out.println("\nLogin Successful!");
                } else {
                    System.out.println("\nLogin Failed: Invalid Laundry Number or Password.");
                }
            } else if (choice == 2) {
                registerUser();
            } else {
                 System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.println("Enter the following details for registration");
        System.out.println("Press 1 If you are a Student");
        System.out.println("Press 2 If you are a Laundry Man");
        int who = getIntInput();

        if (who == 1) {
            System.out.print("Registration No.: ");
            int regNo = getIntInput();
            System.out.print("\nStudent Name: ");
            String name = scanner.nextLine();
            System.out.print("\nHostel No.: ");
            int hostelNo = getIntInput();
            System.out.print("\nBlock Code: ");
            char block = scanner.nextLine().charAt(0);
            System.out.print("\nRoom No.: ");
            int roomNo = getIntInput();
            System.out.print("\nMobile No.: ");
            long mobileNo = getLongInput();
            int password = setPassword();

            Registration newUser = new Registration(who, name, regNo, hostelNo, block, roomNo, mobileNo, password);
            
            List<Registration> registrations = readRegistrations();
            int last_l_no = 0;
            if (!registrations.isEmpty()) {
                last_l_no = registrations.get(registrations.size() - 1).l_no;
            }
            newUser.l_no = last_l_no + 1;

            registrations.add(newUser);
            writeRegistrations(registrations);

            System.out.println("Congratulations!! You are successfully registered.");
            System.out.println("Your laundry number is " + newUser.l_no + ". Please do not forget it.");
        }
    }

    private int setPassword() {
        int password;
        int repin;
        System.out.println("\nPlease set a strong password to protect your Laundry Account.");
        System.out.println("Your laundry number will be your user name.");

        do {
            System.out.print("Password: ");
            password = getIntInput();
            System.out.print("\nConfirm Password: ");
            repin = getIntInput();

            if (password != repin) {
                System.out.println("\nPasswords do not match. Please try again.");
            }
        } while (password != repin);

        System.out.println("\nYour Password was saved successfully.");
        return password;
    }

    private boolean loginUser() {
        System.out.println("Welcome Back\nPlease Enter the required credentials");
        System.out.print("\nLaundry Number: ");
        int lNumber = getIntInput();
        System.out.print("\nPassword: ");
        int pin = getIntInput();

        List<Registration> registrations = readRegistrations();
        for (Registration reg : registrations) {
            if (reg.l_no == lNumber && reg.password == pin) {
                return true; 
            }
        }
        return false; 
    }

    @SuppressWarnings("unchecked")
    private List<Registration> readRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            registrations = (List<Registration>) ois.readObject();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return registrations;
    }

    private void writeRegistrations(List<Registration> registrations) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(registrations);
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
    
    private long getLongInput() {
        while (true) {
            try {
                long value = scanner.nextLong();
                scanner.nextLine(); 
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.nextLine(); 
            }
        }
    }

    public static void main(String[] args) {
        LaundryManagementSystem lms = new LaundryManagementSystem();
        lms.run();
    }
}
