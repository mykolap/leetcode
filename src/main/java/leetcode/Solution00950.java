package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * 950. Reveal Cards In Increasing Order
 * Medium
 */

public class Solution00950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n];
        Queue<Integer> queue = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        Arrays.sort(deck);
        for (int deckElement : deck) {
            final int idx = queue.poll();
            // put first element into the result
            res[idx] = deckElement;
            // put second element to the end of the queue
            if (!queue.isEmpty()) {
                queue.add(queue.poll());
            }
        }
        return res;
    }
}