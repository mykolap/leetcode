package leetcode.containerWithMostWater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * 11. Container With Most Water
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and
 * (i, 0). Find two lines, which, together with the x-axis forms a container, such that the
 * container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation: The above vertical lines are
 * represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49. Example 2:
 * <p>
 * Input: height = [1,1] Output: 1 Example 3:
 * <p>
 * Input: height = [4,3,2,1,4] Output: 16 Example 4:
 * <p>
 * Input: height = [1,2,1] Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length 2 <= n <= 105 0 <= height[i] <= 104
 */
public class Solution {

    @Test
    public void testContainerWithMostWater() {
        int[] height = {1, 8, 6,
                2, 5, 4, 8, 3, 7};
        assertEquals(49, maxArea(height));
        assertEquals(49, maxAreaBruteForce(height));

        int[] height2 = {1, 1};
        assertEquals(1, maxArea(height2));
        assertEquals(1, maxAreaBruteForce(height2));

        int[] height3 = {4, 3, 2, 1, 4};
        assertEquals(16, maxArea(height3));
        assertEquals(16, maxAreaBruteForce(height3));

        int[] height4 = {1, 2, 1};
        assertEquals(2, maxArea(height4));
        assertEquals(2, maxAreaBruteForce(height4));

        int[] height5 = {1, 2, 4, 3};
        assertEquals(4, maxArea(height5));
        assertEquals(4, maxAreaBruteForce(height5));

        int[] height6 = {1, 2, 1, 2, 1, 2, 1, 2};
        assertEquals(12, maxArea(height6));
        assertEquals(12, maxAreaBruteForce(height6));
    }

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