package br.com.mhbp.arrays_primitives_strings.arrays.two_dimensional_arrays;

import java.util.List;

public class MatrixRotation {



    public static void rotateMatrix(List<List<Integer>> matrix) {

        int maxRows = matrix.size() / 2;

        for (int i = 0; i < maxRows; i++) {


            int maxColumns = matrix.size() - i - 1;

            for (int j = i; j < maxColumns; j++) {

                //perform a 4-way exchange
                int tmp1 = matrix.get(i).get(j);                 // i,j
                int tmp2 = matrix.get(j).get(maxColumns - i);    // j,i

                int tmp3 = matrix.get(maxColumns - i).get(maxColumns - j);// i,j
                int tmp4 = matrix.get(maxColumns - j).get(i); // j,i


                matrix.get(i).set(j, tmp4);
                matrix.get(j).set(maxColumns - i, tmp1);
                matrix.get(maxColumns - i).set(maxColumns - j, tmp2);
                matrix.get(maxColumns - j).set(i, tmp3);
            }


        }
    }
}
