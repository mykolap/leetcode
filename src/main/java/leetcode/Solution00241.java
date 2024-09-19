package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. Different Ways to Add Parentheses
 * <a href="https://leetcode.com/problems/different-ways-to-add-parentheses">Web link</a>
 * Medium
 */

public class Solution00241 {

    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        return solveTopDown(expression, map);
    }

    private List<Integer> solveTopDown(String expression, Map<String, List<Integer>> map) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = solveTopDown(expression.substring(0, i), map);
                List<Integer> right = solveTopDown(expression.substring(i + 1), map);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') ans.add(l + r);
                        else if (c == '-') ans.add(l - r);
                        else ans.add(l * r);
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        map.put(expression, ans);
        return ans;
    }

}