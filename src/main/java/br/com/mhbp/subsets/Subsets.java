package br.com.mhbp.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {

            int n = subsets.size();

            for (int k = 0; k < n; k++) {
                ArrayList<Integer> set = new ArrayList<>(subsets.get(k));
                set.add(nums[i]);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
