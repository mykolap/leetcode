/**
 * 3042. Count Prefix and Suffix Pairs I
 * <a href="https://leetcode.com/problems/count-prefix-and-suffix-pairs-i">Web link</a>
 * Easy
 */

package leetcode;

public class Solution03042 {

    public int countPrefixSuffixPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            result += countPrefixAndSuffix(i, words);
        }
        return result;
    }

    private int countPrefixAndSuffix(int i, String[] words) {
        String wordToCheck = words[i];
        int count = 0;
        for (int j = i + 1; j < words.length; j++) {
            String word = words[j];
            if (i < j &&
                    word.startsWith(wordToCheck) &&
                    word.endsWith(wordToCheck)) {
                count++;
            }
        }
        return count;
    }

}