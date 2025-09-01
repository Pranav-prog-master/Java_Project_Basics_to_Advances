public class SudokuSolver {

    private int[][] puzzle;

    public SudokuSolver(int[][] initialPuzzle) {
        this.puzzle = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.puzzle[i][j] = initialPuzzle[i][j];
            }
        }
    }

    private boolean isValidMove(int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == val || puzzle[i][col] == val) {
                return false;
            }
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (puzzle[startRow + i][startCol + j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solveRecursive(int row, int col) {
        if (col == 9) {
            row++;
            col = 0;
        }
        if (row == 9) {
            return true; 
        }

        if (puzzle[row][col] > 0) {
            return solveRecursive(row, col + 1);
        }

        for (int val = 1; val <= 9; val++) {
            if (isValidMove(row, col, val)) {
                puzzle[row][col] = val;
                if (solveRecursive(row, col + 1)) {
                    return true;
                }
                puzzle[row][col] = 0; 
            }
        }
        return false;
    }

    public boolean solve() {
        return solveRecursive(0, 0);
    }

    public void printPuzzle() {
        System.out.println("\n+-------+-------+-------+");
        for (int row = 0; row < 9; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("|-------+-------+-------|");
            }
            for (int col = 0; col < 9; col++) {
                if (col % 3 == 0) {
                    System.out.print("| ");
                }
                if (puzzle[row][col] != 0) {
                    System.out.print(puzzle[row][col] + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    public static void main(String[] args) {
        int[][] initialPuzzle = {
            {3,0,0,0,2,0,0,7,0},
            {9,0,0,5,0,0,0,1,4},
            {0,1,6,3,7,0,0,0,8},
            {2,0,0,8,0,0,0,0,1},
            {5,0,0,0,4,1,8,0,0},
            {0,8,9,0,0,0,0,5,0},
            {0,0,5,0,1,0,2,8,0},
            {0,4,0,0,0,6,0,9,3},
            {7,3,1,0,8,2,0,0,0},
        };

        SudokuSolver solver = new SudokuSolver(initialPuzzle);

        System.out.println("\n\tWelcome to SUDOKU Solver !!!");
        System.out.println("\nOriginal Puzzle:");
        solver.printPuzzle();

        if (solver.solve()) {
            System.out.println("\nThe puzzle is solved: ");
            solver.printPuzzle();
        } else {
            System.out.println("\nThis puzzle is not Solvable");
        }
    }
}
