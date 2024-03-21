package leetcode;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3080. Mark Elements on Array by Performing Queries
 * <a href="https://leetcode.com/problems/mark-elements-on-array-by-performing-queries">Web link</a>
 * Medium
 */
public class Solution3080 {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        Comparator<Pair<Integer, Integer>> pairComparator = (pair1, pair2) -> {
            int keyComparison = pair1.getKey().compareTo(pair2.getKey());
            if (keyComparison != 0) {
                return keyComparison;
            } else {
                return pair1.getValue().compareTo(pair2.getValue());
            }
        };
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(pairComparator);
        long totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;
            pq.add(new Pair<>(num, i));
        }
        long[] result = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] command = queries[i];
            int indexForMark = command[0];
            if (nums[indexForMark] > 0) {
                totalSum -= nums[indexForMark];
            }
            nums[indexForMark] = -1;
            int elementsToMark = command[1];
            while (elementsToMark > 0) {
                if (pq.isEmpty()) {
                    break;
                }
                Pair<Integer, Integer> pair = pq.poll();
                int indexOfElementFromQueue = pair.getValue();
                int actualValueWithUpdates = nums[indexOfElementFromQueue];
                if (actualValueWithUpdates >= 0) { // not marked yet
                    totalSum -= actualValueWithUpdates;
                    nums[indexOfElementFromQueue] = -1;
                    elementsToMark--;
                }
            }
            result[i] = totalSum;
        }
        return result;
    }

}
