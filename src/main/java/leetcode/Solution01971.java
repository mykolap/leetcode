package leetcode;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 * Source: https://leetcode.com/problems/find-if-path-exists-in-graph/
 * Easy
 */

public class Solution01971 {

    int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }
            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (visited.add(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }

    public boolean validPathUf(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return find(source) == find(destination);
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean validPathSpread(int n, int[][] edges, int source, int destination) {
        boolean[] isNodeVisited = new boolean[n];
        isNodeVisited[source] = true;

        boolean isStateChangedInCurrentIteration = true;

        while (isStateChangedInCurrentIteration) {
            isStateChangedInCurrentIteration = false;

            for (int[] edge : edges) {
                if (isNodeVisited[edge[0]] != isNodeVisited[edge[1]]) {
                    isNodeVisited[edge[0]] = true;
                    isNodeVisited[edge[1]] = true;

                    isStateChangedInCurrentIteration = true;
                }

                if (isNodeVisited[destination]) {
                    return true;
                }
            }
        }

        return isNodeVisited[destination];
    }

}