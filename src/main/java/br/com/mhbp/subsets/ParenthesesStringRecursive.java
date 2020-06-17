package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesStringRecursive {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<>();

        char[] chars = new char[2 * num];
        generateValidParenthesesHelper(num, result, chars, 0, 0, 0);
        return result;
    }

    private static void generateValidParenthesesHelper(int num, List<String> result, char[] permutation,  int opened, int closed, int index) {
        if (opened == num && closed == num) {
            result.add(new String(permutation));
            return;
        }

        if (opened < num) {
            permutation[index] = '(';
            generateValidParenthesesHelper(num, result, permutation, opened + 1, closed, index + 1);
        }

        if (opened < closed) {
            permutation[index] = ')';
            generateValidParenthesesHelper(num, result, permutation, opened, closed + 1, index + 1);
        }

    }
}
