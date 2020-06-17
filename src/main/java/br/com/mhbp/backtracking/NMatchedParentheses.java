package br.com.mhbp.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NMatchedParentheses {

    /*
    3 keys

    1) Our choice
        Place a "(" or ")"

    2) Our Constraints
        We cannot close until we open it. Count of left openes matters!!!!

    3) Our goal
        n ^ 2 placements -> Posicionamentos
     */
    public static void main(String[] args) {
        int input1 = 1;    // "()"
        int input2 = 2;    // "(), ()" ou "(())"
        int input3 = 3;    // ((())), (()()), (()) (), () (()), () () ()
        List<String> solutions = new ArrayList<>();

        int numberOfPairOfParentheses = 3;
        int numLeftParenthesesRequired =  numberOfPairOfParentheses, numRightParenthesesRequired = numberOfPairOfParentheses;

        generateAllComniations(solutions, numLeftParenthesesRequired, numRightParenthesesRequired, "");
    }

    private static void generateAllComniations(List<String> solutions, int numLeftParenthesesRequired, int numRightParenthesesRequired, String parenthesesInProgress) {


        if (numLeftParenthesesRequired == 0 && numRightParenthesesRequired == 0) {
            solutions.add(parenthesesInProgress);
            return;
        } else {

            if (numLeftParenthesesRequired > 0) {
                generateAllComniations(solutions, numLeftParenthesesRequired - 1, numRightParenthesesRequired, parenthesesInProgress + "(");
                // call to generateAllComniations
            }

            if (numLeftParenthesesRequired < numLeftParenthesesRequired) {
                // call to generateAllComniations
                generateAllComniations(solutions, numLeftParenthesesRequired, numRightParenthesesRequired - 1, parenthesesInProgress + ")");
            }
        }
    }
}
