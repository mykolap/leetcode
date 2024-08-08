package leetcode;

/**
 * 885. Spiral Matrix III
 * <a href="https://leetcode.com/problems/spiral-matrix-iii">Web link</a>
 * Medium
 */

public class Solution00885 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int len = rows * cols;
        int[][] result = new int[len][2];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int r = rStart;
        int c = cStart;
        int steps = 1;
        int i = 0;
        int added = 0;

        while (added < len) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < steps; k++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[added][0] = r;
                        result[added][1] = c;
                        added++;
                    }
                    r += direction[i][0];
                    c += direction[i][1];
                }
                i = (i + 1) % 4;
            }
            steps++;
        }
        return result;
    }

}