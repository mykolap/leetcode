package leetcode;

/**
 * 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * Easy
 */

public class Solution00028 {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int currentIndex = 0; currentIndex + needleLength <= haystackLength; currentIndex++) {
            int matchingIndex = 0;
            while (matchingIndex < needleLength && haystack.charAt(currentIndex + matchingIndex) == needle.charAt(matchingIndex)) {
                matchingIndex++;
            }
            if (matchingIndex == needleLength) {
                return currentIndex;
            }
        }
        return -1;
    }
}