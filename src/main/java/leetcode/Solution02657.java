/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * <a href="https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02657 {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] result = new int[n];
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            if (++freq[A[i]] == 2) commonCount++;
            if (++freq[B[i]] == 2) commonCount++;
            result[i] = commonCount;
        }
        return result;
    }

}