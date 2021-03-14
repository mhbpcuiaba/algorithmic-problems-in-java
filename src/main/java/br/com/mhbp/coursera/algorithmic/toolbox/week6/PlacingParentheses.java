package br.com.mhbp.coursera.algorithmic.toolbox.week6;

import java.util.Scanner;
//5-8+7*4-8+9
public class PlacingParentheses {

    private static long getMaximValue(String exp) {
        String[] operatorsAndOperands = exp.split(" ");

        String tmp = new String(exp);
        String[] operands = tmp.replace("+", " ")
                .replace("-", " ")
                .replace("*", " ")
                .split(" ");
        int n = operands.length;
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];
        for (int i = 0; i < n; i++) {
            Long operand = Long.valueOf(operands[i]);
            min[i][i] = operand;
            max[i][i] = operand;
        }
        for (int s = 1; s < n; s++) {
            for (int i = 0; i < n - s; i++) {
                int j = i + s;
                long[] minAndMaxLocal = minAndMaxFunc(i, j, min, max, exp);
                min[i][j] = minAndMaxLocal[0];
                max[i][j] = minAndMaxLocal[1];
            }
        }
        //write your code here
      return max[0][n - 1];
    }

    private static long[] minAndMaxFunc(int i, int j, long[][] min, long[][] max, String exp) {
        long localMin = Long.MAX_VALUE;
        long localMax = Long.MIN_VALUE;

        for(int k = i; k < j; k++) {

            char oper = exp.charAt(k * 2 + 1);
            long a = eval(min[i][k], min[k + 1][j], oper);
            long b = eval(min[i][k], max[k + 1][j], oper);
            long c = eval(max[i][k], min[k + 1][j], oper);
            long d = eval(max[i][k], max[k + 1][j], oper);

            localMin = Math.min(a, Math.min(b, Math.min(c, Math.min(d, localMin))));
            localMax = Math.max(a, Math.max(b, Math.max(c, Math.max(d, localMax))));
        }

        return new long [] {localMin, localMax};
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

