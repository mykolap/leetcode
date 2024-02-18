package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/apply-operations-to-make-string-empty/
 * 3039. Apply Operations to Make String Empty
 * Medium
 */
public class Solution03039 {

    // Time: O(n)
    // Space: O(n)
    public String lastNonEmptyString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.merge(ch, 1, Integer::sum);
        }
        int max = freqMap.values().stream()
                .mapToInt(intObj -> intObj)
                .max()
                .orElse(0);
        if (max == 1) {
            return s;
        }
        Map<Character, Integer> onlyMaxFreqMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == max) {
                onlyMaxFreqMap.put(entry.getKey(), entry.getValue());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            Integer count = onlyMaxFreqMap.get(ch);
            if (count != null) {
                if (count > 1) {
                    onlyMaxFreqMap.put(ch, count - 1);
                } else {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();
    }

}