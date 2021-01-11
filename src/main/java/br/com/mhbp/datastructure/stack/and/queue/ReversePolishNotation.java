package br.com.mhbp.datastructure.stack.and.queue;

import java.util.LinkedList;

public class ReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        eval(tokens);
    }

    private static int eval(String[] s) {

        LinkedList<String> stack = new LinkedList<>();
        stack.push(s[0]);
        int expr = 0;
        for (int i = 1; i < s.length; i++) {

            if ( isOperator(s[i])) {

                //check if stack has at least two operands
                String op1 = stack.pop();
                String op2 = stack.pop();
                String result = calc(s[i], op1, op2);
                stack.push(result);
            } else {
                stack.push(s[i]);
            }
        }

        return expr;
    }

    private static String calc(String s, String op1, String op2) {
        return null;
    }

    private static boolean isOperator(String s) {
        return false;
    }
}
