package leetcode;

/**
 * 959. Regions Cut By Slashes
 * <a href="https://leetcode.com/problems/regions-cut-by-slashes">Web link</a>
 * Medium
 */

public class Solution00959 {

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] graph = new int[3 * n][3 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = i * 3;
                int c = j * 3;
                if (grid[i].charAt(j) == '\\') {
                    graph[r][c] = 1;
                    graph[r + 1][c + 1] = 1;
                    graph[r + 2][c + 2] = 1;
                } else if (grid[i].charAt(j) == '/') {
                    graph[r][c + 2] = 1;
                    graph[r + 1][c + 1] = 1;
                    graph[r + 2][c] = 1;
                }
            }
        }

        return numsOfIslands(graph);
    }

    private int numsOfIslands(int[][] graph) {
        int count = 0;
        int m = graph.length;
        int n = graph[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    count++;
                    dfs(graph, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] graph, int r, int c) {
        if (r < 0 || r >= graph.length ||
            c < 0 || c >= graph[0].length ||
            graph[r][c] == 1) {
            return;
        }
        graph[r][c] = 1;
        dfs(graph, r - 1, c);
        dfs(graph, r + 1, c);
        dfs(graph, r, c - 1);
        dfs(graph, r, c + 1);
    }

}
