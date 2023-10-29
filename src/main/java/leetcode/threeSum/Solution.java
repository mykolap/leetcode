package leetcode.threeSum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/3sum/
 * 15. 3Sum
 * <p>
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Example 2:
 * <p>
 * Input: nums = [] Output: [] Example 3:
 * <p>
 * Input: nums = [0] Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */
@SuppressWarnings("java:S5960")
public class Solution {

    @Test
    public void testThreeSum1() {
        int[] nums = {-1, 0, 1,
                2, -1, -4};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-1, -1, 2));
        expected.add(List.of(-1, 0, 1));

        assertEquals(expected, new Solution().threeSumBrutforce(nums));
        assertEquals(expected, new Solution().threeSum(nums));
    }

    // Time: O(n^3)
    // Space: O(1)
    public List<List<Integer>> threeSumBrutforce(int[] nums) {
        // Create a list to store the result.
        List<List<Integer>> result = new ArrayList<>();

        // Check for invalid inputs.
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Iterate over the array.
        for (int i = 0; i < nums.length - 2; i++) {
            // Get the current element.
            int currentElement = nums[i];

            // Iterate over the array.
            for (int j = i + 1; j < nums.length - 1; j++) {
                // Get the current element.
                int currentElement2 = nums[j];

                // Iterate over the array.
                for (int k = j + 1; k < nums.length; k++) {
                    // Get the current element.
                    int currentElement3 = nums[k];

                    // Check if the sum is equal to zero.
                    if (currentElement + currentElement2 + currentElement3 == 0) {
                        // Create a list to store the triplet.
                        List<Integer> triplet = new ArrayList<>();

                        // Add the elements to the triplet.
                        triplet.add(currentElement);
                        triplet.add(currentElement2);
                        triplet.add(currentElement3);

                        // Add the triplet to the result.
                        result.add(triplet);
                    }
                }
            }
        }

        return result;
    }

    // Time: O(n^2)
    // Space: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        // Create a list to store the result.
        List<List<Integer>> result = new ArrayList<>();

        // Check for invalid inputs.
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array.
        Arrays.sort(nums);

        // Iterate over the array.
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Get the current element.
            int currentElement = nums[i];

            // Get the left and right pointers.
            int left = i + 1;
            int right = nums.length - 1;

            // Iterate over the array.
            while (left < right) {
                // Get the sum of the three elements.
                int sum = currentElement + nums[left] + nums[right];

                // Check if the sum is equal to zero.
                if (sum == 0) {
                    // Add the triplet to the result.
                    result.add(List.of(currentElement, nums[left], nums[right]));

                    // Skip duplicates.
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates.
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move the left and right pointers.
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Move the left pointer.
                    left++;
                } else {
                    // Move the right pointer.
                    right--;
                }
            }
        }

        return result;
    }

    @Test
    public void testThreeSum2() {
        int[] nums = {0, 1, 1};

        List<List<Integer>> expected = new ArrayList<>();

        assertEquals(expected, new Solution().threeSumBrutforce(nums));
        assertEquals(expected, new Solution().threeSum(nums));
    }

    @Test
    public void testThreeSum3() {
        int[] nums = {0, 0, 0};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 0, 0));

        assertEquals(expected, new Solution().threeSumBrutforce(nums));
        assertEquals(expected, new Solution().threeSum(nums));
    }

    @Test
    public void testThreeSum4() {
        int[] nums = {-4, 2, 2};

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(-4, 2, 2));

        assertEquals(expected, new Solution().threeSumBrutforce(nums));
        assertEquals(expected, new Solution().threeSum(nums));
    }

}
