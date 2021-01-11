package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.sliding.window;

import java.util.HashMap;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        HashMap<Character, Integer> fruitFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0) + 1);//inc

            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowEnd]) - 1);//dec

                if (fruitFrequencyMap.get(arr[windowStart]) == 0) {
                    fruitFrequencyMap.remove(arr[windowStart]);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }
}
