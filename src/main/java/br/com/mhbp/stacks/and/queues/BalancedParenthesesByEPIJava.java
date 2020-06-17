package br.com.mhbp.stacks.and.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class BalancedParenthesesByEPIJava {



    public static boolean isBalanced(String string) {

        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');


        for (int index = 0; index < string.length(); index++) {


            char currentChar = string.charAt(index);
            Character rightMatch = map.get(currentChar);

            if (rightMatch != null) {//it means currentChar is an open parentheses
                stack.add(currentChar);
            } else if (stack.isEmpty() || map.get(stack.removeFirst()) != rightMatch) { // currentChar is a Close parentheses
                return false;
            }

        }

        return stack.isEmpty();
    }
}
