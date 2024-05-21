package leetcode;

import java.util.Arrays;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/description/
 * Easy
 */

public class Solution00035 {

    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos >= 0 ? pos : -pos - 1;
    }

}