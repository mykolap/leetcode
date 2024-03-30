package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 992. Subarrays with K Different Integers
 * <a href="https://leetcode.com/problems/subarrays-with-k-different-integers">Web link</a> |
 * Hard
 */

public class Solution00992 {

    public int subarraysWithKDistinctViaAtMost(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int left = 0;
        int totalSubarrays = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            int rightValue = countMap.getOrDefault(nums[right], 0);
            if (rightValue == 0) {
                k--;
            }
            countMap.put(nums[right], rightValue + 1);
            while (k < 0) {
                int newValueLeft = countMap.getOrDefault(nums[left], 0) - 1;
                countMap.put(nums[left], newValueLeft);
                if (newValueLeft == 0) {
                    k++;
                }
                left++;
            }
            totalSubarrays += right - left + 1;
        }
        return totalSubarrays;
    }

    public int subarraysWithKDistinctVia3Pointers(int[] nums, int k) {
        int leftFar = 0;
        int leftNear = 0;
        int totalSubarrays = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int rightValue : nums) {
            countMap.put(rightValue, countMap.getOrDefault(rightValue, 0) + 1);

            while (countMap.size() > k) {
                final int leftNearCount = countMap.get(nums[leftNear]) - 1;
                if (leftNearCount == 0) {
                    countMap.remove(nums[leftNear]);
                } else {
                    countMap.put(nums[leftNear], leftNearCount);
                }
                leftNear++;
                leftFar = leftNear;
            }

            while (countMap.get(nums[leftNear]) > 1) {
                countMap.put(nums[leftNear], countMap.get(nums[leftNear]) - 1);
                leftNear++;
            }

            if (countMap.size() == k) {
                totalSubarrays += leftNear - leftFar + 1;
            }
        }

        return totalSubarrays;
    }

}