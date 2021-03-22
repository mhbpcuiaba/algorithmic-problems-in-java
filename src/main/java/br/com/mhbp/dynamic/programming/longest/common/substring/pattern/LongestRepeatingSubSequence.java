package br.com.mhbp.dynamic.programming.longest.common.substring.pattern;

public class LongestRepeatingSubSequence {

    /*
    Problem Statement #
Given a sequence, find the length of its longest repeating subsequence (LRS). A repeating subsequence will be the one that appears at least twice in the original sequence and is not overlapping (i.e. none of the corresponding characters in the repeating subsequences have the same index).

Example 1:

Input: “t o m o r r o w”
Output: 2
Explanation: The longest repeating subsequence is “or” {tomorrow}.

Example 2:

Input: “a a b d b c e c”
Output: 3
Explanation: The longest repeating subsequence is “a b c” {a a b d b c e c}.

Example 3:

Input: “f m f f”
Output: 2
Explanation: The longest repeating subsequence is “f f” {f m f f, f m f f}. Please note the second last character is shared in LRS.

Basic Solution #
The problem is quite similar to the Longest Common Subsequence (LCS), with two differences:

In LCS, we were trying to find the longest common subsequence between the two strings, whereas in LRS we are trying to find the two longest common subsequences within one string.
In LRS, every corresponding character in the subsequences should not have the same index.
A basic brute-force solution could be to try all subsequences of the given sequence to find the longest repeating one, but the problem is how to ensure that the LRS’s characters do not have the same index. For this, we can start with two indexes in the given sequence, so at any step we have two choices:

If the two indexes are not the same and the characters at both the indexes are same, we can recursively match for the remaining length (i.e. by incrementing both the indexes).
If the characters at both the indexes don’t match, we start two new recursive calls by incrementing each index separately. The LRS would be the one with the highest length from the two recursive calls.
     */

    public int findLRSLength(String str) {
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLRSLengthRecursive(dp, str, 0, 0);
    }

    private int findLRSLengthRecursive(Integer[][] dp, String str, int i1, int i2) {
        if(i1 == str.length() || i2 == str.length())
            return 0;

        if(dp[i1][i2] == null) {
            if(i1 != i2 && str.charAt(i1) == str.charAt(i2))
                dp[i1][i2] = 1 + findLRSLengthRecursive(dp, str, i1+1, i2+1);
            else {
                int c1 = findLRSLengthRecursive(dp, str, i1, i2+1);
                int c2 = findLRSLengthRecursive(dp, str, i1+1, i2);
                dp[i1][i2] = Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    public static void main(String[] args) {
        LongestRepeatingSubSequence lrs = new LongestRepeatingSubSequence();
        System.out.println(lrs.findLRSLength("tomorrow"));
        System.out.println(lrs.findLRSLength("aabdbcec"));
        System.out.println(lrs.findLRSLength("fmff"));
    }

    public int findLRSLengthBottomUp(String str) {
        int[][] dp = new int[str.length()+1][str.length()+1];
        int maxLength = 0;
        // dp[i1][i2] will be storing the LRS up to str[0..i1-1][0..i2-1]
        // this also means that subsequences of length zero (first row and column of dp[][]),
        // will always have LRS of size zero.
        for(int i1=1; i1 <= str.length(); i1++) {
            for(int i2=1; i2 <= str.length(); i2++) {
                if(i1 != i2 && str.charAt(i1-1) == str.charAt(i2-1))
                    dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);

                maxLength = Math.max(maxLength, dp[i1][i2]);
            }
        }
        return maxLength;
    }
}
