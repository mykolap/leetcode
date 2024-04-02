package leetcode;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 * Easy
 */

public class Solution00205 {

    public boolean isIsomorphic(String s, String t) {
        int[] sourceCharCount = new int[128];
        int[] targetCharCount = new int[128];
        int stringLength = s.length();
        for (int index = 0; index < stringLength; index++) {
            char sourceChar = s.charAt(index);
            char targetChar = t.charAt(index);
            if (sourceCharCount[sourceChar] != targetCharCount[targetChar]) {
                return false;
            }
            sourceCharCount[sourceChar] = index + 1;
            targetCharCount[targetChar] = index + 1;
        }
        return true;
    }

}