package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 * 2971. Find Polygon With the Largest Perimeter
 * Medium
 */

public class Solution02971 {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long result = -1;
        long total = 0;
        for (int num : nums) {
            if (total > num) {
                result = total + num;
            }
            total += num;
        }
        return result;
    }

}