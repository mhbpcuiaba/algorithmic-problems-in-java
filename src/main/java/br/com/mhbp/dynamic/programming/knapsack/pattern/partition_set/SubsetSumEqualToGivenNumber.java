package br.com.mhbp.dynamic.programming.knapsack.pattern.partition_set;

public class SubsetSumEqualToGivenNumber {



    public static void main(String[] args) {
        int[] array = {1, 2, 3, 7};

//        isTheresubsetSumEqualTo(6, array);
    }

    private static boolean isTheresubsetSumEqualTo(int targetSum, int[] array, int currentIndex) {

        if (targetSum == 0) return true;

        if (currentIndex  >= array.length) return false;

        boolean r1 = isTheresubsetSumEqualTo(targetSum - array[currentIndex], array, currentIndex + 1);
        boolean r2 = isTheresubsetSumEqualTo(targetSum, array, currentIndex + 1);


        return r1 || r2;
    }
}
