package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_dimensional_arrays;

import java.util.Collections;
import java.util.List;

public class SudokuChecker {

    public static boolean isValid(List<List<Integer>> sudoku) {


        //check rows constraint
        for (int i = 0; i < sudoku.size(); i++) {

            if (hasDuplicates(sudoku, i, i + 1, 0, sudoku.size() )) {
                return false;
            }
        }

        for (int i = 0; i < sudoku.size(); i++) {

            if (hasDuplicates(sudoku, 0, sudoku.size(), i, i + 1 )) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                if (hasDuplicates(sudoku, i* 3, (i * 3) + 3, k * 3, (k * 3) + 3 )) {
                    return false;
                }

            }

        }
        return true;
    }

    private static boolean hasDuplicates(List<List<Integer>> sudoku, int startRow, int endRow, int startColumn, int endColumn) {

        List<Boolean> visited = Collections.nCopies(sudoku.size() + 1, false);
        for (int row = startRow; row < endRow; row++) {
            for (int col = startColumn; col < endColumn; col++) {

                if ( sudoku.get(row).get(col) != 0 && visited.get(sudoku.get(row).get(col))) {
                    return true;
                }
                visited.set(sudoku.get(row).get(col), true);
            }

        }
        return false;
    }
}
