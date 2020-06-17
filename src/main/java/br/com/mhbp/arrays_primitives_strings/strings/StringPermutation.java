package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    static Set<String> answers = new HashSet<>();

    public static void main(String[] args) {
        String str = "abc";
        generateAllStringsPermutation(str, "");

        System.out.println();
        System.out.println();
        System.out.println();
        answers.forEach(System.out::println);
    }

    /*
      reduzir a string base a cada chamda removendo apenas o caracter que foi incluso na string de permutacao q sera o resultado.
     */
    private static void generateAllStringsPermutation(String baseString, String permutedString) {

        int permutedStringLength = permutedString.length();
        int baseStringLength = baseString.length();

        if (baseStringLength == 0) {
//            System.out.println(permutedString + " ");
            answers.add(permutedString);
            return;
        }

        for (int i = 0; i < baseStringLength; i++) {
            char ch = baseString.charAt(i);

            String newBaseString = baseString.substring(0, i) + baseString.substring(i + 1);
            generateAllStringsPermutation(newBaseString, permutedString + ch);
        }
    }


}
