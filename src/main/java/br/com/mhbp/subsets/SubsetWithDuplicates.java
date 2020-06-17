package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        //added it
        Arrays.sort(nums);
        int startIndex;
        int endIndex = 0;

        for (int i = 0; i < nums.length; i++) {


            //o pulo do gato
            if (i > 0 && nums[i] == nums[i-1])//it is a duplicated it, so skip all subsets generate up to last iteration/position
                startIndex = endIndex; // set startIndex greater than endIndex so we skip the next for loop
            else
                startIndex = 0;


            endIndex = subsets.size();

            for (int k = startIndex; k < endIndex ; k++) {

                List<Integer> set = new ArrayList<>(subsets.get(k));
                set.add(nums[i]);
                subsets.add(set);
            }

        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
