package leetcode;

/**
 * 201. Bitwise AND of Numbers Range
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Medium
 */
public class Solution00201 {

    // Time: O(n)
    // Space: O(1)
    public int rangeBitwiseAnd(int left, int right) {
        // Initialize a shift counter
        int shift = 0;

        // Keep shifting the bits of both numbers to the right until they become equal
        // This is done because the bitwise AND of all numbers in the range is just the common prefix of the binary representations of the left and right numbers
        while (left < right) {
            left >>= 1;  // Shift the bits of the left number to the right
            right >>= 1; // Shift the bits of the right number to the right
            shift++;     // Increment the shift counter
        }

        // Once the numbers are equal, shift the bits of the left number to the left by the shift counter
        // This is done to restore the original number of bits in the left number
        return left << shift;
    }

}