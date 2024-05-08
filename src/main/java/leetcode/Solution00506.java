package leetcode;

import java.util.*;

/**
 * 506. Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 * Easy
 */

public class Solution00506 {

    public String[] findRelativeRanks(int[] score) {
        final int n = score.length;
        int[] copySorted = Arrays.stream(score).sorted().toArray();
        Map<Integer, Integer> scoreValueToPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final int position = n - i; // if n=5, i0=5-0 = 5th, i4=5-4 = 1st(gold)
            scoreValueToPosition.put(copySorted[i], position);
        }

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = placeToRank(scoreValueToPosition.get(score[i]));
        }
        return result;
    }

    private String placeToRank(int place) {
        return switch (place) {
            case 1 -> "Gold Medal";
            case 2 -> "Silver Medal";
            case 3 -> "Bronze Medal";
            default -> String.valueOf(place);
        };
    }

    public String[] findRelativeRanksPriorityQueue(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = score.length;
        for (int individualScore : score) {
            pq.offer(individualScore);
        }
        String[] ranksByScore = new String[pq.peek() + 1];
        String[] ranksInOriginalOrder = new String[n];
        for (int i = 0; i < n; i++) {
            ranksByScore[pq.poll()] = placeToRank(i + 1);
        }
        for (int i = 0; i < n; i++) {
            ranksInOriginalOrder[i] = ranksByScore[score[i]];
        }
        return ranksInOriginalOrder;
    }

}