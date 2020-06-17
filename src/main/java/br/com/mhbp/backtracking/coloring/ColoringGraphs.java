package br.com.mhbp.backtracking.coloring;

public class ColoringGraphs {

    private int numOfVertexes;
    private int numOfColors;
    private int[] colors;
    private int[][] adjacencyMatrix;

    public ColoringGraphs(int[][] adjacencyMatrix, int numOfColors) {

        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfColors = numOfColors;
        this.numOfVertexes = adjacencyMatrix.length;
        this.colors = new int[numOfVertexes];
    }


    public void solve() {

        if(solveProblem(0)) {
            showResults();
        } else {
            System.out.println("there is no solution..");
        }
    }

    private boolean solveProblem(int vertexIndex) {

        if (vertexIndex == numOfVertexes) return true;

        for (int colorIndex = 0; colorIndex < numOfColors; colorIndex++) {
            if (isColorValid(vertexIndex, colorIndex)) {
                colors[vertexIndex] = colorIndex;

                if (solveProblem(vertexIndex + 1)) {
                    return true;
                }

//                colors[vertexIndex] = -1;
            }
        }


        return false;
    }

    private boolean isColorValid(int vertexIndex, int colorIndex) {

        for (int neighbourIndex = 0; neighbourIndex < numOfVertexes; neighbourIndex++) {
            // there is a connection and the colorIndex is already been used then reject
            if (adjacencyMatrix[vertexIndex][neighbourIndex] == 1 && colors[neighbourIndex] == colorIndex) return false;
        }
        return true;
    }

    private void showResults() {
        for (int i = 0; i < colors.length; i++) {
            System.out.println("Color: " + colors[i]);
        }
    }
}
