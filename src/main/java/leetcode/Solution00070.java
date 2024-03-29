package leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 *
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 *
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step

 * Constraints:
 *
 * 1 <= n <= 45
 */
public class Solution00070 {

    // Time: O(n)
    // Space: O(1)
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int tmp = first;
            first = second;
            second = second + tmp;
        }

        return second;
    }

    // Time: O(n)
    // Space: O(n)
    public int climbStairsFirstApproach(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        // base cases
        dp[1] = 1;
        dp[2] = 2;

        // recursive cases
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }

}
