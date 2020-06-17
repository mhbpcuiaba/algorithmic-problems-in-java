package br.com.mhbp.backtracking.halmitonianpath;

public class HamiltonianCycleProblem {


    static int[] hamiltonianPath;
    static int  N;
    static int[][] matrix = {      // a  b  c  d  e  f
                                    { 0, 1, 1, 1, 0, 0 },  //a
                                    { 1, 0, 1, 0, 1, 1 },  //b
                                    { 1, 1, 0, 1, 0, 1 },  //c
                                    { 1, 0, 1, 0, 0, 1 },  //d
                                    { 0, 1, 0, 0, 0, 1 },  //e
                                    { 0, 1, 1, 1, 1, 0 }   //f
                            };

    public static void main(String[] args) {
        N = matrix.length;
        hamiltonianPath = new int[N];

        if (solve(1)) { //we consider index == 0 is the base solution
            System.out.println("Answer: " + hamiltonianPath);
        } else {
            System.out.println("There is no solution");
        }
    }

    private static boolean isConnected(int vertex1, int vertex2) {
        return matrix[hamiltonianPath[vertex1]][vertex2] == 1;
    }
    private static boolean solve(int index) {

        if (index == N) { //it passed by all vertexes??
            if ( isConnected(N - 1, 0)) { // Is hamiltonianPath a cycle?
                return true;
            } else {
                return false;
            }
        }


        for (int i = 0; i < N; i++) { // starts from 0 or 1??? and why? i++ or ++i ???

            if (isConnected(index, i)) {
                hamiltonianPath[index] = i;
                if (solve(index + 1)) {
                    return true;
                }
                hamiltonianPath[index] = 0;
            }
        }

        return false;
    }

}
