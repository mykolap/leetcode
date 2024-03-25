package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * Medium
 */

public class Solution00442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }

}