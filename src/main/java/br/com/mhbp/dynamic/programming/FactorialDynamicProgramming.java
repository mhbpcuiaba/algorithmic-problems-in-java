package br.com.mhbp.dynamic.programming;

import java.util.HashMap;

public class FactorialDynamicProgramming {

    static HashMap<Integer, Integer> calculateds = new HashMap<>();

    public static void main(String[] args) {
        calculateds.put(0, 1 );
        calculateds.put(1, 1 );

        System.out.println(factorial(5));
    }

    private static int factorial(int n) {

        if ( n == 1 || n == 0) {
            return 1;
        }

        if (!calculateds.containsKey(n -1))
            calculateds.put(n - 1, factorial(n - 1));

        return n * calculateds.get(n - 1);
    }
}
