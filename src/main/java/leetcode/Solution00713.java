package leetcode;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 * Medium
 */

public class Solution00713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int n = nums.length;
        int result = 0;
        int product = 1;
        int left = 0;

        for (int right = 0; right < n; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            result += right - left + 1;
        }

        return result;
    }

}