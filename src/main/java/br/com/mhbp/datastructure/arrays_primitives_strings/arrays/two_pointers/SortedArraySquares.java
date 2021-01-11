package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_pointers;

public class SortedArraySquares {

    public static void main(String[] args) {
        int[] array = { -2, -1, 0, 2, 3 };
        int[] result = makeSquares(array);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] makeSquares_V2(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        int left = 0;
        int right = n -1;
        int highestSquareId = right;

        while (left < right) {
            int leftSquare = array[left] * array[left];
            int rightSquare = array[right] * array[right];

            if (leftSquare > rightSquare) {
                result[highestSquareId++] = leftSquare;
                left++;

            } else {
                result[highestSquareId] = rightSquare;
                right++;
            }
        }
        return result;
    }

    public static int[] makeSquares(int[] array) {
     int[] result = new int[array.length];

     int indexFirstNonNegative = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                indexFirstNonNegative = i;
                break;
            }
        }

        if ( indexFirstNonNegative == -1 || indexFirstNonNegative == 0) {

            for (int i = 0; i < array.length; i++) {
                result[i] =  array[i] * array[i];
            }
        } else{

            int left = indexFirstNonNegative - 1;
            int indexResult = 0;

            if (array[indexFirstNonNegative] == 0) {
                result[indexResult++] = 0;
                indexFirstNonNegative++;
            }

            int right = indexFirstNonNegative;

            while( left >= 0 && right < array.length) {

                if ( Math.abs(array[left]) < Math.abs(array[right])) {
                    result[indexResult++] = array[left] * array[left];
                    left--;
                } else {
                    result[indexResult++] = array[right] * array[right];
                    right++;
                }
            }


            while (left >= 0) {
                result[indexResult++] = array[left] * array[left];
                left--;

            }

            while (right < array.length) {
                result[indexResult++] = array[right] * array[right];
                right++;

            }
        }
     return result;
    }
}
