package leetcode;

/**
 * 1598. Crawler Log Folder
 * <a href="https://leetcode.com/problems/crawler-log-folder">Web link</a> |
 * Easy
 */

public class Solution01598 {

    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            switch (log) {
                case "../" -> {
                    if (depth > 0) {
                        --depth;
                    }
                }
                case "./" -> {
                }
                default -> ++depth;
            }
        }
        return depth;
    }

}