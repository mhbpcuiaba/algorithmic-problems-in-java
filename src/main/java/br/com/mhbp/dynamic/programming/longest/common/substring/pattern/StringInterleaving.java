package br.com.mhbp.dynamic.programming.longest.common.substring.pattern;

import java.util.HashMap;
import java.util.Map;

public class StringInterleaving {

    /*
    Problem Statement #
Give three strings ‘m’, ‘n’, and ‘p’, write a method to find out if ‘p’ has been formed by interleaving ‘m’ and ‘n’. ‘p’ would be considered interleaving ‘m’ and ‘n’ if it contains all the letters from ‘m’ and ‘n’ and the order of letters is preserved too.

Example 1:

Input: m="abd", n="cef", p="abcdef"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.
Example 2:

Input: m="abd", n="cef", p="adcbef"
Output: false
Explanation: 'p' contains all the letters from 'm' and 'n' but does not preserve the order.
Example 3:

Input: m="abc", n="def", p="abdccf"
Output: false
Explanation: 'p' does not contain all the letters from 'm' and 'n'.
Example 4:

Input: m="abcdef", n="mnop", p="mnaobcdepf"
Output: true
Explanation: 'p' contains all the letters from 'm' and 'n' and preserves their order too.
Basic Solution #
The problem follows the Longest Common Subsequence (LCS) pattern and has some similarities with Subsequence Pattern Matching.

A basic brute-force solution could be to try matching ‘m’ and ‘n’ with ‘p’ one letter at a time. Let’s assume mIndex, nIndex, and pIndex represent the current indexes of ‘m’, ‘n’, and ‘p’ strings respectively. Therefore, we have two options at any step:

If the letter at mIndex matches with the letter at pIndex, we can recursively match for the remaining lengths of ‘m’ and ‘p’.
If the letter at nIndex matches with the letter at ‘pIndex’, we can recursively match for the remaining lengths of ‘n’ and ‘p’.
     */

    public Boolean findSI(String m, String n, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return findSIRecursive(dp, m, n, p, 0, 0, 0);
    }

    private boolean findSIRecursive(Map<String, Boolean> dp, String m, String n, String p,
                                    int mIndex, int nIndex, int pIndex) {

        // if we have reached the end of the all the strings
        if(mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
        if(pIndex == p.length())
            return false;

        String subProblemKey = mIndex + "-" + nIndex + "-" + pIndex;
        if(!dp.containsKey(subProblemKey)) {
            boolean b1=false, b2=false;
            if(mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
                b1 = findSIRecursive(dp, m, n, p, mIndex+1, nIndex, pIndex+1);

            if(nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
                b2 = findSIRecursive(dp, m, n, p, mIndex, nIndex+1, pIndex+1);

            dp.put(subProblemKey, b1 || b2);
        }

        return dp.get(subProblemKey);
    }

    public Boolean findSIBottomUp(String m, String n, String p) {
        // dp[mIndex][nIndex] will be storing the result of string interleaving
        // up to p[0..mIndex+nIndex-1]
        boolean[][] dp = new boolean[m.length()+1][n.length()+1];

        // make sure if lengths of the strings add up
        if(m.length() + n.length() != p.length())
            return false;

        for(int mIndex=0; mIndex<=m.length(); mIndex++) {
            for(int nIndex=0; nIndex<=n.length(); nIndex++) {
                // if 'm' and 'n' are empty, then 'p' must have been empty too.
                if(mIndex==0 && nIndex==0)
                    dp[mIndex][nIndex] = true;
                    // if 'm' is empty, we need to check the interleaving with 'n' only
                else if (mIndex==0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
                    dp[mIndex][nIndex] = dp[mIndex][nIndex-1];
                    // if 'n' is empty, we need to check the interleaving with 'm' only
                else if (nIndex==0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
                    dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
                else {
                    // if the letter of 'm' and 'p' match, we take whatever is matched till mIndex-1
                    if(mIndex > 0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
                        dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
                    // if the letter of 'n' and 'p' match, we take whatever is matched till nIndex-1 too
                    // note the '|=', this is required when we have common letters
                    if(nIndex > 0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
                        dp[mIndex][nIndex] |= dp[mIndex][nIndex-1];
                }
            }
        }
        return dp[m.length()][n.length()];
    }

    public static void main(String[] args) {
        StringInterleaving si = new StringInterleaving();
        System.out.println(si.findSI("abd", "cef", "abcdef"));
        System.out.println(si.findSI("abd", "cef", "adcbef"));
        System.out.println(si.findSI("abc", "def", "abdccf"));
        System.out.println(si.findSI("abcdef", "mnop", "mnaobcdepf"));
    }
}
