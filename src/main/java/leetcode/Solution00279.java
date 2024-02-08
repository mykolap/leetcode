package leetcode;

/**
 * https://leetcode.com/problems/perfect-squares/
 * 279. Perfect Squares
 * Medium
 */
public class Solution00279 {

    // Time complexity: O(n)
    // Space complexity: O(n)
    public int numSquaresDP(int n) {
        // Initialize dynamic programming array
        int[] dp = new int[n + 1];

        // Iterate through each number up to n
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            // Initially set the minimum number of squares for currentNum to be currentNum itself
            // because square of 1 is 1, we can always get target using squares of 1
            dp[currentNum] = currentNum;

            // Iterate through each square number up to currentNum
            for (int square = 1, squareOfSquare = 1; squareOfSquare <= currentNum; square++, squareOfSquare = square * square) {
                // Calculate the remaining number after subtracting the square number
                int remaining = currentNum - squareOfSquare;

                // Calculate the minimum number of squares for currentNum
                int minSquares = dp[remaining] + 1;

                // Update the minimum number of squares for currentNum
                dp[currentNum] = Math.min(dp[currentNum], minSquares);
            }
        }

        // Return the minimum number of squares for n
        return dp[n];
    }

}