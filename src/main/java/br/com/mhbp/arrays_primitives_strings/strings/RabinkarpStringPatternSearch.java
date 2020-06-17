package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.HashMap;
import java.util.Map;

public class RabinkarpStringPatternSearch {

    final static int d = 256;

    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // A prime number
        search(pat, txt, q);
    }

//https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
//https://www.baeldung.com/java-full-text-search-algorithms
    static void search(String pat, String txt, int q) {
        int lengthOfPattern = pat.length();
        int lengthOfText = txt.length();
    }

}
