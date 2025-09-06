# 🧠 Day-01 :- Sharp Creativity Puzzle: The Guessing Game 🎮

Feeling bored? Need a quick mental reset? Welcome to the Guessing Game, a simple yet powerful puzzle designed to sharpen your creativity and bring a moment of calm focus to your day. This isn't just code; it's a challenge to your intuition, built with the power and portability of Java.

---

### ## 🌟 The Challenge

The concept is timeless: The computer secretly picks a number between 1 and 100. Your mission, should you choose to accept it, is to uncover this number in the fewest tries possible. With every guess, you'll receive a clue, guiding you closer to the solution. It’s a perfect blend of logic and luck!

---

### ## 🚀 How to Play

1.  **Compile and run** the Java program.
2.  When prompted, **enter your guess** (a number from 1 to 100).
3.  The game will give you a hint:
    - `Guess a larger number.`
    - `Guess a smaller number.`
4.  Use these clues to refine your strategy and make your next guess.
5.  Continue until you guess the correct number. The game will celebrate your success and show you how many steps it took to find your inner peace!

---

### ## 🔧 Get Started

Ready to test your intuition? You'll need the Java Development Kit (JDK) installed.

1.  Save the code as `GuessingGame.java`.
2.  Open your terminal and navigate to the file's location.
3.  Compile the code with this command:
    ```bash
    javac GuessingGame.java
    ```
4.  Run the game:
    ```bash
    java GuessingGame
    ```

Enjoy the puzzle!


---


# 🧠 Day-02 :- Simple Console Calculator
A classic, straightforward console calculator built to demonstrate fundamental programming principles in different languages. This project provides a clean, easy-to-understand implementation of basic arithmetic operations.

---

## 🌟 About This Project
This repository contains the source code for a simple command-line calculator. The goal is to perform basic math functions like addition, subtraction, multiplication, and division. It's an excellent project for beginners to understand core programming concepts like user input, control flow, and functions.

---

## ✨ Features
- User-Friendly Interface: A simple menu-driven system for easy operation.
- Core Arithmetic Operations: Supports addition, subtraction, multiplication, and division.
- Error Handling: Includes basic checks, such as for division by zero.
- Cross-Platform: Designed to be compiled and run on any system with a standard compiler.

---

## 🚀 Versions
This project is available in three different programming languages:

**Java Version** - The Java version is a fully object-oriented implementation. It uses a Scanner for user input and is structured within a class, following standard Java conventions. This version highlights Java's platform independence and robust error handling with try-catch blocks.

---

## 🔧 How to Run
Please refer to the source code file for your language of choice for specific compilation and execution instructions.
For Java: javac Simplecalculator.java && SimpleCalculator


---


# 🧠 DAY-03 :- Digital Clock Console Application
A classic and elegant digital clock implemented in the console. This project demonstrates the fundamentals of time handling and continuous updates in three different programming languages: C, C++, and Java.

## 🌟 About This Project
This repository contains a simple yet functional digital clock that displays the current time and date directly in your terminal. The clock updates every second, providing a live feed of the current time. It's an excellent project for understanding time libraries, loops, and cross-platform console manipulation.

---

## ✨ Features
- Real-Time Display: Shows the current time, updating every second. 
- Date Display: Shows the current date, including the day of the week.
- Customizable Time Format: Users can choose between 12-hour (AM/PM) and 24-hour formats at the start.
- Cross-Platform: Designed to run on both Windows and UNIX-like systems (Linux, macOS).

---

## 🚀 Versions
This project is available in three different programming languages, each showcasing a unique approach:

**Java Version** - A fully object-oriented and platform-independent implementation. This version uses the modern java.time package for handling dates and times and leverages Java's built-in threading for the one-second delay, highlighting Java's strengths in creating portable and reliable applications.

--- 

## 🔧 How to Run
For each version, you will need the appropriate compiler (GCC for C/C++, JDK for Java). You can compile and run the source file from your terminal.
For Java: javac DigitalClock.java && java DigitalClock


---


# 🧠 DAY-04: Terminal Progress Bar

A simple yet visually satisfying terminal-based progress bar implemented in **Java**. This project demonstrates how to update console output dynamically and is perfect for learning about loops, formatting, and time delays across languages.

---

## 🌟 About This Project

This repository contains source code for a basic progress bar that updates in real-time on the terminal. It’s designed to help beginners understand how to manipulate console output and simulate task progress in different programming environments.

---

## ✨ Features

