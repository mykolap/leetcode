package leetcode;

/**
 * 1140. Stone Game II
 * <a href="https://leetcode.com/problems/stone-game-ii">Web link</a>
 * Medium
 */

public class Solution01140 {

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                final int maxSteps = 2 * m;
                if (i + maxSteps >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= maxSteps; x++) {
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

}