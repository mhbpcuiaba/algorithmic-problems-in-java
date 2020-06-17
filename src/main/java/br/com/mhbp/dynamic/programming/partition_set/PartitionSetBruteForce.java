package br.com.mhbp.dynamic.programming.partition_set;

import java.util.Arrays;

public class PartitionSetBruteForce {


    public static void main(String[] args) {
        PartitionSetBruteForce ps = new PartitionSetBruteForce();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }

    public static boolean canPartition(int[] num) {
        int sum = Arrays.stream(num).sum();
        if (num.length == 0 || sum % 2 == 1) return false; //we cannot partition odd integer sum equally or an empty array

        return canPartitionRecursive(num, sum/2, 0);
    }

    private static boolean canPartitionRecursive(int[] num, int sum, int currentIndex) {

        if (sum == 0) return true;


        if (num.length == 0 || currentIndex >= num.length) return false;

        if (num[currentIndex] <= sum) {

            if (canPartitionRecursive(num, sum - num[currentIndex], currentIndex + 1))
                return  true;

        }
        return false;
    }
}
