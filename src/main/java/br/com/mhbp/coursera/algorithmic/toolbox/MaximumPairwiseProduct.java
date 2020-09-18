package br.com.mhbp.coursera.algorithmic.toolbox;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MaximumPairwiseProduct {


    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            int n = random.nextInt() % 10 + 2;
            System.out.println("n: " + n);
            ArrayList<Integer> list = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                list.add(random.nextInt() % 100_000);
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            Long res1 = maxPairwiseProduct(list);
            Long res2 = maxPairwiseProductFast(list);

            if (res1 != res2) {
                System.out.println("Wrogn answer: " + res1 + " " + res2);
            } else
                System.out.println("OK");
        }
    }

    //TODO implement
    private static Long maxPairwiseProductFast(ArrayList<Integer> list) {
        return null;
    }

    //TODO implement
    private static Long maxPairwiseProduct(ArrayList<Integer> list) {
        return 0L;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (maxIndex == -1 || array[maxIndex] < array[i])
                maxIndex = i;
        }

        int secondMaxIndex = -1;

        for (int i = 0; i < n; i++) {
            if ( maxIndex != i && secondMaxIndex == -1 || ( maxIndex != i && array[secondMaxIndex] < array[i]) )
                secondMaxIndex = i;
        }

        if (secondMaxIndex == -1) secondMaxIndex = 0;
        long maximumPairwiseProduct = (long) array[maxIndex] * array[secondMaxIndex];
        System.out.print(maximumPairwiseProduct+"\n");
    }
}
