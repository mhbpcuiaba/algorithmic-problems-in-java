package br.com.mhbp.hackerrank;

public class RatInMaze {

    static int N = 8;


    public static void main(String[] args) {
        int[][] board = {
                           {0,1,1,1,1,0,0,0,1,1},
                           {0,0,0,0,1,0,1,0,0,0},
                           {0,1,1,0,0,0,1,0,1,0},
                           {1,0,0,0,1,0,1,0,1,0},
                           {0,0,1,1,1,0,1,0,1,0},
                           {0,0,0,0,0,0,0,0,1,0},
                           {1,1,1,1,1,1,1,1,1,0},
                           {0,0,0,0,0,0,0,0,0,0},
                           {0,0,1,1,0,1,1,1,1,1},
                           {0,0,0,0,0,0,0,0,0,0}
                        };

        System.out.println("Start");
        System.out.println(solveRatMap(board, 0, 0));
        System.out.println("Game Over");
    }

    static Boolean cellIsEmpty(int row, int col, int[][] matrix) {

        if ( (row == N || col == N || row == -1 || col < 0)  && (matrix[row][col] == 1 || matrix[row][col] == 2) ) {
            return false;
        }

        return true;
    }

    static Boolean solveRatMap(int[][] matrix, int row, int col) {

        if( row == N-1 && col == N-1)  {
            matrix[row][col] = 2;
            return true;
        }

        if (cellIsEmpty(row, col, matrix) ) {
            matrix[row][col] = 2;

            if(solveRatMap(matrix, row, col + 1)) {
                return true;
            }


            if(solveRatMap(matrix, row + 1, col)) {
                return true;
            }
            matrix[row][col] = 0;
        }

        return false;
    }


}
