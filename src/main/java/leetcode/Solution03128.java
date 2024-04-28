package leetcode;

/**
 * 3128. Right Triangles
 * https://leetcode.com/problems/right-triangles/
 * Medium
 */
public class Solution03128 {

    public long numberOfRightTriangles(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        int[] rowCounts = new int[numRows];
        int[] colCounts = new int[numCols];

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    rowCounts[row]++;
                    colCounts[col]++;
                }
            }
        }

        long count = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == 1) {
                    count += (long) (rowCounts[row] - 1) * (colCounts[col] - 1);
                }
            }
        }

        return count;
    }

}