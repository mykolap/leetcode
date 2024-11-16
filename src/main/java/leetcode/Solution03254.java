/**
 * 3254. Find the Power of K-Size Subarrays I
 * <a href="https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i">Web link</a>
 * Medium
 */

package leetcode;

public class Solution03254 {

    public int[] resultsArray(int[] nums, int k) {
        int count = 0;
        int max = nums[0];
        int resIndex = 0;

        for (int i = 0; i < k - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                max++;
            } else {
                count = i + 1;
                max = nums[i + 1];
            }
        }

        int[] res = new int[nums.length - k + 1];
        if (count > 0) {
            res[resIndex++] = -1;
        } else {
            res[resIndex++] = max;
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                max++;
                count--;
            } else {
                count = k - 1;
                max = nums[i];
            }

            if (count > 0) {
                res[resIndex++] = -1;
            } else {
                res[resIndex++] = max;
            }
        }

        return res;
    }

}