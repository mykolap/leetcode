package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 502. IPO
 * <a href="https://leetcode.com/problems/ipo">Web link</a>
 * Hard
 */

public class Solution00502 {

    public int findMaximizedCapitalArrayPlusHeap(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int currentCapital = w;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));
        int positionIncluded = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            while (positionIncluded < n && projects[positionIncluded][0] <= currentCapital) {
                maxHeap.add(projects[positionIncluded][1]);
                positionIncluded++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            currentCapital += maxHeap.poll();
        }
        return currentCapital;
    }

    public int findMaximizedCapital2Heaps(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int currentCapital = w;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            if (capital[i] > currentCapital) {
                minHeap.add(new int[]{capital[i], profits[i]});
            } else {
                maxHeap.add(profits[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= currentCapital) {
                maxHeap.add(minHeap.poll()[1]);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            currentCapital += maxHeap.poll();
        }
        return currentCapital;
    }

}