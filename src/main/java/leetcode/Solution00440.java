package leetcode;

/**
 * 440. K-th Smallest in Lexicographical Order
 * <a href="https://leetcode.com/problems/k-th-smallest-in-lexicographical-order">Web link</a>
 * Hard
 */

public class Solution00440 {

    public int findKthNumber(int n, int k) {
        long current = 1;
        k--;
        while (k > 0) {
            int steps = calculateSteps(n, current);
            if (steps <= k) {
                current++;
                k -= steps;
            } else {
                current *= 10;
                k--;
            }
        }
        return (int) current;
    }

    private int calculateSteps(int n, long current) {
        long next = current + 1;
        long steps = 0;
        while (current <= n) {
            steps += Math.min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return (int) steps;
    }

}