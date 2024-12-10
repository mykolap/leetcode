/**
 * 2981. Find Longest Special Substring That Occurs Thrice I
 * <a href="https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution02981 {

    public int maximumLength(String s) {
        Map<String, Integer> count = new HashMap<>();

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                if (s.charAt(start) != s.charAt(end - 1)) {
                    break;
                }
                String substring = s.substring(start, end);
                count.put(substring, count.getOrDefault(substring, 0) + 1);
            }
        }

        int ans = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() >= 3) {
                ans = Math.max(ans, entry.getKey().length());
            }
        }

        return ans == 0 ? -1 : ans;
    }

}