import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private int difficulty;
    private int playerScore;
    private int computerScore;
    private int drawScore;
    private final char PLAYER_X = 'X';
    private final char COMPUTER_O = 'O';
    private final int BOARD_SIZE = 3;
    private Scanner scanner;
    private Random random;

    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        scanner = new Scanner(System.in);
        random = new Random();
        playerScore = 0;
        computerScore = 0;
        drawScore = 0;
    }

    public void start() {
        System.out.println("\nSelect difficulty level:");
        System.out.println("1. Human (Standard)");
        System.out.println("2. God (Impossible to win)");
        System.out.print("Enter your choice: ");
        difficulty = scanner.nextInt();

        int playAgain = 1;
        do {
            playGame();
            System.out.print("\nPlay again? (1 for yes, 0 for no): ");
            playAgain = scanner.nextInt();
        } while (playAgain == 1);
        System.out.println("\nBye Bye, thanks for playing.\n");
    }

    private void playGame() {
        resetBoard();
        char currentPlayer = (random.nextInt(2) == 0) ? PLAYER_X : COMPUTER_O;

        while (true) {
            printBoard();
            if (currentPlayer == PLAYER_X) {
                playerMove();
                if (checkWin(PLAYER_X)) {
                    playerScore++;
                    printBoard();
                    System.out.println("Congratulations! You have won!!!");
                    break;
                }
                currentPlayer = COMPUTER_O;
            } else {
                System.out.println("Computer's turn (O)...");
                computerMove();
                if (checkWin(COMPUTER_O)) {
                    computerScore++;
                    printBoard();
                    System.out.println("I won!!! But you played well...");
                    break;
                }
                currentPlayer = PLAYER_X;
            }
            if (checkDraw()) {
                drawScore++;
                printBoard();
                System.out.println("\nIt's a draw!");
                break;
            }
        }
    }

    private void resetBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        clearScreen();
        System.out.printf("Score - Player (X): %d | Computer (O): %d | Draws: %d\n", playerScore, computerScore, drawScore);
        System.out.println("-------------------");
        System.out.println("   Tic-Tac-Toe\n");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("     ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < BOARD_SIZE - 1) System.out.print("|");
            }
            if (i < BOARD_SIZE - 1) System.out.println("\n     ---+---+---");
        }
        System.out.println("\n");
    }

    private void playerMove() {
        int row, col;
        do {
            System.out.println("\nPlayer X's turn.");
            System.out.print("Enter row and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (!isValidMove(row, col)) {
                System.out.println("Invalid move. Try again.");
            }
        } while (!isValidMove(row, col));
        board[row][col] = PLAYER_X;
    }
    
    private void computerMove() {
        // AI Logic (same as the C version)
        // 1. Check for a winning move
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = COMPUTER_O;
                    if (checkWin(COMPUTER_O)) return;
                    board[i][j] = ' '; // backtrack
                }
            }
        }
        // 2. Block player's winning move
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = PLAYER_X;
                    if (checkWin(PLAYER_X)) {
                        board[i][j] = COMPUTER_O;
                        return;
                    }
                    board[i][j] = ' '; // backtrack
                }
            }
        }
        // 3. God mode strategy
        if (difficulty == 2) {
            if (board[1][1] == ' ') { board[1][1] = COMPUTER_O; return; }
            int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
            for (int[] corner : corners) {
                if (board[corner[0]][corner[1]] == ' ') {
                    board[corner[0]][corner[1]] = COMPUTER_O;
                    return;
                }
            }
        }
        // 4. Default move
        int row, col;
        do {
            row = random.nextInt(BOARD_SIZE);
            col = random.nextInt(BOARD_SIZE);
        } while (board[row][col] != ' ');
        board[row][col] = COMPUTER_O;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == ' ';
    }
    
    private boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < BOARD_SIZE; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    private void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Handle exceptions
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
