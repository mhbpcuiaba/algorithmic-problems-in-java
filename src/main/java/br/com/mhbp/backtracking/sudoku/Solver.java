package br.com.mhbp.backtracking.sudoku;



public class Solver {
    public static final int SIZE_BOARD = 9;
    public static final int SIZE_BOX = 3;
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

        if (sudokuSolver( 0, 0)) {
            print();
        } else {
            System.out.println("There is no solution!");
        }

    }
    public static void print() {
        for (int i = 0; i < 9; i++) {
            if(i % 3 == 0) System.out.println(" ");
            for (int j = 0; j < 9; j++) {
                if(j % 3 == 0) System.out.print(" ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean sudokuSolver( int row, int col) {

        if ( row == 9 && ++col == 9) {
            return true;
        }

        if (row == 9) { // we have considered every single row for the current column, restart row cause cal was already incremented
            row = 0;
        }

        if (board[row][col] != 0) { //there is an initial value, so go to solve for the next row
            return  sudokuSolver(row + 1, col);
        }


        for (int n = 1; n <= 9; n++) { //searching which number sould fit

            if (valid(row, col, n)) {

                board[row][col] = n;

                if (sudokuSolver(row + 1, col))
                    return true;

                board[row][col] = 0;
            }

        }

        return false;
    }

    private static boolean valid(int row, int col, int currentNumber) {

        //check row and column
        for (int i = 0; i < SIZE_BOARD; i++)
            if (board[row][i] == currentNumber || board[i][col] == currentNumber)
                return false;

         int boxRowOffset = (row / SIZE_BOX)  * SIZE_BOX; // integer division != double divsion
         int boxColOffset = (col / SIZE_BOX)  * SIZE_BOX;
        //check the the mini box
        for (int i = 0; i < SIZE_BOX; i++)
            for (int j = 0; j < SIZE_BOX; j++)
                if (board[boxRowOffset + i][boxColOffset + j] == currentNumber)
                    return false;

        return true;
    }
}
