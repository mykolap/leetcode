package leetcode.numberOfConnectedComponentsInAnUndirectedGraph;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 * 323. Number of Connected Components in an Undirected Graph
 * <p>
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates
 * that there is an edge between ai and bi in the graph.
 * <p>
 * Return the number of connected components in the graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 2000
 * 1 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai <= bi < n
 * ai != bi
 * There are no repeated edges.
 */
public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        System.out.println(new Solution().countComponents(n, edges));
    }

    // Time: O(n + m)
    // Space: O(n)
    public int countComponents(int n, int[][] edges) {
        // Create a map to store the edges.
        Map<Integer, Set<Integer>> edgesMap = new HashMap<>();

        // Iterate over the edges and add them to the map.
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (!edgesMap.containsKey(node1)) {
                edgesMap.put(node1, new HashSet<>());
            }

            if (!edgesMap.containsKey(node2)) {
                edgesMap.put(node2, new HashSet<>());
            }

            edgesMap.get(node1).add(node2);
            edgesMap.get(node2).add(node1);
        }

        // Create an array to store the visited nodes.
        boolean[] visited = new boolean[n];

        // Create a variable to store the number of connected components.
        int numComponents = 0;

        // Iterate over the nodes and count the number of connected components.
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numComponents++;
                dfs(edgesMap, visited, i);
            }
        }

        return numComponents;
    }

    // Depth-first search to visit all nodes in the connected component.
    private void dfs(Map<Integer, Set<Integer>> edgesMap, boolean[] visited, int node) {
        visited[node] = true;

        for (int neighbor : edgesMap.get(node)) {
            if (!visited[neighbor]) {
                dfs(edgesMap, visited, neighbor);
            }
        }
    }

}
