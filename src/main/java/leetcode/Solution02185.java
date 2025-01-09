/**
 * 2185. Counting Words With a Given Prefix
 * <a href="https://leetcode.com/problems/counting-words-with-a-given-prefix">Web link</a> |
 * Easy
 */

package leetcode;

public class Solution02185 {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

}
