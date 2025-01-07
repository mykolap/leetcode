/**
 * 1408. String Matching in an Array
 * <a href="https://leetcode.com/problems/string-matching-in-an-array">Web link</a>
 * Easy
 */

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution01408 {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            checkIfSubstring(words, i, result);
        }
        return result;
    }

    private void checkIfSubstring(String[] words, int i, List<String> result) {
        int len = words.length;
        String wordToCheck = words[i];
        for (int j = 0; j < len; j++) {
            final String word = words[j];
            if (i != j &&
                    word.length() >= wordToCheck.length() &&
                    word.contains(wordToCheck)) {
                result.add(wordToCheck);
                break;
            }
        }
    }

}