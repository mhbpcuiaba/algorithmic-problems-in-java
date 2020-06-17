package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCaseStringPermutation {


    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();



        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (Character.isLetter(c)) {

                int n = permutations.size();

                for (int j = 0; j < n; j++) {
                    char[] chars = permutations.get(j).toCharArray();

                    if (Character.isUpperCase(chars[j])) {
                        chars[j] = Character.toLowerCase(chars[j]);
                    } else {
                        chars[j] = Character.toUpperCase(chars[j]);
                    }

                    permutations.add(String.valueOf(chars));
                }
            }

        }
        return permutations;
    }

}
