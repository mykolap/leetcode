package leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 2418. Sort the People
 * <a href="https://leetcode.com/problems/sort-the-people">Web link</a> |
 * Easy
 */

public class Solution02418 {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<Pair<String, Integer>> people = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            people.add(new Pair<>(names[i], heights[i]));
        }
        return people.stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(Pair::getKey)
                .toArray(String[]::new);
    }

}