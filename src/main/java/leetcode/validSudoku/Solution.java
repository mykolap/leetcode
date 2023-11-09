package leetcode.validSudoku;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 36. Valid Sudoku
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * <p>
 * 1. A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * 2. Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Example 1:
 * <p>
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * <p>
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class Solution {

    // Time: O(n^2)
    // Space: O(n)
    public boolean isValidSudoku(char[][] board) {
        // Check for rows.
        for (int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int index = current - '1';
                    if (visited[index]) {
                        return false;
                    }
                    visited[index] = true;
                }
            }
        }

        // Check for columns.
        for (int j = 0; j < 9; j++) {
            boolean[] visited = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char current = board[i][j];
                if (current != '.') {
                    int index = current - '1';
                    if (visited[index]) {
                        return false;
                    }
                    visited[index] = true;
                }
            }
        }

        // Check for sub-boxes.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] visited = new boolean[9];
                int shiftI = i * 3;
                int shiftJ = j * 3;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char current = board[shiftI + k][shiftJ + l];
                        if (current != '.') {
                            int index = current - '1';
                            if (visited[index]) {
                                return false;
                            }
                            visited[index] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

}
