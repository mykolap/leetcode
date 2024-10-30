/**
 * 1671. Minimum Number of Removals to Make Mountain Array
 * <a href="https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array">Web link</a> |
 * Hard
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution01671 {

    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        List<Integer> lis = lisLength(nums);

        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        List<Integer> lds = lisLength(reversed);
        Collections.reverse(lds);

        int removals = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (lis.get(i) > 1 && lds.get(i) > 1) {
                removals = Math.min(removals, n + 1 - lis.get(i) - lds.get(i));
            }
        }

        return removals;
    }

    private List<Integer> lisLength(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        List<Integer> lisLen = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            lisLen.add(1);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis.getLast()) {
                lis.add(nums[i]);
            } else {
                int index = Collections.binarySearch(lis, nums[i]);
                if (index < 0) {
                    index = -(index + 1);
                }
                lis.set(index, nums[i]);
            }
            lisLen.set(i, lis.size());
        }
        return lisLen;
    }

    public int minimumMountainRemovalsDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
        }
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j] && 1 + dp2[j] > dp2[i]) {
                    dp2[i] = 1 + dp2[j];
                }
            }
        }
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > 1 && dp2[i] > 1)
                maxi = Math.max(maxi, dp[i] + dp2[i] - 1);
        }
        return nums.length - maxi;
    }

}