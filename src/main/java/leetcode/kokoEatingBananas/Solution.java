package leetcode.kokoEatingBananas;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * 875. Koko Eating Bananas
 * <p>
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k.
 * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], h = 8 Output: 4 Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 5 Output: 30 Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], h = 6 Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= piles.length <= 104 piles.length <= h <= 109 1 <= piles[i] <= 109
 */
public class Solution {

    // Time: O(nlogn)
    // Space: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        // Create a variable to keep track of the left index.
        int left = 1;

        // Create a variable to keep track of the right index.
        int right = 0;

        // Loop through the piles array.
        for (int pile : piles) {
            // Update the right index.
            right = Math.max(right, pile);
        }

        // Loop while the left index is less than or equal to the right index.
        while (left <= right) {
            // Create a variable to keep track of the middle index.
            int mid = left + (right - left) / 2;

            // If the middle element is less than the target.
            if (canEatAll(piles, h, mid)) {
                // Update the right index.
                right = mid - 1;
            } else {
                // Update the left index.
                left = mid + 1;
            }
        }

        // Return the left index.
        return left;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        // Create a variable to keep track of the hours.
        long hours = 0;

        // Loop through the piles array.
        for (int pile : piles) {
            // Calculate the hours.
            // hours += (int) Math.ceil((double) pile / k); // runtime 21 ms (slowest)
            hours += (pile + k - 1) / k; // runtime 6 ms (faster)
            //hours += pile / k; // runtime 12 ms (medium)
            //if (pile % k != 0) {
            //    hours++;
            //}
        }

        // Return if the hours is less than or equal to the target.
        return hours <= h;
    }
}
