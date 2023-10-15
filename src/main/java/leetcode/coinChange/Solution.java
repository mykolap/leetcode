package leetcode.coinChange;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 * 322. Coin Change
 * <p>
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * <p>
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * <p>
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Example 3:
 * <p>
 * Input: coins = [1], amount = 0
 * Output: 0
 * <p>
 * Example 4:
 * <p>
 * Input: coins = [1], amount = 1
 * Output: 1
 * <p>
 * Example 5:
 * <p>
 * Input: coins = [1], amount = 2
 * Output: 2
 * <p>
 * Constraints:
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Solution {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(new Solution().coinChange(coins, amount));
    }

    // Time: O(n * m)
    // Space: O(n)
    public int coinChange(int[] coins, int amount) {
        // Create a `dp` array to store the minimum number of coins needed to make up to the given amount.
        int[] dp = new int[amount + 1];
        // Fill the `dp` array with the values that is more than the max int value.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // The minimum number of coins needed to make up 0 is 0.

        // Iterate over the possible amounts from 1 to the given amount.
        for (int i = 1; i <= amount; i++) {
            // For each amount, check if any of the coins can be used to make up the amount.
            for (int coin : coins) {
                // If the amount is greater than or equal to the coin
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            // If the minimum number of coins needed to make up the amount is still max value, then there is no solution
            // for the given amount.
            return -1;
        } else {
            // Return the minimum number of coins needed to make up the given amount.
            return dp[amount];
        }
    }

}
