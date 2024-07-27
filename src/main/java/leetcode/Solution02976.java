package leetcode;

import java.util.*;

/**
 * 2976. Minimum Cost to Convert String I
 * <a href="https://leetcode.com/problems/minimum-cost-to-convert-string-i">Web link</a> |
 * Medium
 */

public class Solution02976 {

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();

        List<Connection>[] adj = new List[26];
        long minCost = 0L;
        Map<SourceTarget, Long> memo = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < original.length; i++) {
            adj[original[i] - 'a'].add(new Connection(changed[i] - 'a', cost[i]));
        }

        for (var i = 0; i < n; i++) {
            SourceTarget key = new SourceTarget(source.charAt(i), target.charAt(i));
            long charCost = dijkstra(adj, key, memo);
            if (charCost == -1) {
                return -1;
            }
            minCost += charCost;
        }
        return minCost;
    }

    private long dijkstra(List<Connection>[] adj, SourceTarget key, Map<SourceTarget, Long> memo) {
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean[] seen = new boolean[26];
        long charCost = 0L;
        Queue<Connection> queue = new PriorityQueue<>(Comparator.comparingInt(Connection::distance));
        queue.offer(new Connection(key.source() - 'a', 0));

        while (!queue.isEmpty()) {
            Connection a = queue.poll();
            int currentTargetIndex = a.targetIndex();
            int costSoFar = a.distance();

            if ((char) (currentTargetIndex + 'a') == key.target()) {
                charCost += costSoFar;
                memo.put(key, charCost);
                return charCost;
            }
            if (seen[currentTargetIndex]) {
                continue;
            }
            seen[currentTargetIndex] = true;
            for (Connection nei : adj[currentTargetIndex]) {
                if (!seen[nei.targetIndex()]) {
                    queue.offer(new Connection(nei.targetIndex(), costSoFar + nei.distance()));
                }
            }
        }
        return -1;
    }

    private record Connection(int targetIndex, int distance) {
    }

    private record SourceTarget(char source, char target) {
    }

}