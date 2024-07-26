package leetcode;

import java.util.*;

/**
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * <a href="https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance">Web link</a>
 * Medium
 */

public class Solution01334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Connection>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int distance = edge[2];
            graph.get(node1).add(new Connection(node2, distance));
            graph.get(node2).add(new Connection(node1, distance));
        }

        int minNumber = n;
        int minCity = -1;

        for (int source = 0; source < n; source++) {
            int neighbors = dijkstra(graph, source, distanceThreshold);
            if (neighbors <= minNumber) {
                minNumber = neighbors;
                minCity = source;
            }
        }

        return minCity;
    }

    private int dijkstra(List<List<Connection>> graph, int source, int distanceThreshold) {
        PriorityQueue<Connection> minHeap = new PriorityQueue<>(Comparator.comparingInt(Connection::distance));
        minHeap.add(new Connection(source, 0));
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            Connection current = minHeap.poll();
            final int currentCity = current.city();
            if (visited.contains(currentCity)) {
                continue;
            }
            visited.add(currentCity);
            for (Connection neighbor : graph.get(currentCity)) {
                final int newDistance = current.distance() + neighbor.distance();
                if (newDistance <= distanceThreshold) {
                    minHeap.add(new Connection(neighbor.city(), newDistance));
                }
            }
        }
        return visited.size() - 1;
    }

    private record Connection(int city, int distance) {
    }

}