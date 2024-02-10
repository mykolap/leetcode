package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 11. Container With Most Water
 * Medium
 */
public class Solution00011 {

    // Time: O(n)
    // Space: O(1)
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the area.
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            // Move the pointer that is pointing to the smaller height.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    // Time: O(n^2)
    // Space: O(1)
    public int maxAreaBruteForce(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int right = height[j];
                int area = Math.min(left, right) * (j - i);
                max = Math.max(max, area);
            }
        }

        return max;
    }

}