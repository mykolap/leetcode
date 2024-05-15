package leetcode;

import java.util.*;

/**
 * 2812. Find the Safest Path in a Grid
 * <a href="https://leetcode.com/problems/find-the-safest-path-in-a-grid">Web link</a>
 * Medium
 */

public class Solution02812 {

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Cell[][] cellGrid = fillDistances(grid);
        return traverseGridCells(cellGrid);
    }

    private Cell[][] fillDistances(List<List<Integer>> grid) {
        int n = grid.size();

        Queue<Cell> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid.get(row).get(col) == 1) {
                    queue.offer(new Cell(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        int dist = 0;

        Cell[][] gridCells = new Cell[n][n];
        while (!queue.isEmpty()) {
            int numToPop = queue.size();
            for (int i = 0; i < numToPop; i++) {
                Cell room = queue.poll();
                final int row = room.row;
                final int col = room.col;

                gridCells[row][col] = new Cell(row, col, dist);

                addCell(gridCells, row + 1, col, queue, visited, dist);
                addCell(gridCells, row - 1, col, queue, visited, dist);
                addCell(gridCells, row, col + 1, queue, visited, dist);
                addCell(gridCells, row, col - 1, queue, visited, dist);
            }
            dist++;
        }
        return gridCells;
    }

    private void addCell(Cell[][] rooms, int row, int col, Queue<Cell> deque, boolean[][] visited, int dist) {
        if (row < 0 || row >= rooms.length ||
            col < 0 || col >= rooms[0].length ||
            visited[row][col]) {
            return;
        }

        deque.offer(new Cell(row, col, dist + 1));
        visited[row][col] = true;
    }

    public int traverseGridCells(Cell[][] gridCells) {
        final Cell zeroCell = gridCells[0][0];
        if (zeroCell == null) {
            return 0;
        }

        int n = gridCells.length;

        boolean[][] visited = new boolean[n][n];
        Queue<Cell> deque = new PriorityQueue<>((a, b) -> b.distance - a.distance);
        deque.offer(zeroCell);
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            Cell cell = deque.poll();
            int row = cell.row;
            int col = cell.col;
            int distance = cell.distance;

            if (row == n - 1 && col == n - 1) {
                return cell.distance;
            }

            visitDirection(gridCells, distance, row, col + 1, visited, deque);
            visitDirection(gridCells, distance, row + 1, col, visited, deque);
            visitDirection(gridCells, distance, row - 1, col, visited, deque);
            visitDirection(gridCells, distance, row, col - 1, visited, deque);
        }

        return 0;
    }

    private static void visitDirection(Cell[][] grid, int distance, int row, int col, boolean[][] visited, Queue<Cell> deque) {
        int n = grid.length;
        if (row < 0 || row >= n ||
            col < 0 || col >= n ||
            visited[row][col]) {
            return;
        }
        deque.offer(new Cell(row, col, Math.min(distance, grid[row][col].distance)));
        visited[row][col] = true;
    }


    private static class Cell {
        private final int row;
        private final int col;
        private final int distance;

        public Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Cell{" +
                   "row=" + row +
                   ", col=" + col +
                   ", distance=" + distance +
                   '}';
        }
    }

    public int maximumSafenessFactorAlternative(List<List<Integer>> grid) {
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int n = grid.size();
        int[][] gridArr = new int[n][n];
        int[][] safety = new int[n][n]; //closest distance to thief
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    gridArr[i][j] = 1;
                    safety[i][j] = 0;
                    queue.add(new int[]{i, j, 0});
                } else {
                    safety[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        if (gridArr[0][0] == 1 || gridArr[n - 1][n - 1] == 1) return 0;
        //bfs from each thief, update the smallest safety for all cells
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            for (int[] dir : directions) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (isValid(nextX, nextY, n) && safety[nextX][nextY] > currSafety + 1) {
                    queue.add(new int[]{nextX, nextY, currSafety + 1});
                    safety[nextX][nextY] = currSafety + 1;
                }
            }
        }
        //bfs from start
        Queue<int[]> path = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));
        path.add(new int[]{0, 0, safety[0][0]});
        gridArr[0][0] = 2;
        while (!path.isEmpty()) {
            int[] curr = path.poll();
            int currX = curr[0];
            int currY = curr[1];
            int currSafety = curr[2];
            if (currX == n - 1 && currY == n - 1) return currSafety;
            for (int[] dir : directions) {
                int nextX = currX + dir[0];
                int nextY = currY + dir[1];
                if (isValid(nextX, nextY, n) && gridArr[nextX][nextY] != 2) {
                    path.add(new int[]{nextX, nextY, Math.min(currSafety, safety[nextX][nextY])});
                    gridArr[nextX][nextY] = 2;
                }
            }
        }
        return 0;
    }

    private boolean isValid(int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n) return false;
        return true;
    }

}