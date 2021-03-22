package br.com.mhbp.dynamic.programming.longest.common.substring.pattern;

public class EditDistance {

    /*
    Given strings s1 and s2, we need to transform s1 into s2 by deleting, inserting, or replacing characters. Write a function to calculate the count of the minimum number of edit operations.

Example 1:

Input: s1 = "bat"
       s2 = "but"
Output: 1
Explanation: We just need to replace 'a' with 'u' to transform s1 to s2.
Example 2:

Input: s1 = "abdca"
       s2 = "cbda"
Output: 2
Explanation: We can replace first 'a' with 'c' and delete second 'c'.
Example 3:

Input: s1 = "passpot"
       s2 = "ppsspqrt"
Output: 3
Explanation: Replace 'a' with 'p', 'o' with 'q', and insert 'r'.
Basic Solution #
A basic brute-force solution could be to try all operations (one by one) on each character of s1. We can iterate through s1 and s2 together. Let’s assume index1 and index2 point to the current indexes of s1 and s2 respectively, so we have two options at every step:

If the strings have a matching character, we can recursively match for the remaining lengths.
If the strings don’t match, we start three new recursive calls representing the three edit operations. Whichever recursive call returns the minimum count of operations will be our answer.
     */

    public int findMinOperations(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        return findMinOperationsRecursive(dp, s1, s2, 0, 0);
    }

    private int findMinOperationsRecursive(Integer[][] dp, String s1, String s2, int i1, int i2) {

        if(dp[i1][i2] == null) {
            // if we have reached the end of s1, then we have to insert all the remaining characters of s2
            if(i1 == s1.length())
                dp[i1][i2] = s2.length() - i2;

                // if we have reached the end of s2, then we have to delete all the remaining characters of s1
            else if(i2 == s2.length())
                dp[i1][i2] = s1.length() - i1;

                // If the strings have a matching character, we can recursively match for the remaining lengths
            else if(s1.charAt(i1) == s2.charAt(i2))
                dp[i1][i2] = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1);
            else {
                int c1 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2); //delete
                int c2 = findMinOperationsRecursive(dp, s1, s2, i1, i2+1); //insert
                int c3 = findMinOperationsRecursive(dp, s1, s2, i1+1, i2+1); //replace
                dp[i1][i2] = 1 + Math.min(c1, Math.min(c2, c3));
            }
        }

        return dp[i1][i2];
    }

    public int findMinOperationsBottomUp(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // if s2 is empty, we can remove all the characters of s1 to make it empty too
        for(int i1=0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;

        // if s1 is empty, we have to insert all the characters of s2
        for(int i2=0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;

        for(int i1=1; i1 <= s1.length(); i1++) {
            for(int i2=1; i2 <= s2.length(); i2++) {
                // If the strings have a matching character, we can recursively match for the remaining lengths
                if(s1.charAt(i1-1) == s2.charAt(i2-1))
                    dp[i1][i2] = dp[i1-1][i2-1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1-1][i2], //delete
                            Math.min(dp[i1][i2-1], //insert
                                    dp[i1-1][i2-1])); //replace
            }
        }

        return dp[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
        EditDistance editDisatnce = new EditDistance();
        System.out.println(editDisatnce.findMinOperations("bat", "but"));
        System.out.println(editDisatnce.findMinOperations("abdca", "cbda"));
        System.out.println(editDisatnce.findMinOperations("passpot", "ppsspqrt"));
    }
}
