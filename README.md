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

