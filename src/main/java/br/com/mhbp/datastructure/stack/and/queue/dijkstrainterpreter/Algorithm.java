package br.com.mhbp.datastructure.stack.and.queue.dijkstrainterpreter;


import java.util.Stack;

public class Algorithm {

    Stack<String> operationStack;
    Stack<Double> valueStack;

    public Algorithm() {
        this.operationStack = new Stack<>();
        Stack<Double> valueStack = new Stack<>();
    }

    public void interpretExpression(String expression) {
        String[] expressionArray = expression.split(" ");

        for (String s : expressionArray) {

            if (s.equals("(")) {

            } else if (s.equals("+") || s.equals("*")) {
                operationStack.push(s);
            } else if (s.equals(")")) {
                String op = operationStack.pop();

                if (op.equals("*")) {
                    valueStack.push(valueStack.pop() * valueStack.pop());
                } else if (op.equals("+")) {
                    valueStack.push(valueStack.pop() + valueStack.pop());
                }
            } else {
                valueStack.push(Double.valueOf(s));
            }
        }
    }
}
