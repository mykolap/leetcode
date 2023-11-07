package leetcode.largestRectangleInHistogram;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 84. Largest Rectangle in Histogram
 * <p>
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: heights = [2,1,5,6,2,3] Output: 10 Explanation: The above is a histogram where width of each bar is 1. The
 * largest rectangle is shown in the red area, which has an area = 10 units. Example 2:
 * <p>
 * <p>
 * Input: heights = [2,4] Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= heights.length <= 105 0 <= heights[i] <= 104
 */
public class Solution {

    @Test
    public void testLargestRectangleInHistogram() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        assertEquals(10, largestRectangleArea(heights));
        assertEquals(10, largestRectangleAreaBruteForce(heights));

        int[] heights2 = {2, 4};
        assertEquals(4, largestRectangleArea(heights2));
        assertEquals(4, largestRectangleAreaBruteForce(heights2));

        int[] heights3 = {1};
        assertEquals(1, largestRectangleArea(heights3));
        assertEquals(1, largestRectangleAreaBruteForce(heights3));

        int[] heights4 = {1, 1};
        assertEquals(2, largestRectangleArea(heights4));
        assertEquals(2, largestRectangleAreaBruteForce(heights4));

        int[] heights5 = {2, 1, 2};
        assertEquals(3, largestRectangleArea(heights5));
        assertEquals(3, largestRectangleAreaBruteForce(heights5));
    }

    // Time: O(n)
    // Space: O(n)
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new LinkedList<>(); // Store the indexes

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                maxArea = Math.max(maxArea, getArea(heights, stack, i));
            }
            stack.push(i);
        }

        // Clear the remaining elements in the stack
        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, getArea(heights, stack, heights.length));
        }

        return maxArea;
    }

    // Time: O(n^2)
    // Space: O(1)
    private int largestRectangleAreaBruteForce(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = heights[i];
            maxArea = Math.max(maxArea, minHeight);
            for (int j = i + 1; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                int area = minHeight * (j - i + 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    private static int getArea(int[] heights, Deque<Integer> stack, int positionEnd) {
        // While the stack is not empty and the current height is less than or equal to the previous height
        final int indexFromStack = stack.pop();
        int height = heights[indexFromStack];  // Get the height at the index from the stack
        // Calculate the width of the rectangle:
        final int width;
        if (stack.isEmpty()) {
            // current height is the smallest height, so the width is full length until current position
            width = positionEnd;
        } else {
            width = positionEnd - stack.peek() - 1;
        }
        return height * width;
    }

}
