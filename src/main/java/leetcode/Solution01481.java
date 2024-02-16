package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 * 1481. Least Number of Unique Integers after K Removals
 * Medium
 */

public class Solution01481 {

    // Time: O(n)
    // Space: O(n)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Create a frequency map to store the frequency of each number in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        // Iterate over the array and update the frequency map
        for (int number : arr) {
            frequencyMap.merge(number, 1, Integer::sum);
        }

        // Create an array to store the count of frequencies
        int[] frequencyCountArray = new int[arr.length + 1];
        // Iterate over the frequency map and update the frequency count array
        for (int frequency : frequencyMap.values()) {
            frequencyCountArray[frequency]++;
        }

        // Initialize the result with the total number of unique numbers in the array
        int uniqueNumbers = frequencyMap.size();

        // Iterate over the frequency count array
        for (int currentFrequency = 1; currentFrequency < frequencyCountArray.length; currentFrequency++) {
            // Calculate the total count of numbers with the current frequency
            final int totalCountCurrentFrequency = currentFrequency * frequencyCountArray[currentFrequency];
            // If k is greater than or equal to the total count, subtract the total count from k and the count of numbers with the current frequency from the result
            if (k >= totalCountCurrentFrequency) {
                k -= totalCountCurrentFrequency;
                uniqueNumbers -= frequencyCountArray[currentFrequency];
            } else {
                // If k is less than the total count, subtract the number of numbers that can be removed from the result and break the loop
                uniqueNumbers -= k / currentFrequency;
                break;
            }
        }

        // Return the result
        return uniqueNumbers;
    }

}