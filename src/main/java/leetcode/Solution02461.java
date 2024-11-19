/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K
 * <a href="https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution02461 {

    public long maximumSubarraySum(int[] nums, int k) {
        long result = 0L;
        int n = nums.length;
        if (n < k) {
            return result;
        }
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long currentSum = 0L;
        while (right < n) {
            currentSum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            final int diff = right - left;
            if (diff == k) {
                if (map.size() == k) {
                    result = Math.max(result, currentSum);
                }
                int newValue = map.getOrDefault(nums[left], 0) - 1;
                if (newValue > 0) {
                    map.put(nums[left], newValue);
                } else {
                    map.remove(nums[left]);
                }
                currentSum -= nums[left];
                left++;
            }
        }
        return result;
    }

}