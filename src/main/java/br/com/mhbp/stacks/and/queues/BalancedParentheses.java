package br.com.mhbp.stacks.and.queues;

import java.util.LinkedList;

public class BalancedParentheses {

    public static void main(String[] args) {
        String str1 =  "[()]{}{[()()]()}";
        String str2 = "[(])";


        isBalanced(str1);
        isBalanced(str2);
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

        stack.add(str1.charAt(0));

        for (int i = 1; i < str1.toCharArray().length; i++) {

            char charAt = str1.charAt(i);

            if (!stack.isEmpty() && isOpenAndClose(stack.peek(), charAt)) {
                stack.pop();
            } else {
                stack.push(charAt);
            }

        }
        return stack.isEmpty();
    }

    private static boolean isOpenAndClose(Character peek, Character charAt) {
        return (peek.equals('(') && charAt.equals(')'))
                || (peek.equals('[') && charAt.equals(']'))
                || (peek.equals('{') && charAt.equals('}'));
    }

}
