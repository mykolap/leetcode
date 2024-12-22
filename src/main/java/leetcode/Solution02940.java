/**
 * 2940. Find Building Where Alice and Bob Can Meet
 * <a href="https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet">Web link</a> |
 * Hard
 */

package leetcode;

import java.util.*;

public class Solution02940 {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int heightsLen = heights.length;
        int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        Arrays.fill(result, -1);
        List<List<int[]>> deferred = new ArrayList<>();
        for (int i = 0; i < heightsLen; i++) {
            deferred.add(new ArrayList<>());
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < queriesLen; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (a == b || heights[a] < heights[b]) {
                result[i] = b;
            } else {
                deferred.get(b).add(new int[]{heights[a], i});
            }
        }

        for (int i = 0; i < heightsLen; ++i) {
            pq.addAll(deferred.get(i));
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                result[pq.poll()[1]] = i;
            }
        }

        return result;
    }

}