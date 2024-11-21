/**
 * 2257. Count Unguarded Cells in the Grid
 * <a href="https://leetcode.com/problems/count-unguarded-cells-in-the-grid">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02257 {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] board = new char[m][n];

        for (int[] wall : walls) {
            board[wall[0]][wall[1]] = 'W';
        }
        for (int[] guard : guards) {
            board[guard[0]][guard[1]] = 'G';
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    //RIGHT
                    for (int k = j + 1; k < n; k++) {
                        if (board[i][k] == 'W' || board[i][k] == 'G') {
                            break;
                        }
                        board[i][k] = 'V';
                    }
                    // LEFT
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'W' || board[i][k] == 'G') {
                            break;
                        }
                        board[i][k] = 'V';
                    }
                    // DOWN
                    for (int k = i + 1; k < m; k++) {
                        if (board[k][j] == 'W' || board[k][j] == 'G') {
                            break;
                        }
                        board[k][j] = 'V';
                    }
                    // UP
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'W' || board[k][j] == 'G') {
                            break;
                        }
                        board[k][j] = 'V';
                    }
                }
            }
        }

        int count = 0;
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}