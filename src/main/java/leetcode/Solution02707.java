package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 2707. Extra Characters in a String
 * <a href="https://leetcode.com/problems/extra-characters-in-a-string">Web link</a> |
 * Medium
 */

public class Solution02707 {

    public int minExtraChar(String s, String[] dictionary) {
        int strLen = s.length();
        Set<String> dictSet = new HashSet<>(strLen);
        Collections.addAll(dictSet, dictionary);
        int[] delCount = new int[strLen + 1];
        for (int right = 1; right <= strLen; right++) {
            delCount[right] = 1 + delCount[right - 1];
            for (int left = right; left > 0; left--) {
                String word = s.substring(left - 1, right);
                if (dictSet.contains(word)) {
                    delCount[right] = Math.min(delCount[right], delCount[left - 1]);
                }
            }
        }
        return delCount[strLen];
    }

}