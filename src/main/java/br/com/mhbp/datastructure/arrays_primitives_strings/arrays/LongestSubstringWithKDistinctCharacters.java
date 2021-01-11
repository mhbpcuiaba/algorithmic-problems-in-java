package br.com.mhbp.datastructure.arrays_primitives_strings.arrays;

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        int result =  findLength("araaci".toCharArray(), 1);
        System.out.println("result: " + result);
    }

    private static int findLength(char[] array, int k) {
        int windowStart = 0, longest = 0;
        HashMap<Character, Integer> map = new HashMap();

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {

            char c = array[windowEnd];
            map.put(c, map.getOrDefault(c, 0) + 1);

            //shrink
            while (map.size() > k) {
                char cc = array[windowStart];
                map.put(cc, map.get(cc) - 1);

                if (map.get(cc) == 0) {
                    map.remove(cc);
                }
                windowStart++;
            }

            longest = Math.max(longest, windowEnd - windowStart + 1);
        }
        return longest ;
    }
}
