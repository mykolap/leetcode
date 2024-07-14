package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 726. Number of Atoms
 * <a href="https://leetcode.com/problems/number-of-atoms">Web link</a>
 * Hard
 */

public class Solution00726 {

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Map<String, Integer> rootMap = new HashMap<>();
        stack.push(rootMap);
        for (int index = 0; index < n; ++index) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                stack.push(new HashMap<>());
            } else if (ch == ')') {
                int count = 0;
                if (index + 1 < n && Character.isDigit(formula.charAt(index + 1))) {
                    int nextIndex = index + 1;
                    while (nextIndex < n && Character.isDigit(formula.charAt(nextIndex))) {
                        count = count * 10 + (formula.charAt(nextIndex) - '0');
                        nextIndex++;
                    }
                    index = nextIndex - 1;
                } else {
                    count = 1;
                }
                Map<String, Integer> currentMap = stack.pop();
                Map<String, Integer> topMap = stack.peek();
                for (var entry : currentMap.entrySet()) {
                    topMap.put(entry.getKey(), topMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
                }
            } else if (Character.isUpperCase(ch)) {
                int j = index + 1;
                while (j < n && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(index, j);
                index = j - 1;
                int count = 0;
                if (index + 1 < n && Character.isDigit(formula.charAt(index + 1))) {
                    int nextIndex = index + 1;
                    while (nextIndex < n && Character.isDigit(formula.charAt(nextIndex))) {
                        count = count * 10 + (formula.charAt(nextIndex) - '0');
                        nextIndex++;
                    }
                    index = nextIndex - 1;
                } else {
                    count = 1;
                }
                Map<String, Integer> currentMap = stack.peek();
                currentMap.put(atom, currentMap.getOrDefault(atom, 0) + count);
            }
        }
        StringBuilder sb = new StringBuilder();
        rootMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 1) {
                        sb.append(entry.getKey()).append(entry.getValue());
                    } else {
                        sb.append(entry.getKey());
                    }
                });
        return sb.toString();
    }

}