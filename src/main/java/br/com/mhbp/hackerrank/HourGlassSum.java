package br.com.mhbp.hackerrank;

public class HourGlassSum {


    public int findMaxHourGlassSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= matrix.length - 3; i++) {
            for (int j = 0; j <= matrix.length - 3; j++) {
                int currentSum = calculateHourGlassSum(matrix, i, i + 2, j, j + 2);
                maxSum = Math.max(maxSum, currentSum);
            }
            
        }
        return maxSum;
    }

    int calculateHourGlassSum(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
        int sum = 0;

        // rows
        for (int i = colStart; i <= colEnd; i++) {
            sum += matrix[rowStart][i];
            sum += matrix[rowEnd][i];
        }
        sum += matrix[rowEnd - 1][colEnd - 1];
        return sum;
    }
}
