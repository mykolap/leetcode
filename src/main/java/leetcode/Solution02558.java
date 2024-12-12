/**
 * 2558. Take Gifts From the Richest Pile
 * <a href="https://leetcode.com/problems/take-gifts-from-the-richest-pile">Web link</a> |
 * Easy
 */

package leetcode;

import java.util.PriorityQueue;

public class Solution02558 {

    public long pickGifts(int[] gifts, int k) {
        long total = 0L;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            maxHeap.add(gift);
            total += gift;
        }
        int remaining = k;
        while (remaining > 0) {
            int max = maxHeap.poll();
            if (max == 1) {
                break;
            }
            int sqrt = (int) Math.sqrt(max);
            maxHeap.add(sqrt);
            total -= (max - sqrt);
            remaining--;
        }
        return total;
    }

}