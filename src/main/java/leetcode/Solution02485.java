package leetcode;

/**
 * 2485. Find the Pivot Integer
 * <a href="https://leetcode.com/problems/find-the-pivot-integer">Web link</a> |
 * Easy
 */

public class Solution02485 {

    // Time: O(n)
    // Space: O(1)
    public int pivotInteger(int n) {
        int left = 1;
        int right = n;
        int sumLeft = 1;
        int sumRight = n;
        while (left < right) {
            if (sumLeft < sumRight) {
                left++;
                sumLeft += left;
            } else {
                right--;
                sumRight += right;
            }
        }
        if (sumLeft == sumRight) {
            return left;
        } else {
            return -1;
        }
    }

    public int pivotIntegerImproved(int n) {
        int sum = (n * (n + 1)) / 2;
        double x = Math.sqrt(sum);
        if (x - Math.ceil(x) == 0) {
            return (int) x;
        } else {
            return -1;
        }
    }

}
