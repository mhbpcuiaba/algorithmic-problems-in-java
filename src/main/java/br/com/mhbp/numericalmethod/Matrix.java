package br.com.mhbp.numericalmethod;

public class Matrix {

    // there is no 2 dimensional native array in java, it has array of array
    public double[][] optimizeMultiply(double[][] m1, double[][] m2) {
        int N = m1.length;
        double[][] result = new double[N][N];

        double[] m1Row;
        double[] m2Col = new double[N];

        for (int j = 0; j < N; j++) {

            for (int k = 0; k < N; k++)
                m2Col[k] = m2[k][j];

            for (int i = 0; i < N; i++) {
                m1Row = m1[i];
                double sum = 0;

                for (int k = 0; k < N; k++) {
                    sum += m1Row[k] * m2Col[k];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    public double[][] multiply(double[][] m1, double[][] m2) {
        int N = m1.length;
        double[][] result = new double[N][N];

        //These two first for's are to full fill the result matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // for each cell in the result matrix we must do k additions
                for (int k = 0; k < N; k++) {
                   result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }
}
