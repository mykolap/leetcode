package leetcode;

/**
 * 1310. XOR Queries of a Subarray
 * <a href="https://leetcode.com/problems/xor-queries-of-a-subarray">Web link</a>
 * Medium
 */

public class Solution01310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorPrefixes = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            xorPrefixes[i + 1] = xorPrefixes[i] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            final int left = query[0];
            final int right = query[1];
            result[i] = xorPrefixes[left] ^ xorPrefixes[right + 1];
        }
        return result;
    }

}