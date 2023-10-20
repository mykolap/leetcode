package leetcode.containsDuplicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * 217. Contains Duplicate
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
@SuppressWarnings("java:S5960")
public class Solution {

    // Time: O(n^2)
    // Space: O(1)
    public boolean containsDuplicateBrutforce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    // Time: O(n log n)
    // Space: O(1)
    public boolean containsDuplicateSorted(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    // Time: O(n)
    // Space: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void testContainsDuplicateTrue() {
        int[] nums = {1,2,3,1};

        assertTrue(new Solution().containsDuplicateBrutforce(nums));
        assertTrue(new Solution().containsDuplicateSorted(nums));
        assertTrue(new Solution().containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicateFalse() {
        int[] nums2 = {1,2,3,4};

        assertFalse(new Solution().containsDuplicateBrutforce(nums2));
        assertFalse(new Solution().containsDuplicateSorted(nums2));
        assertFalse(new Solution().containsDuplicate(nums2));
    }

}
