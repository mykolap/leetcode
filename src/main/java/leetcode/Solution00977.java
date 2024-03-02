package leetcode;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * Easy
 */

public class Solution00977 {

    // Time: O(n)
    // Space: O(n)
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int leftSquare = nums[left] * nums[left];
        int rightSquare = nums[right] * nums[right];

        for (int i = n - 1; i > 0; i--) {
            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
                leftSquare = nums[left] * nums[left];
            } else {
                result[i] = rightSquare;
                right--;
                rightSquare = nums[right] * nums[right];
            }
        }
        result[0] = leftSquare;

        return result;
    }

}