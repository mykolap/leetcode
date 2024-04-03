package leetcode;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 * Medium
 */

public class Solution00079 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, visited, wordChars, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, char[] wordChars, int i, int j, int index) {
        if (index == wordChars.length) {
            return true;
        }
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            visited[i][j] ||
            board[i][j] != wordChars[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean flag = dfs(board, visited, wordChars, i - 1, j, index + 1)
                       || dfs(board, visited, wordChars, i + 1, j, index + 1)
                       || dfs(board, visited, wordChars, i, j - 1, index + 1)
                       || dfs(board, visited, wordChars, i, j + 1, index + 1);
        visited[i][j] = false;
        return flag;
    }

}