package leetcode;

import java.util.*;

/**
 * 310. Minimum Height Trees
 * <a href="https://leetcode.com/problems/minimum-height-trees">Web link</a> |
 * Medium
 */

public class Solution00310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }

        int[] degree = new int[n];
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            adjacencyList.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            adjacencyList.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 1) {
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = leaves.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adjacencyList.get(leaf)) {
                    if (--degree[neighbor] == 1) {
                        leaves.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }

    public List<Integer> findMinHeightTreesMoreEfficient(int n, int[][] edges) {
        if (edges.length == 0 || n == 1) {
            return List.of(0);
        }
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int v = e[0];
            int u = e[1];

            adj[v].add(u);
            adj[u].add(v);
            indegree[u]++;
            indegree[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();
            n -= size;

            while (size-- > 0) {
                //remove
                int rem = queue.remove();

                //mark*
                //work
                for (int i : adj[rem]) {
                    indegree[i]--;
                    if (indegree[i] == 1) {
                        queue.add(i);
                    }
                }
                //add*
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.pop());
        }


        return res;
    }

}