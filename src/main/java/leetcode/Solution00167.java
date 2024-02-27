package leetcode;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * <p>
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
 * <p>
 * Input: numbers = [2,3,4], target = 6 Output: [1,3] Example 3:
 * <p>
 * Input: numbers = [-1,0], target = -1 Output: [1,2]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= numbers.length <= 3 * 104 -1000 <= numbers[i] <= 1000 numbers is sorted in non-decreasing order. -1000 <= target <= 1000
 */
public class Solution00167 {

    // Time: O(n^2)
    // Space: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        // Loop through the array.
        for (int i = 0; i < nums.length; i++) {
            // Loop through the array again.
            for (int j = i + 1; j < nums.length; j++) {
                // If the sum of the two numbers is equal to the target, return the indices.
                if (nums[i] + nums[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }

    // Time: O(n)
    // Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        // Create two pointers.
        int left = 0;
        int right = numbers.length - 1;

        // Loop through the array.
        while (left < right) {
            // Get the sum of the two numbers.
            int sum = numbers[left] + numbers[right];

            // If the sum is equal to the target, return the indices.
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            // If the sum is greater than the target, decrement the right pointer.
            if (sum > target) {
                right--;
            } else {
                // If the sum is less than the target, increment the left pointer.
                left++;
            }
        }

        return new int[]{};
    }
}
