package br.com.mhbp.dynamic.programming;

import java.util.HashMap;

public class FibonnaciDymacicProgramming {


    static HashMap<Integer, Integer> calculateds = new HashMap<>();

    public static void main(String[] args) {

        calculateds.put(1, 1);
        calculateds.put(0, 1);
        System.out.println(fibonacci(1_000_000));
    }

    private static int fibonacci(int n) {

        int n1, n2;

        if (calculateds.containsKey(n - 1)) {
            n1 = calculateds.get(n -1 );
        } else {
            n1 = fibonacci(n - 1);
            calculateds.put(n - 1, n1);
        }

        if (calculateds.containsKey(n - 2)) {
            n2 = calculateds.get(n - 2 );
        } else {
            n2 = fibonacci(n - 2);
            calculateds.put(n - 2, n2);
        }

        return n1 + n2;
    }
}
