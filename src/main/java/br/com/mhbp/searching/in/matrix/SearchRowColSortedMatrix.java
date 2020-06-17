package br.com.mhbp.searching.in.matrix;

import java.util.List;

public class SearchRowColSortedMatrix {

    boolean matrixSearch(List<List<Integer>> matrix, int x) {
        int row = 0;
        int col = matrix.get(0).size() - 1;

        while ( row < matrix.size() && col >= 0) {

            if (matrix.get(row).get(col) < x) {
                row++;
            } else if (matrix.get(row).get(col) > x) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }
}
