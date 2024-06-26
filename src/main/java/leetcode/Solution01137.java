package leetcode;

/**
 * 1137. N-th Tribonacci Number
 * <a href="https://leetcode.com/problems/n-th-tribonacci-number">Web link</a>
 * Easy
 */

public class Solution01137 {

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

}