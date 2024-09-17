package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 * <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences">Web link</a>
 * Easy
 */

public class Solution00884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.merge(word, 1, Integer::sum);
        }
        for (String word : s2.split(" ")) {
            map.merge(word, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }

}