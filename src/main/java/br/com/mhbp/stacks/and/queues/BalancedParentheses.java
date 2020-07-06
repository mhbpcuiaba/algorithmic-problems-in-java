package br.com.mhbp.stacks.and.queues;

import java.util.LinkedList;

public class BalancedParentheses {

    public static void main(String[] args) {
        String str1 =  "[()]{}{[()()]()}";
        String str2 = "[(])";
        String str3 = "([])(){}(())()()";
        String str4 = "(a)";


        isBalanced(str1);
        isBalanced(str2);
        isBalanced(str3);
        isBalanced(str4);
    }
    private static void isBalanced(String str1) {
        LinkedList<Character> stack = new LinkedList<>();
        if (isBalanced(str1, stack)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    private static boolean isBalanced(String str1, LinkedList<Character> stack) {


        for (int i = 0; i < str1.toCharArray().length; i++) {

            char charAt = str1.charAt(i);

            if (charAt != '(' && charAt != ')' && charAt != '[' && charAt != ']' && charAt != '{' && charAt != '}') continue;
            if (!stack.isEmpty() && isOpenAndClose(stack.peek(), charAt)) {
                stack.pop();
            } else {
                stack.push(charAt);
            }

        }
        return stack.isEmpty();
    }

    private static boolean isOpenAndClose(Character opens, Character closeds) {
        return (opens.equals('(') && closeds.equals(')'))
                || (opens.equals('[') && closeds.equals(']'))
                || (opens.equals('{') && closeds.equals('}'));
    }

}
