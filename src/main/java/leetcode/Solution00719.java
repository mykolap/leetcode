package leetcode;

import java.util.Arrays;

/**
 * 719. Find K-th Smallest Pair Distance
 * <a href="https://leetcode.com/problems/find-k-th-smallest-pair-distance">Web link</a>
 * Hard
 */
public class Solution00719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (totalPairsWithDiffLessThanCandidate(mid, nums) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int totalPairsWithDiffLessThanCandidate(int candidate, int[] nums) {
        int n = nums.length;
        int total = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            while (nums[right] - nums[left] > candidate) {
                ++left;
            }
            total += (right - left);
            right++;
        }
        return total;
    }

}
