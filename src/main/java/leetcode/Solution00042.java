package leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 42. Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <p>
 * Example 1:
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6 Explanation: The above elevation map (black
 * section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
 * (blue section) are being trapped. Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5] Output: 9
 * <p>
 * Constraints:
 * <p>
 * n == height.length 0 <= n <= 3 * 104 0 <= height[i] <= 105
 */
public class Solution00042 {

    // Time: O(n)
    // Space: O(1)
    public int trap(int[] height) {
        int result = 0;

        // Create two pointers.
        int left = 0;
        int right = height.length - 1;

        // Create two variables to keep track of the max height on the left and right.
        int leftMax = 0;
        int rightMax = 0;

        // Loop through the array.
        while (left < right) {
            // If the height on the left is less than the height on the right.
            if (height[left] < height[right]) {
                // If the height on the left is greater than the max height on the left.
                if (height[left] >= leftMax) {
                    // Update the max height on the left.
                    leftMax = height[left];
                } else {
                    // Add the water.
                    result += leftMax - height[left];
                }
                // Increment the left pointer.
                left++;
            } else {
                // If the height on the right is greater than the max height on the right.
                if (height[right] >= rightMax) {
                    // Update the max height on the right.
                    rightMax = height[right];
                } else {
                    // Add the water.
                    result += rightMax - height[right];
                }
                // Decrement the right pointer.
                right--;
            }
        }

        return result;
    }

    // Time: O(n ^ 2)
    // Space: O(1)
    public int trapBruteForce(int[] height) {
        int result = 0;

        // Loop through the array.
        for (int i = 0; i < height.length; i++) {
            // Find the max height on the left.
            int leftMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the max height on the right.
            int rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Add the water.
            result += Math.min(leftMax, rightMax) - height[i];
        }

        return result;
    }

}
