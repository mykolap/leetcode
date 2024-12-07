/**
 * 1760. Minimum Limit of Balls in a Bag
 * <a href="https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.Arrays;

public class Solution01760 {

    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        int ans = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int ops = 0;

            for (int n : nums) {
                ops += (n - 1) / mid;
                if (ops > maxOperations) {
                    break;
                }
            }

            if (ops <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

}