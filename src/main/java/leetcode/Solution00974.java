package leetcode;

import java.util.HashMap;

/**
 * 974. Subarray Sums Divisible by K
 * <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k/">Web link</a> |
 * Medium
 */

public class Solution00974 {

    public int subarraysDivByK(int[] nums, int k) {
        // Initialize the cumulative sum of the array elements
        int cumulativeSum = 0;

        // Initialize the count of subarrays divisible by K
        int subarrayCount = 0;

        // Create a map to store the frequency of remainders
        var remainderFrequencyMap = new HashMap<Integer, Integer>();

        // Add the initial condition to the map
        remainderFrequencyMap.put(0, 1);

        // Iterate over the array
        for (int num : nums) {
            // Update the cumulative sum
            cumulativeSum += num;

            // Calculate the remainder of the cumulative sum divided by K
            int remainder = cumulativeSum % k;
            if (remainder < 0) {
                remainder += k; // Handle negative remainders
            }

            // Get the frequency of the current remainder from the map
            int remainderFrequency = remainderFrequencyMap.getOrDefault(remainder, 0);

            // Add the frequency of the current remainder to the count of subarrays
            subarrayCount += remainderFrequency;

            // Update the frequency of the current remainder in the map
            remainderFrequencyMap.put(remainder, remainderFrequency + 1);
        }

        // Return the count of subarrays divisible by K
        return subarrayCount;
    }

}