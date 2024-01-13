package leetcode;

import java.util.Deque;
import java.util.LinkedList;

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
public class Solution00084 {

    // Time: O(n)
    // Space: O(n)
    public int largestRectangleArea(int[] heights) {
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
    public int largestRectangleAreaBruteForce(int[] heights) {
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
