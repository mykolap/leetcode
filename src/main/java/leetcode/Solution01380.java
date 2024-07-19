package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1380. Lucky Numbers in a Matrix
 * <a href="https://leetcode.com/problems/lucky-numbers-in-a-matrix">Web link</a>
 * Easy
 */

public class Solution01380 {

    public List<Integer> luckyNumbers(int[][] matrix) {
        Map<Integer, Integer> resultCandidates = new HashMap<>(); // <columnIndex, minValue>
        int columns = matrix[0].length;
        for (int[] row : matrix) {
            int minIndex = 0;
            for (int i = 1; i < columns; i++) {
                if (row[i] < row[minIndex]) {
                    minIndex = i;
                }
            }
            int previousColumnCandidate = resultCandidates.getOrDefault(minIndex, 0);
            if (row[minIndex] > previousColumnCandidate) {
                resultCandidates.put(minIndex, row[minIndex]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (var entry : resultCandidates.entrySet()) {
            int columnIndex = entry.getKey();
            int minValue = entry.getValue();
            boolean isLucky = true;
            for (int[] row : matrix) {
                if (row[columnIndex] > minValue) {
                    isLucky = false;
                    break;
                }
            }
            if (isLucky) {
                result.add(minValue);
            }
        }
        return result;
    }

    public List<Integer> luckyNumbersOptimized(int[][] matrix) {
        int currentCandidate = 0;
        int indexOfCandidate = 0;
        int columns = matrix[0].length;
        for (int[] row : matrix) {
            int minIndex = 0;
            for (int i = 1; i < columns; i++) {
                if (row[i] < row[minIndex]) {
                    minIndex = i;
                }
            }
            if (row[minIndex] > currentCandidate) {
                currentCandidate = row[minIndex];
                indexOfCandidate = minIndex;
            }
        }
        for (int[] row : matrix) {
            if (row[indexOfCandidate] > currentCandidate) {
                return List.of();
            }
        }
        return List.of(currentCandidate);
    }

}