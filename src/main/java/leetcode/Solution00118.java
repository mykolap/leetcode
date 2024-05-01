package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * Easy
 */

public class Solution00118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> baseRow = new ArrayList<>();
        baseRow.add(1);
        result.add(baseRow);

        List<Integer> prevRow = baseRow;
        for (int i = 2; i <= numRows; i++) {
            int newSize = prevRow.size() + 1;
            List<Integer> newRow = new ArrayList<>(newSize);
            newRow.add(1);
            for (int j = 1; j < newSize - 1; j++) {
                newRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            newRow.add(1);
            result.add(newRow);
            prevRow = newRow;
        }

        return result;
    }

}