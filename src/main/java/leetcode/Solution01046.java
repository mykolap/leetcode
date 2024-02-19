package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * https://leetcode.com/problems/last-stone-weight/
 * Easy
 * <p>
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.
 * <p>
 * The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight x is totally destroyed,
 * and the stone of weight y has new weight y-x. At the end, there is at most 1 stone left.
 * Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1] Output: 1 Explanation: We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then, we combine 2 and 1 to get 1 so the array
 * converts to [1,1,1] then, we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last
 * stone.
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30 1 <= stones[i] <= 1000
 */
public class Solution01046 {

    // Time: O(n * log(n))
    // Space: O(n)
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if (first != second) {
                maxHeap.offer(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Time: O(n * log(n))
    // Space: O(1)
    public int lastStoneWeightFirstApproach(int[] stones) {
        int last = stones.length - 1;
        while (last > 0) {
            Arrays.sort(stones, 0, last + 1);
            stones[last - 1] = stones[last] - stones[last - 1];
            last--;
        }
        return stones[0];
    }

}
