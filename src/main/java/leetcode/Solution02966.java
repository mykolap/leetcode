package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/
 * 2966. Divide Array Into Arrays With Max Difference
 * Medium
 * <p>
 * You are given an integer array nums of size n and a positive integer k.
 * <p>
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 * <p>
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,4,8,7,9,3,5,1], k = 2
 * Output: [[1,1,3],[3,4,5],[7,8,9]]
 * Explanation: We can divide the array into the following arrays: [1,1,3], [3,4,5] and [7,8,9].
 * The difference between any two elements in each array is less than or equal to 2.
 * Note that the order of elements is not important.
 * Example 2:
 * <p>
 * Input: nums = [1,3,3,2,7,3], k = 3
 * Output: []
 * Explanation: It is not possible to divide the array satisfying all the conditions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * n is a multiple of 3.
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 */

public class Solution02966 {

    // Time: O(nlogn)
    // Space: O(n)
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i = i + 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            result[i / 3][0] = nums[i];
            result[i / 3][1] = nums[i + 1];
            result[i / 3][2] = nums[i + 2];
        }
        return result;
    }

}