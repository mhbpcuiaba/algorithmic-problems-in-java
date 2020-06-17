package br.com.mhbp.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {



    static List<List<Integer>> solve(int n) {
        List<List<Integer>> matrix = new ArrayList<>();
        solverHelper(0, n, new ArrayList<Integer>(), matrix);
        return matrix;
    }

    private static void solverHelper(int currentRow, int N, List<Integer> colPlacement, List<List<Integer>> matrix) {

        if (currentRow == N) {
            matrix.add(new ArrayList(colPlacement));
            return ;
        }


        for (int col = 0; col < N; col++) {

            colPlacement.add(col);
            if (isValid(colPlacement)) {
                solverHelper(currentRow + 1, N, colPlacement, matrix);
            }
            colPlacement.remove(colPlacement.size() - 1);
        }


    }

    private static boolean isValid(List<Integer> colPlacement) {
        int rowID = colPlacement.size() - 1;// limiting row

        Integer lastColumnAddedIndex = colPlacement.get(rowID);// indice na ultima coluna adicionada

        for (int i = 0; i < rowID; i++) {//validar apenas as linhas q ja foram processadas

            Integer currentColumnIndex = colPlacement.get(i);
//            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowID));
            int diff = Math.abs(currentColumnIndex - lastColumnAddedIndex); // diferença netra a coulna corrente e a ulçtima coluna

            //diff == 0, significa que as duas colunas sao as msm
            // diff == rowID - i
            //nao precisamos checar vixinho esquerdo e vizinho de cima pis nunca colocamos duasw rainhas na mesma linha
            if (diff == 0 || diff == rowID - i) return false;

        }
        return true;
    }
}
