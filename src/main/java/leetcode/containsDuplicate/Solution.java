package leetcode.containsDuplicate;

import org.junit.jupiter.api.Test;

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

        assertTrue(new Solution().containsDuplicate(nums));
    }

    @Test
    public void testContainsDuplicateFalse() {
        int[] nums2 = {1,2,3,4};

        assertFalse(new Solution().containsDuplicate(nums2));
    }

}
