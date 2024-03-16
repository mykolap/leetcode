package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * <a href="https://leetcode.com/problems/contiguous-array">Web link</a> |
 * Medium
 */
public class Solution00525 {

    // Time: O(n)
    // Space: O(n)
    public int findMaxLength(int[] nums) {
        int maxLength = 0;

        int zeroCount = 0;
        int oneCount = 0;

        int n = nums.length;

        // Initialize an array to store the first index where the difference between the count of ones and zeros is a certain value
        int[] firstIndex = new int[2 * n + 1];

        // Fill the array with -1 to indicate that the difference has not been encountered yet
        Arrays.fill(firstIndex, -1);

        // The difference is zero at the start of the array
        firstIndex[n] = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                oneCount++;
            }

            int diff = oneCount - zeroCount;

            // If the difference has not been encountered before, store the current index as the first index where this difference is encountered
            if (firstIndex[diff + n] == -1) {
                firstIndex[diff + n] = i + 1;
            } else {
                // If the difference has been encountered before, calculate the length of the contiguous array from the first occurrence of this difference to the current index
                final int currentLength = i - firstIndex[diff + n] + 1;

                // Update the maximum length if the current length is greater
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        // Return the maximum length of the contiguous array with an equal number of 0 and 1
        return maxLength;
    }

    public int findMaxLengthMap(int[] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        int zeros = 0;
        int ones = 0;
        int maxLen = 0;

        hashmap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            int diff = zeros - ones;

            if (hashmap.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - hashmap.get(diff));
            } else {
                hashmap.put(diff, i);
            }
        }

        return maxLen;
    }

}