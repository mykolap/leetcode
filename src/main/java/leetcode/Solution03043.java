package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3043. Find the Length of the Longest Common Prefix
 * <a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix">Web link</a>
 * Medium
 */

public class Solution03043 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Map<String, Integer> prefixMap = new HashMap<>();

        // Step 1: Build the prefix map for arr1
        for (int num : arr1) {
            String strNum = Integer.toString(num);
            for (int i = 1; i <= strNum.length(); i++) {
                String prefix = strNum.substring(0, i);
                prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
            }
        }

        int maxLength = 0;

        // Step 2: Check for common prefixes in arr2
        for (int num : arr2) {
            String strNum = Integer.toString(num);
            for (int i = 1; i <= strNum.length(); i++) {
                String prefix = strNum.substring(0, i);
                if (prefixMap.containsKey(prefix)) {
                    maxLength = Math.max(maxLength, i);
                }
            }
        }

        return maxLength;
    }

}