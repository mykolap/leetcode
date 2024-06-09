package leetcode;

import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">Web link</a> |
 * Medium
 */

public class Solution00560 {

    public int subarraySum(int[] nums, int k) {
        // Initialize the count of subarrays and the cumulative sum
        int subarrayCount = 0;
        int cumulativeSum = 0;

        // Create a map to store the cumulative sum frequencies
        var cumulativeSumFrequencies = new HashMap<Integer, Integer>();

        // Add the initial condition to the map
        cumulativeSumFrequencies.put(0, 1);

        // Iterate over the array
        for (int num : nums) {
            // Update the cumulative sum
            cumulativeSum += num;

            // Check if there is a subarray sum that when subtracted from the current cumulative sum results in k
            // If it exists, add the frequency of this sum to the count
            subarrayCount += cumulativeSumFrequencies.getOrDefault(cumulativeSum - k, 0);

            // Update the frequency of the current cumulative sum
            cumulativeSumFrequencies.put(cumulativeSum, cumulativeSumFrequencies.getOrDefault(cumulativeSum, 0) + 1);
        }

        // Return the count of subarrays
        return subarrayCount;
    }

}