- Dynamic Console Output: Real-time progress updates using loops and formatted strings  
- Adjustable Speed: Delay intervals can be modified to simulate different task durations  
- Cross-Language Comparison: See how similar logic is implemented in C, C++, and Java  
- Minimal Dependencies: Uses only standard libraries for portability and simplicity  

---

## 🚀 Versions

**Java Version**  : Implements the progress bar using `System.out.printf()` and `Thread.sleep()` for smooth console updates.

---

## 🔧 How to Run

Refer to the source code files for each language. Below are sample compilation and execution commands:
For Java : javac ProgressBar.java && java ProgressBar


# 🧠 DAY-05 :- Console-Based User Management System
A robust, cross-platform User Management System designed to demonstrate core principles of data handling, security, and user interaction in different programming languages.

---

## 🌟 About This Project
This repository contains the source code for a console-based application that allows users to register and log in. It features a secure, in-memory database and a clean, interactive interface. A key feature is the cross-platform password masking, which hides user input for enhanced security on any operating system.

---

## ✨ Features
- User Registration: Allows new users to create an account.
- User Login: Authenticates existing users with their credentials.
- Password Masking: Hides password input for security (e.g., shows * instead of characters).
- Cross-Platform: The C and C++ versions are designed with conditional compilation to run seamlessly on Windows, macOS, and Linux.

---

## 🚀 Versions
This project is available in three different programming languages, each showcasing a unique approach to solving the same problem.

**Java Version** - The Java version is a fully object-oriented and platform-independent solution. It uses an ArrayList to manage user data and Java's Console class for secure password handling, highlighting Java's strengths in creating secure, portable, and robust applications.

---

## 🔧 How to Run

Refer to the source code files for each language. Below are sample compilation and execution commands:
For Java : javac UserManagement.java && java UserManagement


---


# 🧠 DAY-06 :- Console Bank Management System
A comprehensive, console-based banking application built to demonstrate fundamental and advanced programming concepts across Java. This project simulates the core functionalities of a bank account management system, focusing on data persistence, user interaction, and robust error handling.

---

## 🌟 About This Project
This repository contains the source code for a fully functional Bank Management System. The application allows users to create new bank accounts, deposit money, withdraw funds, and check their account balance. All user data is persistently stored, ensuring that information is saved between sessions. It's an excellent project for showcasing skills in file handling, data structures, and object-oriented programming.

---

## ✨ Features
- Account Creation: Users can create a new bank account with their name and a unique account number.
- Deposit & Withdrawal: Perform deposits and withdrawals, with the system updating the account balance accordingly.
- Balance Inquiry: Check the current balance of any existing account.
- Persistent Data: All account information is saved to a local file, so data is never lost.
- Robust Error Handling: The system includes checks for invalid input, insufficient funds, and non-existent accounts.

---

## 🚀 Versions
This project is available in three powerful languages, each showcasing a different programming paradigm:

**Java Version** - The Java version is a fully object-oriented and platform-independent implementation. It leverages Java's ArrayList for managing accounts in memory and uses object serialization for a powerful and standard way to save and load application data.

---

## 🔧 How to Run

Please refer to the source code file for your language of choice for specific compilation and execution instructions.
For Java : javac Bank_Management_System.java && java Bank_Management_System


---


# 🧠 DAY-07 :- Sudoku Solver
A classic Sudoku puzzle solver built to demonstrate the power of the backtracking algorithm. This project, available in Java, takes a hardcoded 9x9 Sudoku puzzle with empty cells (represented by 0) and efficiently finds the solution.

---

## 🌟 About This Project
This repository contains the source code for a console-based Sudoku solver. The goal is to showcase a practical implementation of a recursive, depth-first search algorithm to solve a complex logic puzzle. It's an excellent project for demonstrating an understanding of algorithms, recursion, and multi-dimensional arrays.

---

## ✨ Features
- Backtracking Algorithm: Implements the highly efficient backtracking algorithm to explore all possible solutions without brute-forcing every combination.
- Clear Console Output: The program prints both the initial unsolved puzzle and the final solved version in a clean, easy-to-read grid format.
- Validation Logic: Includes robust logic to check if a move is valid according to the rules of Sudoku (no repeated numbers in any row, column, or 3x3 subgrid).
- Solvability Check: Determines whether a given puzzle is solvable and reports back if no solution exists.

---

## 🚀 Versions
This project is available in three languages, each highlighting a different approach to solving the same problem:

**Java Version** - The Java version is a fully object-oriented and platform-independent implementation. The entire logic is contained within a SudokuSolver class, making the code highly organized and reusable, following standard Java conventions.

--- 

