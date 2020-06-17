package br.com.mhbp.arrays_primitives_strings.arrays.dutchflagproblem;

import java.util.Collections;
import java.util.List;


public class DutchFlagPartitionSolver {

    /*
        1. less than pivotal
        2. equal to pivot
        3. greater than pivot
        4. unclassified
     */

    public static void dutchFlagPartitionWithQuadraticTimeComplexity(int pivot, List<Integer> numbers) {

        //group elements smaller than pivot
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {

                if (numbers.get(j) < pivot) {
                    Collections.swap(numbers, i, j);
                    break;
                }
            }
        }

        //group elements greater than pivot
        for (int i = numbers.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers.get(j) > pivot) {
                    Collections.swap(numbers, i, j);
                    break;
                }
            }
        }
    }

    public static void dutchFlagPartitionWithLinearTimeComplexity(int pivot, List<Integer> numbers) {

        int smaller = 0;

        for (int j = 0; j < numbers.size(); j++) {
            if (numbers.get(j) < pivot) {
                Collections.swap(numbers, smaller++, j);
            }
        }

        int larger = numbers.size() - 1;

        for (int j = 0; j >= 0; j--) {
            if (numbers.get(j) > pivot) {
                Collections.swap(numbers, larger--, j);
            }
        }
    }

    public static void dutchFlagPartitionWithLinearTimeComplexity_Versao_2(int pivot, List<Integer> numbers) {

        int smaller = 0, equal = 0, larger = numbers.size();

        while (equal < larger) {

            if (numbers.get(equal) < pivot) {
                Collections.swap(numbers, smaller++, equal++);
            } else if (numbers.get(equal) == pivot) {
                ++equal;
            } else {
                Collections.swap(numbers, equal, --larger);
            }
        }
    }
}
