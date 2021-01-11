package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class KEqualSumSubSet {

    static int N_SUBSET = 5;
    public static void main(String[] args) {

        int[] ints = new Random().ints(N_SUBSET).toArray();

        Supplier<IntStream> intstream = () -> Arrays.stream(ints);
        intstream.get().forEach(System.out::println);
        int[] numbers =intstream.get().toArray();

        System.out.println();
        System.out.println();
        for (int number : numbers) {
            System.out.println(number);
        }

        canPartition(numbers, N_SUBSET);
    }

    private static void canPartition(int[] numbers, int ksubSets) {

        int sumOfAllElements = Arrays.stream(numbers).sum();
        if (ksubSets <= 0 || ksubSets > numbers.length || sumOfAllElements%ksubSets % ksubSets != 0) {
            System.out.println("Cannot partition");
            return;
        }


        if (canPartition(0, numbers, new boolean[numbers.length],  ksubSets, sumOfAllElements/ksubSets, 0)) {
            System.out.println("can partition");
        } else {
            System.out.println("cannot partition");
        }
    }

    private static boolean canPartition(int iterationStart, int[] numbers, boolean[] useds, int ksubSets, int sumTotalPartition, int partialSum) {

        if (ksubSets == 1) {
            return true;
        } else if (sumTotalPartition == partialSum) {
            return canPartition(0, numbers, useds, ksubSets - 1, sumTotalPartition, 0);
        }


        for (int i = iterationStart; i < numbers.length; i++) {

            if (!useds[i] && partialSum + numbers[i] <= sumTotalPartition) {
                useds[i] = true;
                if (canPartition(i, numbers, useds, ksubSets, sumTotalPartition, partialSum + numbers[i])) {
                    return true;
                }
                useds[i] = false;
            }
        }

        return false;
    }
}
