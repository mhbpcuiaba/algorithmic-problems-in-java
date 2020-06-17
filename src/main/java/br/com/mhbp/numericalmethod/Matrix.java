package br.com.mhbp.numericalmethod;

public class Matrix {

    public double[][] multiply(double[][] m1, double[][] m2) {
        int N = m1.length;
        double[][] result = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                   result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }
}
