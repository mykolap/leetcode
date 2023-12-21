package leetcode.minCostClimbingStairs;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 * 746. Min Cost Climbing Stairs
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost,
 * you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class Solution0746 {

    // Time: O(n)
    // Space: O(1)
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int tmp = first;
            first = second;
            second = Math.min(tmp, second) + cost[i];
        }

        return Math.min(first, second);
    }

    // Time: O(n)
    // Space: O(n)
    public int minCostClimbingStairsFirstApproach(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

}
