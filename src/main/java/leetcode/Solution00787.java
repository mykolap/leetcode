package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 * 787. Cheapest Flights Within K Stops
 * Medium
 */

public class Solution00787 {

    // Time: O(n * k)
    // Space: O(n)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int from = flight[0];
                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }
                int to = flight[1];
                int price = flight[2];
                temp[to] = Math.min(temp[to], prices[from] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}