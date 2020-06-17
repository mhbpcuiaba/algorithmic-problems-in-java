package br.com.mhbp.backtracking.coloring;

public class App {

    static int[][] matrix = {
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0}
    };

    static int numColors = 5;

    public static void main(String[] args) {
        ColoringGraphs coloringGraphs = new ColoringGraphs(matrix, numColors);

        coloringGraphs.solve();
    }
}
