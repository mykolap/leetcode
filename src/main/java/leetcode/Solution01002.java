package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. Find Common Characters
 * <a href="https://leetcode.com/problems/find-common-characters">Web link</a>
 * Easy
 */

public class Solution01002 {

    public List<String> commonChars(String[] words) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> tempMap = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            countMap.replaceAll((k, v) -> Math.min(v, tempMap.getOrDefault(k, 0)));
        }
        List<String> result = new ArrayList<>();
        for (var entry : countMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }
        return result;
    }

}