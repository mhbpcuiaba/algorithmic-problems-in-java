//package br.com.mhbp.coursera.ds.w1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

/*
  1- zero brackets but not empty
  2- one open bracket

 */
public class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        boolean foundError = false;
        Bracket bracket = null;
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position));
                bracket = new Bracket(next, position + 1);
                // Process opening bracket, write your code here
            }

            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty()) {
                    foundError = true;
                    bracket = new Bracket(next, position + 1);
                    break;
                }

                bracket = opening_brackets_stack.pop();
                if (!bracket.Match(next)) {
                    foundError = true;
                    bracket = new Bracket(next, position + 1);
                    break;
                }
            }
        }

        /*

((
))
Input:
[](()

Your output:
4
Correct output:
3
         */
        if (opening_brackets_stack.isEmpty() && !foundError)
            System.out.print("Success");
        else {
//            Bracket bracket = opening_brackets_stack.pop();
            System.out.print(bracket.position);
        }
    }
}