package leetcode;

/**
 * 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 * <a href="https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor">Web link</a>
 * Medium
 */

public class Solution01442 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefix[i] == prefix[k + 1]) {
                    count += k - i;
                }
            }
        }
        return count;
    }

    public int countTripletsOptimized(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                val = val ^ arr[k];
                if (val == 0) {
                    res += (k - i);
                }
            }

        }
        return res;
    }
}