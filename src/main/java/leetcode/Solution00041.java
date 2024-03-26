package leetcode;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * Hard
 */

public class Solution00041 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int outOfRange = n + 1;

        // Replace all negative numbers and zeros with outOfRange to allow using them as carrier, but ignore as candidates for solution
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = outOfRange;
            }
        }

        // Mark all positive numbers by changing the sign of the number at the index equal to the number, but ignore out of range numbers
        for (int i = 0; i < n; i++) {
            var indexOfNegative = Math.abs(nums[i]) - 1;
            if (indexOfNegative >= 0 &&
                indexOfNegative < n &&
                nums[indexOfNegative] > 0) {
                nums[indexOfNegative] = -nums[indexOfNegative];
            }
        }

        // Find the first positive number, which is the first one that was not marked, because it's index - +1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

}