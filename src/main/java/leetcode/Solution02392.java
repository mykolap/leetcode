package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2392. Build a Matrix With Conditions
 * <a href="https://leetcode.com/problems/build-a-matrix-with-conditions">Web link</a> |
 * Hard
 */

public class Solution02392 {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> sortedRows = topoSort(rowConditions, k);
        List<Integer> sortedCols = topoSort(colConditions, k);

        if (sortedRows.isEmpty() || sortedCols.isEmpty()) {
            return new int[0][0];
        }

        int[][] result = new int[k][k];
        for (int row = 0; row < k; row++) {
            for (int col = 0; col < k; col++) {
                if (sortedRows.get(row).equals(sortedCols.get(col))) {
                    result[row][col] = sortedRows.get(row);
                }
            }
        }
        return result;
    }

    private List<Integer> topoSort(int[][] edges, int k) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
        }
        List<Integer> sorted = new ArrayList<>();
        int[] visited = new int[k + 1];
        boolean[] hasCycle = {false};
        for (int i = 1; i <= k; i++) {
            if (visited[i] == 0) {
                dfs(i, adjacencyList, visited, sorted, hasCycle);
                if (hasCycle[0]) {
                    return List.of();
                }
            }
        }
        return sorted.reversed();
    }

    private void dfs(int node, List<List<Integer>> adjacencyList, int[] visited, List<Integer> sorted, boolean[] hasCycle) {
        visited[node] = 1;
        for (int neighbor : adjacencyList.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, adjacencyList, visited, sorted, hasCycle);
            } else if (visited[neighbor] == 1) {
                hasCycle[0] = true;
                return;
            }
        }
        visited[node] = 2;
        sorted.add(node);
    }

}