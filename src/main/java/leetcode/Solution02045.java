package leetcode;

import java.util.*;

/**
 * 2045. Second Minimum Time to Reach Destination
 * <a href="https://leetcode.com/problems/second-minimum-time-to-reach-destination">Web link</a> |
 * Hard
 */

public class Solution02045 {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int currentTime = 0;
        int result = -1;
        Map<Integer, List<Integer>> visited = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n) {
                    if (result != -1) {
                        return currentTime;
                    }
                    result = currentTime;
                }
                for (int neighbor : adj.get(current)) {
                    var list = visited.computeIfAbsent(neighbor, key -> new ArrayList<>());
                    if (list.isEmpty() || (list.size() == 1 && list.getFirst() != currentTime)) {
                        list.add(currentTime);
                        queue.offer(neighbor);
                    }
                }
            }
            if ((currentTime / change) % 2 == 1) {
                currentTime += change - (currentTime % change);
            }
            currentTime += time;
        }

        return 0;
    }

}