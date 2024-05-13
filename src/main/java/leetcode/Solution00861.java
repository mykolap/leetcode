package leetcode;

/**
 * 861. Score After Flipping Matrix
 * https://leetcode.com/problems/score-after-flipping-matrix/
 * Medium
 */

public class Solution00861 {

    public int matrixScore(int[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        int score = (1 << (columnCount - 1)) * rowCount;

        for (int j = 1; j < columnCount; j++) {
            int countSameBitsAsFirstInRow = 0;
            for (int i = 0; i < rowCount; i++) {
                if (grid[i][j] == grid[i][0]) {
                    countSameBitsAsFirstInRow++;
                }
            }

            int maxSameBitsInColumn = Math.max(countSameBitsAsFirstInRow, rowCount - countSameBitsAsFirstInRow);
            int columnScore = (1 << (columnCount - j - 1)) * maxSameBitsInColumn;

            score += columnScore;
        }

        return score;
    }

}