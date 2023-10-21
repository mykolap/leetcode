package leetcode.twoSums;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class Solution {

    @Test
    void testTwoSum_True1() {
        int[] nums = {2, 11, 7, 15};
        int target = 9;

        int[] result = twoSumBruteForce(nums, target);

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);

        result = twoSum(nums, target);

        assertEquals(0, result[0]);
        assertEquals(2, result[1]);
    }

    // Time: O(n^2)
    // Space: O(1)
    public int[] twoSumBruteForce(int[] nums, int target) {
        // It is guaranteed that array has at least two elements.

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                if (current + next == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    // Time: O(n)
    // Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // current + complement = target
            int complement = target - current;
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            } else {
                map.put(current, i);
            }
        }
        return new int[] {};
    }

    @Test
    void testTwoSum_False2() {
        int[] nums = {2, 8, 11, 15};
        int target = 9;

        int[] result = twoSumBruteForce(nums, target);

        assertEquals(0, result.length);

        result = twoSum(nums, target);

        assertEquals(0, result.length);
    }

    @Test
    void testTwoSum_True3() {
        int[] nums = {3, 3};
        int target = 6;

        int[] result = twoSumBruteForce(nums, target);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);

        result = twoSum(nums, target);

        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void testTwoSum_False4() {
        int[] nums = {3, 4};
        int target = 6;

        int[] result = twoSumBruteForce(nums, target);

        assertEquals(0, result.length);

        result = twoSum(nums, target);

        assertEquals(0, result.length);
    }

}
