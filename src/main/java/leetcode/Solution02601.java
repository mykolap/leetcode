/**
 * 2601. Prime Subtraction Operation
 * <a href="https://leetcode.com/problems/prime-subtraction-operation">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02601 {

    public boolean primeSubOperation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int bound = (i == 0) ? nums[i] : nums[i] - nums[i - 1];

            if (bound <= 0) return false;

            int largestPrime = 0;
            for (int j = bound - 1; j >= 2; j--) {
                if (checkPrime(j)) {
                    largestPrime = j;
                    break;
                }
            }

            nums[i] -= largestPrime;
        }
        return true;
    }

    private boolean checkPrime(int x) {
        if (x <= 1) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

}