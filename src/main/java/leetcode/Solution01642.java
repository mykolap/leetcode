package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 * 1642. Furthest Building You Can Reach
 * Medium
 */
public class Solution01642 {

    // Time: O(nlogk)
    // Space: O(k)
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Create a priority queue to store the differences in heights
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate over the heights array
        for (int i = 1; i < heights.length; i++) {
            // Calculate the difference in height between the current and previous building
            int diff = heights[i] - heights[i - 1];

            // If the difference is less than or equal to 0, skip the current iteration
            if (diff <= 0) {
                continue;
            }

            // Add the difference to the min heap
            minHeap.add(diff);

            // If the size of the min heap is greater than the number of ladders
            if (minHeap.size() > ladders) {
                // Remove the smallest difference from the min heap and subtract it from the bricks
                bricks -= minHeap.poll();

                // If there are not enough bricks, return the index of the last reachable building
                if (bricks < 0) {
                    return i - 1;
                }
            }
        }

        // If all buildings are reachable, return the index of the last building
        return heights.length - 1;
    }

}