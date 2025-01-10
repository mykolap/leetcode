/**
 * 916. Word Subsets
 * <a href="https://leetcode.com/problems/word-subsets">Web link</a>
 * Medium
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution00916 {

    public List<String> wordSubsetsTle(String[] words1, String[] words2) {
        int[][] countWords2 = new int[words1.length][26];
        for (int i = 0; i < words2.length; i++) {
            final String word2 = words2[i];
            for (int j = 0; j < word2.length(); j++) {
                countWords2[i][word2.charAt(j) - 'a']++;
            }
        }
        List<String> result = new ArrayList<>();
        for (final String word1 : words1) {
            if (isUniversal(word1, countWords2)) {
                result.add(word1);
            }
        }
        return result;
    }

    private boolean isUniversal(String word1, int[][] countWords2) {
        int[] countWord1 = new int[26];
        for (int j = 0; j < word1.length(); j++) {
            countWord1[word1.charAt(j) - 'a']++;
        }
        for (int[] countWord2 : countWords2) {
            for (int k = 0; k < 26; k++) {
                if (countWord2[k] > countWord1[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] countWords2Max = new int[26];
        for (String word2 : words2) {
            int[] countWords2 = new int[26];
            for (int j = 0; j < word2.length(); j++) {
                int idx = word2.charAt(j) - 'a';
                countWords2[idx]++;
                countWords2Max[idx] = Math.max(countWords2Max[idx], countWords2[idx]);
            }
        }
        List<String> result = new ArrayList<>();
        for (final String word1 : words1) {
            if (isUniversal(word1, countWords2Max)) {
                result.add(word1);
            }
        }
        return result;
    }

    private boolean isUniversal(String word1, int[] countWords2Max) {
        int[] countWord1 = new int[26];
        for (int j = 0; j < word1.length(); j++) {
            countWord1[word1.charAt(j) - 'a']++;
        }
        for (int k = 0; k < 26; k++) {
            if (countWords2Max[k] > countWord1[k]) {
                return false;
            }
        }
        return true;
    }

}