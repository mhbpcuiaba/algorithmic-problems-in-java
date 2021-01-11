package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_dimensional_arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {


    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            ArrayList<Integer> currentRow = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                int newCell = 0 < j && j < i ? pascalTriangle.get(i - j).get(j - 1) + pascalTriangle.get(i - j).get(j - 1) : 1;
                currentRow.add(newCell);
            }
            pascalTriangle.add(currentRow);
        }

        return pascalTriangle;
    }
}
