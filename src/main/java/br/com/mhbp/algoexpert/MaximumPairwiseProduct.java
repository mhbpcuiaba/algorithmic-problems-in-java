package br.com.mhbp.algoexpert;

import java.util.Scanner;

public class MaximumPairwiseProduct {

    public static void main(String[] args) {
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
