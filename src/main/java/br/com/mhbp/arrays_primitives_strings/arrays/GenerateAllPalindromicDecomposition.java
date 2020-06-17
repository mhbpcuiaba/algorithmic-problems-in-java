package br.com.mhbp.arrays_primitives_strings.arrays;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPalindromicDecomposition {


    public static void main(String[] args) {
        //TEHRE IS A BUG
        /*
        [a, a, b]
        [aa, a, b]

should be


        [a, a, b]
        [aa, b]

         */
        partition("aab").forEach(System.out::println);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> allDecompositions = new ArrayList<>();
        List<String> decompositionInprogress = new ArrayList<>();

        decomposeString(s, 0, decompositionInprogress, allDecompositions);
        return allDecompositions;
    }

    private static void decomposeString(String s, int buildPointer, List<String> decompositionInprogress, List<List<String>> allValidsDecompositions) {

        if (buildPointer == s.length()) {
            allValidsDecompositions.add(new ArrayList<>(decompositionInprogress));
            return;
        }

        for (int i = buildPointer; i < s.length() ; i++) {

            if ( isPalindrome(s, buildPointer, i)) {
                String palindromeSnippet = s.substring(buildPointer, i + 1);
                decompositionInprogress.add(palindromeSnippet);
                decomposeString(s, buildPointer + palindromeSnippet.length(), decompositionInprogress, allValidsDecompositions);
                decompositionInprogress.remove(decompositionInprogress.size() - 1);
            }

        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }

}