## 🔧 How to Run
Please refer to the source code file for your language of choice for specific compilation and execution instructions. The puzzle is hardcoded into the source for simplicity.
For Java : javac SudokuSolver.java && java SudokuSolver


---


# 🧠 DAY-08 :-  Tic-Tac-Toe Game
A classic Tic-Tac-Toe game where you can challenge an AI opponent. This project, available in Java, is a perfect demonstration of game loop mechanics, 2D array manipulation, and fundamental AI logic.

---

## 🌟 About This Project
This repository contains the source code for a console-based Tic-Tac-Toe game. The goal is to create a fully playable game against a computer opponent with varying difficulty levels. It's an excellent project for showcasing skills in procedural and object-oriented programming, logical thinking, and basic algorithm design.

---

## ✨ Features
- Interactive Gameplay: Play a full game of Tic-Tac-Toe directly in your console.
- Intelligent AI Opponent: The computer player uses a strategic algorithm to block wins and secure its own, making it a challenging opponent.
- Selectable Difficulty: Choose between a standard mode and a "God Mode" where the AI is unbeatable.
- Clear Console Display: The game board is printed in a clean, easy-to-read format after every turn.
- Score Tracking: The game keeps track of wins, losses, and draws across multiple rounds.

---

## 🚀 Versions
This project is available in three languages, each offering a unique perspective on building the same game:

**Java Version** - The Java version is a fully object-oriented and platform-independent implementation. The entire logic is contained within a TicTacToe class, making the code highly organized and reusable. It uses a Scanner for user input and includes robust error handling, following standard Java conventions.

## 🔧 How to Run
Please refer to the source code file for your language of choice for specific compilation and execution instructions.
For Java : javac TicTacToe.java && java TicTacToe


---


# 🧠 DAY-09 :- Laundry Management System
A straightforward and efficient console-based application designed to manage laundry service registrations and logins. This project, available in Java, showcases how to handle user data, perform file operations, and structure a practical application.

---

## 🌟 About This Project
This repository contains the source code for a console-based laundry management system. The primary goal is to provide a simple interface for users (students or laundry staff) to register for the service and log in to their accounts. It's an excellent project for demonstrating skills in data persistence, user input handling, and both procedural and object-oriented programming.

---

## ✨ Features
- User Registration: Allows new users to create an account by providing their details, which are then saved to a file.
- User Login: Authenticates existing users by checking their credentials against the saved records.
- Data Persistence: All user registration data is saved to a binary file (laundry_book.dat), ensuring that information is retained between sessions.
- Clear Console Interface: A simple and intuitive menu-driven interface for easy navigation and use.

---

## 🚀 Versions
This project is available in three languages, each offering a unique perspective on building the same application:

**Java Version** - The Java version is a fully object-oriented and platform-independent implementation. It uses classes for Registration and Login and leverages Java's Serializable interface to easily save and load user data, following standard Java conventions for file I/O and data management.

---

## 🔧 How to Run
Please refer to the source code file for your language of choice for specific compilation and execution instructions.
For Java : javac LaundryManagementSystem.java && java LaundryManagementSystem


---


# 🧠 DAY-10 :- Smart Cab Allocation System
A comprehensive console-based application that simulates a smart cab booking and management system. This project, available in Java, demonstrates how to build a multi-user system with different roles (Admin and User), handle data persistence, and implement core business logic.

---

## 🌟 About This Project
This repository contains the source code for a smart cab allocation system. The application allows an administrator to add and manage cabs in the system, and it provides a platform for users to register, log in, and eventually book rides. It's an excellent project for showcasing skills in system design, data structures, and creating interactive, multi-functional applications.

---

## ✨ Features
- Dual User Roles: Separate interfaces and functionalities for Admins (to manage cabs) and Users (to book rides).
- Secure Authentication: A robust login and registration system for both admins and users. User passwords are automatically hashed for security.
- Cab Management: Admins can add new cabs to the system, view the status of all cabs, and check their live locations.
- User Management: Users can create an account and log in to access the system's features.
- Clear Console Interface: A simple and intuitive menu-driven interface for easy navigation and use.

---

## 🚀 Versions
This project is available in three languages, each offering a unique perspective on building the same system:

**Java Version** - The Java version is a fully object-oriented and platform-independent implementation. It uses classes for each component of the system and leverages Java's robust collections framework, such as ArrayList and HashMap, for data management. It also includes strong error handling, following standard Java conventions.

---

## 🔧 How to Run
Please refer to the source code file for your language of choice for specific compilation and execution instructions.
For Java : javac SmartCabAllocationSystem.java && java SmartCabAllocationSystem