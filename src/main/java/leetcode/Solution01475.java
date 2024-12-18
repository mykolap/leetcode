/**
 * 1475. Final Prices With a Special Discount in a Shop
 * <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop">Web link</a>
 * Easy
 */

package leetcode;

public class Solution01475 {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int originalPrice = prices[i];
            int discount = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= originalPrice) {
                    discount = prices[j];
                    break;
                }
            }
            result[i] = originalPrice - discount;
        }
        return result;
    }

}