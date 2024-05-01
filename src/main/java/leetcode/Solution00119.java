package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 * Easy
 */

public class Solution00119 {

    public List<Integer> getRowOptimized(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        result[rowIndex] = 1;

        for (int i = 1; i <= rowIndex / 2; i++) {
            int previousValue = result[i - 1];
            long multiplier = rowIndex - i + 1L;
            long product = previousValue * multiplier;
            long divisionResult = product / i;
            result[i] = (int) divisionResult;
            result[rowIndex - i] = (int) divisionResult;
        }

        return Arrays.asList(result);
    }

    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        List<Integer> baseRow = new ArrayList<>();
        baseRow.add(1);

        List<Integer> actualRow = baseRow;
        for (int i = 2; i <= numRows; i++) {
            int newSize = actualRow.size() + 1;
            List<Integer> newRow = new ArrayList<>(newSize);
            newRow.add(1);
            for (int j = 1; j < newSize - 1; j++) {
                newRow.add(actualRow.get(j - 1) + actualRow.get(j));
            }
            newRow.add(1);
            actualRow = newRow;
        }

        return actualRow;
    }

}