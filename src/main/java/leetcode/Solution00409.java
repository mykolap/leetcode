package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * <a href="https://leetcode.com/problems/longest-palindrome">Web link</a> |
 * Easy
 */

public class Solution00409 {

    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            final char currentChar = s.charAt(i);
            countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
        }
        int result = 0;
        boolean hasOdd = false;
        for (Integer coun : countMap.values()) {
            result += coun;
            if (coun % 2 == 1) {
                result--;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            result++;
        }
        return result;
    }

}