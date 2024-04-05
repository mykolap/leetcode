package leetcode;

/**
 * 3097. Shortest Subarray With OR at Least K II
 * https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/
 * Medium
 */

public class Solution03097 {

    // The size of the bits array is determined by the maximum number of bits in an integer
    private static final int BITS_ARRAY_SIZE = 32;

    public int minimumSubarrayLength(int[] nums, int k) {
        int arrayLength = nums.length;
        int minimumLength = arrayLength + 1;
        int[] bitCounts = new int[BITS_ARRAY_SIZE];
        int windowStartIndex = 0;

        for (int windowEndIndex = 0; windowEndIndex < arrayLength; windowEndIndex++) {
            updateBitCounts(bitCounts, nums[windowEndIndex], 1); // Add the current number to the window

            // While the OR of the nums in the window is greater than or equal to the k
            while (windowStartIndex <= windowEndIndex && convertBitsToNumber(bitCounts) >= k) {
                // Update the minimum length if the current window size is smaller
                minimumLength = Math.min(minimumLength, windowEndIndex - windowStartIndex + 1);

                // Remove the number at the start of the window
                updateBitCounts(bitCounts, nums[windowStartIndex], -1);
                windowStartIndex++;
            }
        }

        // If no subarray was found that meets the condition, return -1
        return minimumLength != arrayLength + 1 ? minimumLength : -1;
    }

    private void updateBitCounts(int[] bitCounts, int number, int change) {
        // For each bit in the number, if it's set, increment or decrement the corresponding count in the bitCounts array
        for (int bitIndex = 0; bitIndex < BITS_ARRAY_SIZE; bitIndex++) {
            if (((number >> bitIndex) & 1) != 0) {
                bitCounts[bitIndex] += change;
            }
        }
    }

    private int convertBitsToNumber(int[] bitCounts) {
        // Convert the bitCounts array back to a number by setting the corresponding bit for each non-zero count
        int number = 0;
        for (int bitIndex = 0; bitIndex < BITS_ARRAY_SIZE; bitIndex++) {
            if (bitCounts[bitIndex] != 0) {
                number |= 1 << bitIndex;
            }
        }
        return number;
    }

    public int minimumSubarrayLengthOptimized(int[] nums, int k) {
        int currentOrValue = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            currentOrValue = currentOrValue | nums[currentIndex];

            if (currentOrValue >= k) {
                int tempOrValue = nums[currentIndex];
                int previousIndex = currentIndex - 1;

                // If the current number itself is greater than or equal to the k, return 1
                if (nums[currentIndex] >= k) {
                    return 1;
                }

                // Try to find a subarray ending at the current index with OR value greater than or equal to the k
                while (tempOrValue < k) {
                    int newOrValue = tempOrValue | nums[previousIndex];

                    if (newOrValue >= k) {
                        currentOrValue = tempOrValue;
                        minimumLength = Math.min(minimumLength, currentIndex - previousIndex + 1);
                        break;
                    }

                    tempOrValue = newOrValue;
                    previousIndex--;
                }
            }
        }

        // If no subarray was found that meets the condition, return -1
        return minimumLength == Integer.MAX_VALUE ? -1 : minimumLength;
    }

}