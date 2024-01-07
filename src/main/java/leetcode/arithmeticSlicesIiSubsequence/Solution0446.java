package leetcode.arithmeticSlicesIiSubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 * 446. Arithmetic Slices II - Subsequence
 * Hard
 * Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The answer is guaranteed to fit in 32-bit integer.
 * Example 1:
 * Input: nums = [2,4,6,8,10]
 * Output: 7
 * Explanation: All arithmetic subsequence slices are:
 * [2,4,6]
 * [4,6,8]
 * [6,8,10]
 * [2,4,6,8]
 * [4,6,8,10]
 * [2,4,6,8,10]
 * [2,6,10]
 * Example 2:
 * Input: nums = [7,7,7,7,7]
 * Output: 16
 * Explanation: Any subsequence of this array is arithmetic.
 * Constraints:
 * 1  <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 */
public class Solution0446 {

    // Time: O(n^2)
    // Space: O(n^2)
    public int numberOfArithmeticSlices(int[] nums) {
        int result = 0;
        int n = nums.length;
        Map<Integer, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                }

                int d = (int) diff;
                int c1 = dp[i].getOrDefault(d, 0);
                int c2 = dp[j].getOrDefault(d, 0);
                result += c2;
                dp[i].put(d, c1 + c2 + 1);
            }
        }

        return result;
    }

}