package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * <a href="https://leetcode.com/problems/continuous-subarray-sum">Web link</a> |
 * Medium
 */

public class Solution00523 {

    public boolean checkSubarraySumBruteforce(int[] nums, int k) {
        final int len = nums.length;
        if (len < 2) {
            return false;
        }
        int[] prefixSums = new int[len];
        prefixSums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
            if (prefixSums[i] == 0) {
                return true;
            }
            if (prefixSums[i] % k == 0) {
                return true;
            }
        }
        int start = 1;
        while (start < len) {
            int valueToSubtract = prefixSums[start - 1];
            prefixSums[start] -= valueToSubtract;
            for (int i = start + 1; i < len; i++) {
                prefixSums[i] -= valueToSubtract;
                if (prefixSums[i] == 0) {
                    return true;
                }
                if (prefixSums[i] % k == 0) {
                    return true;
                }
            }
            start++;
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        final int len = nums.length;
        if (len < 2) {
            return false;
        }

        Map<Integer, Integer> reminderMap = new HashMap<>();
        reminderMap.put(0, -1);
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
            int reminder = sum % k;

            final Integer existingIndex = reminderMap.get(reminder);
            if (existingIndex == null) {
                reminderMap.put(reminder, i);
            } else {
                if (i - existingIndex > 1) {
                    return true;
                }
            }
        }

        return false;
    }


}