package br.com.mhbp.backtracking.knighttour;

public class Solver {
    static final Integer NUMBER_OF_CHESSBOARD_CELLS = 64;
    int[][] chessboard = new int[8][8];
    Cell[] tour = new Cell[NUMBER_OF_CHESSBOARD_CELLS];
    int[] xMoves = { -1, -1, -2,  -2,   1,   1,  2,  2 };
    int[] yMoves = { -2,  2, -1,   1,   2,  -2,  1, -1 };


    //TODO investigate
    public static void main(String[] args) {
        new Solver().solve();
    }
    public void solve() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessboard[i][j] = Integer.MIN_VALUE;

            }

        }
        System.out.println();
        chessboard[0][0] = 1;
        tour[0] = new Cell(0, 0);
        if (solveUtil(chessboard, 0, 0, 2)) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    String line =  chessboard[i][j] + " ";

                    if (chessboard[i][j] <= 9 ) {
                        line = " " + line;
                    }
                    System.out.print(line);

                }
                System.out.println();

            }
        } else {
            System.out.println("there is no feasible solution");
        }
    }

    private boolean solveUtil(int[][] chessboard, int row, int col, int indexCellTour) {
        if (indexCellTour == NUMBER_OF_CHESSBOARD_CELLS) {
            return true;
        }

        //moves
        for (int i = 0; i < 8; i++) {

                int newRow = row + xMoves[i];
                int newCol = col + yMoves[i];

            if (isMovableCase(newRow, newCol)) {
//                tour[indexCellTour] = new Cell(newRow, newCol);
                chessboard[newRow] [newCol] = indexCellTour;

                if (solveUtil(chessboard, newRow, newCol, indexCellTour + 1)) {
                    return true;
                }
                tour[indexCellTour] = null;
                chessboard[newRow] [newCol] = Integer.MIN_VALUE;

            }
        }

        return false;
    }

    private boolean isMovableCase(int row, int col) {
        if (row < 0 || row >= 8) return false;
        if (col < 0 || col >= 8) return false;
        if (chessboard[row][col]  != Integer.MIN_VALUE) return false;
        return true;
    }


    static class Cell {
        int newRow;
        int newCol;

        public Cell(int newRow, int newCol) {

            this.newRow = newRow;
            this.newCol = newCol;
        }
    }

}
