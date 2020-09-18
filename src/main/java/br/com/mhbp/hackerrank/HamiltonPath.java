package br.com.mhbp.hackerrank;

public class HamiltonPath {

    public static void main(String[] args) {

        /*
          0 = a
         */
        int[][] adjacencyMatrix =    { // a  b  c  d  e  f
                                        { 0, 1, 1, 1, 0, 0 }, //a
                                        { 1, 0, 1, 0, 1, 1 }, //b
                                        { 1, 1, 0, 1, 0, 1 }, //c
                                        { 1, 0, 1, 0, 0, 1 }, //d
                                        { 0, 1, 0, 0, 0, 1 }, //e
                                        { 0, 1, 1, 1, 1, 0 }  //f
                                     };

        int[] hamiltonPathSequence = new int[adjacencyMatrix.length];

        if(solve(adjacencyMatrix, hamiltonPathSequence, 0)) {
            System.out.println("Success...");
        } else {
            System.out.println("adjacencyMatrix = " + adjacencyMatrix);

        }
    }

    static boolean solve(int[][] matrix, int[] hamiltonPathSequence, int vertexIndex) {

        if (vertexIndex == hamiltonPathSequence.length) {
            return true;
        }

        for (int i = 0; i < hamiltonPathSequence.length; i++) {

            if (matrix[vertexIndex] [i] == 1) {
                hamiltonPathSequence[vertexIndex] = i;
                if(solve(matrix, hamiltonPathSequence, vertexIndex + 1)) {
                    return true;
                } else {
                    hamiltonPathSequence[vertexIndex] = 0;
                }

            }
        }

        return false;
    }
}
