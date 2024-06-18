package leetcode;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 826. Most Profit Assigning Work
 * https://leetcode.com/problems/most-profit-assigning-work/description/
 * Medium
 */

public class Solution00826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        NavigableMap<Integer, Integer> profitByDifficulty = new TreeMap<>();
        final int n = difficulty.length;
        List<Pair<Integer, Integer>> projects = IntStream.range(0, n)
                .mapToObj(i -> new Pair<>(difficulty[i], profit[i]))
                .sorted(Comparator.comparingInt(Pair::getKey))
                .toList();

        for (Pair<Integer, Integer> project : projects) {
            final int currentDifficulty = project.getKey();
            final int currentProfit = project.getValue();
            final Map.Entry<Integer, Integer> floorEntry = profitByDifficulty.floorEntry(currentDifficulty);
            if (floorEntry == null) {
                profitByDifficulty.put(currentDifficulty, currentProfit);
            } else {
                profitByDifficulty.put(currentDifficulty, Math.max(floorEntry.getValue(), currentProfit));
            }
        }

        int totalProfit = 0;
        for (int workerAbility : worker) {
            final Map.Entry<Integer, Integer> floorEntry = profitByDifficulty.floorEntry(workerAbility);
            if (floorEntry != null) {
                final int currentProfit = floorEntry.getValue();
                totalProfit += currentProfit;
            }
        }
        return totalProfit;
    }

}