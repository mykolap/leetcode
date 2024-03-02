package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 * 994. Rotting Oranges
 * Medium
 */

public class Solution00994 {

    // Time complexity: O(m*n)
    // Space complexity: O(m*n)
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                final int orangeState = grid[row][col];
                if (orangeState == 1) {
                    fresh++;
                } else if (orangeState == 2) {
                    queue.add(new Pair<>(row, col));
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                int row = pair.getKey();
                int col = pair.getValue();
                if (row > 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add(new Pair<>(row - 1, col));
                    fresh--;
                }
                if (row < grid.length - 1 && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add(new Pair<>(row + 1, col));
                    fresh--;
                }
                if (col > 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(new Pair<>(row, col - 1));
                    fresh--;
                }
                if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(new Pair<>(row, col + 1));
                    fresh--;
                }
            }
            minutes++;
            if (fresh == 0) {
                return minutes;
            }
        }
        return -1;
    }

}