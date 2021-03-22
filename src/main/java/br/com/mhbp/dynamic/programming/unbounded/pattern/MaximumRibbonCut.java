package br.com.mhbp.dynamic.programming.unbounded.pattern;

public class MaximumRibbonCut {

    /*
    We are given a ribbon of length ‘n’ and a set of possible ribbon lengths. We need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths. Write a method that will return the count of pieces.

    ex1
n: 5
Ribbon Lengths: {2,3,5}
Output: 2
Explanation: Ribbon pieces will be {2,3}.

ex2

n: 7
Ribbon Lengths: {2,3}
Output: 3
Explanation: Ribbon pieces will be {2,2,3}.


ex3

n: 13
Ribbon Lengths: {3,5,7}
Output: 3
Explanation: Ribbon pieces will be {3,3,7}.


Given a number array to represent possible ribbon lengths and a total ribbon length ‘n,’ we need to find the maximum number of pieces that the ribbon can be cut into.

This problem follows the Unbounded Knapsack pattern and is quite similar to Minimum Coin Change (MCC). The only difference is that in MCC, we were asked to find the minimum number of coin changes, whereas, in this problem, we need to find the maximum number of pieces.


     */

    public int countRibbonPieces(int[] ribbonLengths, int total)
    {
        int n = ribbonLengths.length;
        int[][] dp = new int[n][total + 1];

        for(int i=0; i < n; i++)
            for(int j=0; j <= total; j++)
                dp[i][j] = Integer.MIN_VALUE;

        // populate the total=0 columns, as we don't need any ribbon to make zero total
        for(int i=0; i < n; i++)
            dp[i][0] = 0;

        for(int i=0; i < n; i++) {
            for(int t=1; t <= total; t++) {
                if(i > 0) //exclude the ribbon
                    dp[i][t] = dp[i-1][t];
                // include the ribbon and check if the remaining length can be cut into available lengths
                if(t >= ribbonLengths[i] && dp[i][t-ribbonLengths[i]] != Integer.MIN_VALUE)
                    dp[i][t] = Math.max(dp[i][t], dp[i][t-ribbonLengths[i]]+1);
            }
        }

        // total combinations will be at the bottom-right corner, return '-1' if cutting is not possible
        return (dp[n-1][total] == Integer.MIN_VALUE ? -1 : dp[n-1][total]);
    }

    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        ribbonLengths = new int[]{5,3,7};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
