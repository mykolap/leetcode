package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 264. Ugly Number II
 * <a href="https://leetcode.com/problems/ugly-number-ii">Web link</a> |
 * Medium
 */

public class Solution00264 {

    public int nthUglyNumber_PriorityQueue(int n) {
        long num = 1;
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        addIfNotPresent(pq, num, visited);
        for (int i = 0; i < n; i++) {
            num = pq.poll();
            addIfNotPresent(pq, num * 2, visited);
            addIfNotPresent(pq, num * 3, visited);
            addIfNotPresent(pq, num * 5, visited);
        }
        return (int) num;
    }

    private static void addIfNotPresent(Queue<Long> pq, long num, Set<Long> visited) {
        if (visited.add(num)) {
            pq.add(num);
        }
    }

    public int nthUglyNumber_Dp(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i = 1; i < n; i++) {
            int num2 = dp[i2] * 2;
            int num3 = dp[i3] * 3;
            int num5 = dp[i5] * 5;

            int nextMin = Math.min(num2, Math.min(num3, num5));
            dp[i] = nextMin;

            if (nextMin == num2) {
                i2++;
            }
            if (nextMin == num3) {
                i3++;
            }
            if (nextMin == num5) {
                i5++;
            }
        }

        return dp[n - 1];
    }

}