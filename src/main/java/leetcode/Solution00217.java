package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * 217. Contains Duplicate
 * Easy
 */
public class Solution00217 {

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

}
