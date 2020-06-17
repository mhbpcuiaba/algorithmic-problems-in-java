package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateSubSequence {

    public static void main(String[] args) {
        int[] array = {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = {5, 1, 25, 22, 6, -1, 8, 10};
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());
        List<Integer> sequenceList = Arrays.stream(sequence).boxed().collect(Collectors.toList());

        System.out.println(isValidSubsequence(arrayList, sequenceList));
    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int aIndex = 0;
        int sIndex = 0;

        while(sIndex < sequence.size() && aIndex < array.size()) {
            if (sequence.get(sIndex)  == array.get(aIndex)) {
                sIndex++;
            }
            aIndex++;
        }
        return sIndex == sequence.size();
    }
}
