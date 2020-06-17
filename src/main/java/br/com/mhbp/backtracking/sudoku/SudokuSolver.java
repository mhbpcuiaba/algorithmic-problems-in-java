package br.com.mhbp.backtracking.sudoku;

public class SudokuSolver {


    public static final int SIZE_BOARD = 9;
    public static final int SIZE_BOX = 3;
    public static final String WHITE_SPACE = " ";
    static  int[][] board = new int[][] {
            {3, 1, 6,   5, 0, 8,   4, 0, 0},
            {5, 2, 0,   0, 0, 0,   0, 0, 0},
            {0, 8, 7,   0, 0, 0,   0, 3, 1},

            {0, 0, 3,   0, 1, 0,   0, 8, 0},
            {9, 0, 0,   8, 6, 3,   0, 0, 5},
            {0, 5, 0,   0, 9, 0,   6, 0, 0},

            {1, 3, 0,   0, 0, 0,   2, 5, 0},
            {0, 0, 0,   0, 0, 0,   0, 7, 4},
            {0, 0, 5,   2, 0, 6,   3, 0, 0}
    };

    public static void main(String[] args) {
        System.out.println("Beginning....");
        System.out.println("Sudoku challenge 1");
        System.out.println();
        solve();
    }
    public static void solve() {

        if (solve(0, 0)) {
            System.out.println("Sudoku challenge 1 solved");
            System.out.println();
            printSudoku();
        } else {
            System.out.println("there is no solution");
        }
    }

    private static void printSudoku() {

        System.out.println();

        for (int i = 0; i < SIZE_BOARD; i++) {

            if (i % SIZE_BOX == 0) {
                System.out.println();
                System.out.print("-------------------------");
            }

            System.out.println();

            for (int j = 0; j < SIZE_BOARD; j++) {
                if (j % SIZE_BOX == 0) System.out.print("|" + WHITE_SPACE);
                System.out.print(board[i][j] + WHITE_SPACE);
            }

            System.out.print("|" + WHITE_SPACE);

        }

        /*

           1) fgts do casal pode usar
           2) valor_de venda casa
           3) valor do financiamento que tenho q pagar =
           financia 336.000  + JUROS => X
           X + 100.000 <= 600_00 = 100_000 -

            parcela +
        *
        * */
        System.out.println();
        System.out.println("-------------------------");
        System.out.println();
    }

    private static boolean solve(int row, int col) {

        if (row == SIZE_BOARD && ++col == SIZE_BOARD)
            return true;

        if(row == SIZE_BOARD)
            row = 0;

        if (board[row][col] != 0)
            return solve(row + 1, col);

        for (int number = 1; number <= SIZE_BOARD; number++) {
            if (isValid(number,row, col)) {
                board[row][col] = number;
                if (solve(row + 1, col))
                    return true;
                board[row][col] = 0;
            }
        }

        return false;
    }

    private static boolean isValid(int number, int row, int col) {

        for (int i = 0; i < SIZE_BOARD; i++)
            if (board[row][i] == number || board[i][col] == number)
                return false;

        int offsetRow = (row / SIZE_BOX) * SIZE_BOX;
        int offsetCol = (col / SIZE_BOX) * SIZE_BOX;

        for (int i = 0; i < SIZE_BOX; i++)
            for (int j = 0; j < SIZE_BOX; j++)
                if (board[i + offsetRow][j + offsetCol] == number)
                    return false;

        return true;
    }
}
