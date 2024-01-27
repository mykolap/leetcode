package leetcode;

/**
 * 629. K Inverse Pairs Array
 * https://leetcode.com/problems/k-inverse-pairs-array/description/
 * Medium
 * <p>
 * Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 * <p>
 * We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 * <p>
 * Since the answer may be very large, the answer should be modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3, k = 0
 * Output: 1
 * Explanation:
 * Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 3, k = 1
 * Output: 2
 * Explanation:
 * The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
 * <p>
 * Note:
 * <p>
 * The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 */
public class Solution00629 {

    // Time O(n*k^2)
    // Space O(k)
    public int kInversePairs(int n, int k) {
        // Initialize an array to store the number of permutations with a certain number of inverse pairs
        int[] dp = new int[k + 1];
        dp[0] = 1; // There is one permutation of 0 numbers with 0 inverse pairs

        // Iterate over the array size
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            // Initialize a new array to store the number of permutations for the current size and inverse pairs
            int[] newDp = new int[k + 1];

            // Iterate over the number of inverse pairs
            for (int currentInversePairs = 0; currentInversePairs <= k; currentInversePairs++) {
                // Calculate the range for the inner loop
                final int innerLoopRange = Math.min(currentInversePairs, currentNum - 1);
                long totalPermutations = 0; // Initialize the total permutations for the current size and inverse pairs

                // Iterate over the range and calculate the total permutations
                for (int x = 0; x <= innerLoopRange; x++) {
                    if (currentInversePairs - x >= 0) {
                        totalPermutations += dp[currentInversePairs - x];
                        totalPermutations %= 1000000007; // Modulo operation to prevent overflow
                    }
                }
                newDp[currentInversePairs] = (int) totalPermutations; // Store the total permutations
            }
            dp = newDp; // Update the dp array
        }

        // Return the number of permutations of the given array size with the given number of inverse pairs
        return dp[k];
    }

}