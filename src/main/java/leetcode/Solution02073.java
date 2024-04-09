package leetcode;

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets/
 * 2073. Time Needed to Buy Tickets
 * Easy
 */

public class Solution02073 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int seconds = 0;
        for (int i = 0; i < n; i++, i %= n) {
            if (tickets[i] > 1) {
                seconds++;
                tickets[i]--;
            } else if (tickets[i] == 1) {
                seconds++;
                if (i == k) {
                    return seconds;
                } else {
                    tickets[i]--;
                }
            }
        }
        return seconds;
    }

    public int timeRequiredToBuyOptimized(int[] tickets, int k) {
        int n = tickets.length;
        int seconds = 0;

        int timesKOrBefore = tickets[k];
        int timesAfterK = timesKOrBefore - 1;

        for (int i = 0; i < n; i++) {
            if (i <= k) {
                seconds += Math.min(tickets[i], timesKOrBefore);
            } else {
                seconds += Math.min(tickets[i], timesAfterK);
            }
        }
        return seconds;
    }
}