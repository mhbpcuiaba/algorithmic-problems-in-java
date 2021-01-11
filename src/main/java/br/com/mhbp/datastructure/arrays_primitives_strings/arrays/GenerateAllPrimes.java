package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateAllPrimes {

    public static void main(String[] args) {

        System.out.println(generatePrimes(5));
    }

    public static List<Integer> generatePrimes(int n) {
        ArrayList<Integer> primes = new ArrayList<>();

        if (n > 1) {

            primes.add(2);
            List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n, true));

            for (int i = 0; i < n; i++) {

                if (isPrime.get(i)) {
                    int p = i * 2 + 3;
                    primes.add(p);

                    //nao entendi a ideia desse for
                    for (int j = i * i * 2 + 6 * i + 3; j < n; j += p) {
                        isPrime.set(j, false);
                    }
                }
            }
        }

        return primes;
    }
}
