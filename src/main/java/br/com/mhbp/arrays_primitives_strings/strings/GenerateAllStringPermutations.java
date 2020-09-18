package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.HashSet;
import java.util.Set;

public class GenerateAllStringPermutations {


    public static void main(String[] args) {
        String s = "ABC";
        String s1 = "EBAY";
        String s2 = "Yahoo";
        System.out.println("\nString " + s + ":\nPermutations: " + permutations(s));
        System.out.println("\nString " + s1 + ":\nPermutations: " + permutations(s1));
        System.out.println("\nString " + s2 + ":\nPermutations: " + permutations(s2));


    }

    public static Set<String> permutations(String str) {
        Set<String> permutations = new HashSet<>();

        if (str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char firstCharacter = str.charAt(0);
        String remainCharacters = str.substring(1);
        Set<String> words = permutations(remainCharacters);

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                permutations.add(crunchifyCharAdd(word, firstCharacter, i));
            }
        }

        return permutations;
    }

    private static String crunchifyCharAdd(String word, char character, int indexPartition) {
        String firstHalf = word.substring(0, indexPartition);
        String secondHalf = word.substring(indexPartition);
        return firstHalf + character + secondHalf;
    }
}
