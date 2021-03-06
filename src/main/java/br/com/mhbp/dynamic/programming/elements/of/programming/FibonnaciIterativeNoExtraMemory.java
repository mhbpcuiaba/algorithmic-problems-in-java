package br.com.mhbp.dynamic.programming.elements.of.programming;

public class FibonnaciIterativeNoExtraMemory {

    public long calculate(long n) {

        long fibPenultimate = 0;
        long fibLast = 1;
        long fib = 0;

        for (long i = 2; i <= n; i++) {
            fib = fibLast + fibPenultimate;
            fibPenultimate = fibLast;
            fibLast = fib;
        }

        return fib;
    }
    public static void main(String[] args) {
//        Integer.MIN_VALUE = -2_147_483_648;
//        Integer.MAX_VALUE =  2_147_483_647;
//        System.out.println(new FibonnaciIterativeNoExtraMemory().calculate(1_000_000_000L)); // 3_311_503_426_941_990_459
        System.out.println(new FibonnaciIterativeNoExtraMemory().calculate(1_000_000L));  //   1_884_755_131 => ? -4249520595888827205
        System.out.println(new FibonnaciIterativeNoExtraMemory().calculate(2_000_000L));  //
    }
}
