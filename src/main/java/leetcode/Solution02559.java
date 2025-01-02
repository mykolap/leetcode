/**
 * 2559. Count Vowel Strings in Ranges
 * <a href="https://leetcode.com/problems/count-vowel-strings-in-ranges">Web link</a> |
 * Medium
 */

package leetcode;

public class Solution02559 {

    public int[] vowelStrings(String[] words, int[][] queries) {
        final int wordsLen = words.length;
        int[] countAt = new int[wordsLen + 1];
        for (int i = 0; i < wordsLen; i++) {
            countAt[i + 1] = countAt[i] + (isVowelString(words[i]) ? 1 : 0);
        }
        final int queriesLen = queries.length;
        int[] result = new int[queriesLen];
        for (int i = 0; i < queriesLen; i++) {
            result[i] = countAt[queries[i][1] + 1] - countAt[queries[i][0]];
        }
        return result;
    }

    private boolean isVowelString(String word) {
        final int len = word.length();
        if (len == 0) {
            return false;
        }
        if (!isVowelChar(word.charAt(0))) {
            return false;
        }
        if (len == 1) {
            return true;
        }
        return isVowelChar(word.charAt(len - 1));
    }

    private boolean isVowelChar(char ch) {
        return ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u';
    }

}