package leetcode;

import java.util.Arrays;

/**
 * 1289. Minimum Falling Path Sum II
 * <a href="https://leetcode.com/problems/minimum-falling-path-sum-ii/">Web link</a> |
 * Hard
 */

public class Solution01289 {

    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[] dp = grid[0];

        for (int i = 1; i < n; i++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int idx1 = -1;

            for (int j = 0; j < n; j++) {
                if (dp[j] < min1) {
                    min2 = min1;
                    min1 = dp[j];
                    idx1 = j;
                } else if (dp[j] < min2) {
                    min2 = dp[j];
                }
            }

            int[] dpNew = new int[n];
            final int[] currentGridLine = grid[i];
            for (int j = 0; j < n; j++) {
                dpNew[j] = currentGridLine[j] + (j == idx1 ? min2 : min1);
            }

            dp = dpNew;
        }

        return Arrays.stream(dp).min().orElse(0);
    }

}