package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2530. Maximal Score After Applying K Operations
 * <a href="https://leetcode.com/problems/maximal-score-after-applying-k-operations">Web link</a> |
 * Medium
 */

public class Solution02530 {

    public long maxKelements(int[] nums, int k) {
        long result = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        while (k-- > 0) {
            int max = pq.poll();
            result += max;
            pq.add(Math.ceilDiv(max, 3));
        }
        return result;
    }

}