package br.com.mhbp.datastructure.stack.and.queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.function.ToIntBiFunction;

public class RPNExpression {

    public static int eval(String expression) {
        ArrayDeque<Integer> intermediateResults = new ArrayDeque<>();
        HashMap<String, ToIntBiFunction<Integer, Integer>> operators = new HashMap<>();
        operators.put("+", (y, x) -> x + y);//?? why y,x and then x + Y, why not y + x???? something related to RPN????
        operators.put("-", (y, x) -> x - y);
        operators.put("/", (y, x) -> x / y);
        operators.put("*", (y, x) -> x * y);

        for (String token : expression.split(",")) {

            if ( operators.get(token) != null) {
                Integer leftOperand = intermediateResults.removeFirst();
                Integer rightOperand = intermediateResults.removeFirst();
                //if we do not have operatros map we would have to write 3 if adn 1 else
                intermediateResults.addFirst(operators.get(token).applyAsInt(leftOperand, rightOperand));
            } else {
                intermediateResults.addFirst(Integer.parseInt(token));
            }
        }
        return intermediateResults.removeFirst();
    }
}
