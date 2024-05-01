package leetcode;

/**
 * 509. Fibonacci Number
 * <a href="https://leetcode.com/problems/fibonacci-number/">Web link</a> |
 * Easy
 */

public class Solution00509 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}