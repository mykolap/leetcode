/**
 * 2779. Maximum Beauty of an Array After Applying Operation
 * <a href="https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;

public class Solution02779 {

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int maxBeauty = 0;
        int right = 0;

        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] - nums[left] <= 2 * k) {
                right++;
            }
            maxBeauty = Math.max(maxBeauty, right - left);
        }
        return maxBeauty;
    }

}