package br.com.mhbp.arrays_primitives_strings.strings;

import java.util.HashMap;
import java.util.Map;

public class BoyerMooreStringSearch {




    static Map<Character, Integer> mismatchShiftTable = new HashMap<>();

    public static void main(String[] args) {
        String pattern = "test";
        precomputeShifts(pattern);
        compute(pattern);
    }
    static public void precomputeShifts(String pattern) {
        int lengthOfPattern = pattern.length();

        for (int i = 0; i < lengthOfPattern; i++) {
            char c = pattern.charAt(i);
            int maxShift = Math.max(1, lengthOfPattern - i - 1);
        }
    }


    static public void compute(String pattern) {


        int lengthOfPattern = pattern.length();

        String text = "ads asd asd asd";//mudar o texto
        int lengthOfText = text.length();

        int numOfSkips = 0;

        for (int i = 0; i < lengthOfText; i += numOfSkips) {
            numOfSkips = 0;

            for (int j = lengthOfPattern; j >= 0; j--) {

                if (pattern.charAt(i) != text.charAt(i + j)) {
                    numOfSkips = mismatchShiftTable.get(text.charAt(i + j));
                    break;
                } else {
                    numOfSkips = lengthOfPattern;
                    break;
                }

            }

//            if (numOfSkips == 0) return i;

        }
    }

}
