package br.com.mhbp.datastructure.arrays_primitives_strings.arrays.sliding.window;

import java.util.HashMap;

public class NoRepeatSubstring {

    public static int findLength(char[] arr) {
        int windowStart = 0;
        int maxLength = 0;
        HashMap<Character, Integer> letterFrequencyMap = new HashMap<>();// integer will be the index wher we find the character

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

            if (letterFrequencyMap.containsKey(arr[windowEnd])) {

                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, letterFrequencyMap.get(arr[windowEnd]) + 1);
            }

            letterFrequencyMap.put(arr[windowEnd], windowEnd);
            int windowSize = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, windowSize);// remember the maximum length so far

        }
        return maxLength;
    }
}
