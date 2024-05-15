package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 778. Swim in Rising Water
 * <a href="https://leetcode.com/problems/swim-in-rising-water">Web link</a>
 * Hard
 */

public class Solution00778 {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Cell> deque = new PriorityQueue<>(Comparator.comparingInt(cell -> cell.time));
        deque.offer(new Cell(0, 0, grid[0][0]));
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Cell cell = deque.poll();
            int row = cell.row;
            int col = cell.col;
            int time = cell.time;

            if (row == n - 1 && col == n - 1) {
                return cell.time;
            }

            visitDirection(grid, time, row, col + 1, visited, deque);
            visitDirection(grid, time, row + 1, col, visited, deque);
            visitDirection(grid, time, row - 1, col, visited, deque);
            visitDirection(grid, time, row, col - 1, visited, deque);
        }

        return 0;
    }

    private static void visitDirection(int[][] grid, int time, int row, int col, boolean[][] visited, Queue<Cell> deque) {
        int n = grid.length;
        if (row < 0 || row >= n ||
            col < 0 || col >= n ||
            visited[row][col]) {
            return;
        }
        deque.offer(new Cell(row, col, Math.max(time, grid[row][col])));
        visited[row][col] = true;
    }

    private static class Cell {
        private final int row;
        private final int col;
        private final int time;

        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Cell{" +
                   "row=" + row +
                   ", col=" + col +
                   ", time=" + time +
                   '}';
        }
    }

}