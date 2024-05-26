package leetcode;

import java.util.*;

/**
 * 140. Word Break II
 * https://leetcode.com/problems/word-break-ii/
 * Hard
 */

public class Solution00140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return wordBreak(s, wordSet, 0, memo);
    }

    private List<String> wordBreak(String s, Set<String> wordSet, int start, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();
        if (start == s.length()) {
            result.add("");
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordSet.contains(word)) {
                List<String> nextWords = wordBreak(s, wordSet, end, memo);
                for (String nextWord : nextWords) {
                    result.add(word + (nextWord.isEmpty() ? "" : " ") + nextWord);
                }
            }
        }

        memo.put(start, result);
        return result;
    }

}