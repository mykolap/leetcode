package leetcode;

/**
 * 165. Compare Version Numbers
 * <a href="https://leetcode.com/problems/compare-version-numbers">Web link</a>
 * Medium
 */

public class Solution00165 {

    public int compareVersion(String version1, String version2) {
        String[] version1Parts = version1.split("\\.");
        String[] version2Parts = version2.split("\\.");
        int maxLength = Math.max(version1Parts.length, version2Parts.length);
        for (int i = 0; i < maxLength; i++) {
            int version1Part = i < version1Parts.length ? Integer.parseInt(version1Parts[i]) : 0;
            int version2Part = i < version2Parts.length ? Integer.parseInt(version2Parts[i]) : 0;
            if (version1Part < version2Part) {
                return -1;
            } else if (version1Part > version2Part) {
                return 1;
            }
        }
        return 0;
    }

}