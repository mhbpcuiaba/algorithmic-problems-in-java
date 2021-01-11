package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_dimensional_arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrdering {

    public static void main(String[] args) {
        System.out.println(Math.ceil(3 * 0.5));
        System.out.println(Math.ceil(4 * 0.5));
        System.out.println(Math.ceil(5 * 0.5));
        System.out.println(Math.ceil(6 * 0.5));
        System.out.println(Math.ceil(7 * 0.5));
        System.out.println(Math.ceil(8 * 0.5));
    }
    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {

        List<Integer> spiralOrdering = new ArrayList<>();

        for (int offset = 0; offset < Math.ceil(squareMatrix.size() * 0.5); offset++) {
            matrixLayerInClockwise(squareMatrix, offset, spiralOrdering);
        }
        return null;
    }

    private static void matrixLayerInClockwise(List<List<Integer>> squareMatrix, int offset, List<Integer> spiralOrdering) {


        int limitedByOffset = squareMatrix.size() - offset - 1;

        if (offset == squareMatrix.size() - offset - 1) {
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
            return;
        }

        for (int i = offset; i < limitedByOffset; i++) {
            spiralOrdering.add(squareMatrix.get(offset).get(i));
        }


        for (int i = offset; i < limitedByOffset; i++) {
            spiralOrdering.add(squareMatrix.get(i).get(limitedByOffset));
        }


        for (int i = limitedByOffset; i > offset ; i--) {
            spiralOrdering.add(squareMatrix.get(limitedByOffset).get(i));
        }

        for (int i = limitedByOffset; i > offset ; i--) {
            spiralOrdering.add(squareMatrix.get(i).get(limitedByOffset));
        }
    }
}
