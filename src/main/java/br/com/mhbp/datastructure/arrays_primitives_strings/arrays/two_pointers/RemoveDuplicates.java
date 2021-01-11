package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.two_pointers;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] array = { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(removeDuplicates(array));

        int[] array2 = { 2, 2, 2, 11};
        System.out.println(removeDuplicates(array2));


    }

    private static int removeDuplicates(int[] array) {

        int nextNonDuplicate = 0;
        int next = 0;

        for (  ; next < array.length - 1; ) {

            if ( array[next] == array[next + 1])  {
                while ( next < array.length - 1 && array[next] == array[next + 1]  ) next++;

                // (array[next] != array[next + 1] || next == array.length - 1
                if (next < array.length - 1) {

                    array[++nextNonDuplicate] = array[++next];
                }
            } else {
                nextNonDuplicate++;
                next++;
            }

        }

        return nextNonDuplicate + 1;
//        return array.length - nextNonDuplicate;
    }

    private static int remove(int[] arr) {

        int nextNonDuplicate = 1;
        for (int i = 0; i < arr.length; i++) {

            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate++] = arr[i];
            }
        }

        return nextNonDuplicate;
    }
}
