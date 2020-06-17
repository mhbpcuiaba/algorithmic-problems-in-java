package br.com.mhbp.backtracking;

public class EightQueensProblem {

    static int N = 4;
    public static void main(String[] args) {
        int[][] matrix = {
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0},
                { 0,  0,  0,  0}
        } ;


        boolean result = solve(matrix);
    }

    private static boolean solve(int[][] matrix) {


        return false;
    }

    public boolean solveRecursive(int y, int[][] matrix) {
        if (y == N) return true;

        for (int x = 0; x < N; x++) {

            if (isSafePlace(x, y, matrix)) {
                matrix[x][y] = 1;

                if (solveRecursive(y+1, matrix)) {
                    return true;
                }

                matrix[x][y] = 0;//backtrack
            }
        }

        return false;
    }

    //TODO check
    public static boolean isSafePlace(int x, int y, int[][] matrix) {

        //check vertical
        for (int i = x - 1; i >= 0; i--) {
            if (matrix[i] [y] == 1) {
                return false;
            }
        }

        //check horizontal
        for (int j = y - 1; j >= 0; j--) {
            if (matrix[x] [j] == 1) {
                return false;
            }
        }

        //check upper diagonal
        for (int j = y - 1, i = x - 1; j >= 0 && i>= 0; j--, i--) {
            if (matrix[i] [j] == 1) {
                return false;
            }
        }

        //check lower diagonal
        for (int j = y - 1, i = x + 1; j >= 0 && i < N; j--, i--) {
            if (matrix[i] [j] == 1) {
                return false;
            }
        }

        return true;
    }
}
