/**
 * 1930. Unique Length-3 Palindromic Subsequences
 * <a href="https://leetcode.com/problems/unique-length-3-palindromic-subsequences">Web link</a> |
 * Medium
 */

package leetcode;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Solution01930 {

    public int countPalindromicSubsequence(String s) {
        final int LETTERS_COUNT = 26;
        Pair<Integer, Integer>[] pairs = new Pair[LETTERS_COUNT];
        for (int i = 0; i < LETTERS_COUNT; i++) {
            pairs[i] = new Pair<>(-1, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (pairs[index].getKey() == -1) {
                pairs[index] = new Pair<>(i, -1);
            } else {
                pairs[index] = new Pair<>(pairs[index].getKey(), i);
            }
        }
        int result = 0;
        for (int i = 0; i < LETTERS_COUNT; i++) {
            if (pairs[i].getValue() != -1) {
                Set<Character> set = new HashSet<>();
                for (int j = pairs[i].getKey() + 1; j < pairs[i].getValue(); j++) {
                    set.add(s.charAt(j));
                }
                result += set.size();
            }
        }
        return result;
    }

}