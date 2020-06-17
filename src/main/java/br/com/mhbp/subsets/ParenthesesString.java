package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParenthesesString {

    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    public static List<String> generateValidParentheses(int num) {
        ArrayList<String> result = new ArrayList<>();
        LinkedList<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));

        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();


            if (ps.openedCount == num && ps.closedCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openedCount < num)
                    queue.add(new ParenthesesString(ps.str + "(", ps.openedCount + 1, ps.closedCount));

                if (ps.openedCount < ps.closedCount)
                    queue.add(new ParenthesesString(ps.str + ")", ps.openedCount, ps.closedCount + 1));

            }
        }

        return result;
    }
    String str;
    int openedCount;
    int closedCount;

    public ParenthesesString(String str, int openedCount, int closedCount) {
        this.str = str;
        this.openedCount = openedCount;
        this.closedCount = closedCount;
    }


}
