package leetcode;

import java.util.Arrays;

/**
 * 650. 2 Keys Keyboard
 * <a href="https://leetcode.com/problems/2-keys-keyboard">Web link</a>
 * Medium
 */

public class Solution00650 {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < 1 + i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }

}