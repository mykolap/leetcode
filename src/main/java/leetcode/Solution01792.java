/**
 * 1792. Maximum Average Pass Ratio
 * <a href="https://leetcode.com/problems/maximum-average-pass-ratio">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution01792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double[] ratios = new double[n];
        for (int i = 0; i < n; i++) {
            int[] c = classes[i];
            ratios[i] = (double) (c[0] + 1) / (c[1] + 1) - (double) c[0] / c[1];
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Double.compare(ratios[b], ratios[a]));
        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        while (extraStudents-- > 0) {
            int i = pq.poll();
            classes[i][0]++;
            classes[i][1]++;
            ratios[i] = (double) (classes[i][0] + 1) / (classes[i][1] + 1) - (double) classes[i][0] / classes[i][1];
            pq.offer(i);
        }

        double ans = 0;
        for (int[] aClass : classes) {
            ans += (double) aClass[0] / aClass[1];
        }

        return ans / n;
    }
}