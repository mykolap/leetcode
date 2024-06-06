package leetcode;

import java.util.*;

/**
 * 846. Hand of Straights
 * <a href="https://leetcode.com/problems/hand-of-straights">Web link</a> |
 * Medium
 */

public class Solution00846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        final int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        for (int i = 0; i < len / groupSize; i++) {
            final Iterator<Integer> iterator = countMap.keySet().iterator();
            if (!iterator.hasNext()) {
                break;
            }
            int firstCard = iterator.next();
            int countFirst = countMap.get(firstCard);
            for (int j = 0; j < groupSize; j++) {
                int card = firstCard + j;
                if (countMap.getOrDefault(card, 0) < countFirst) {
                    return false;
                }
                countMap.put(card, countMap.get(card) - countFirst);
                if (countMap.get(card) == 0) {
                    countMap.remove(card);
                }
            }
        }
        return countMap.isEmpty();
    }

    public boolean isNStraightHandOptimized(int[] hand, int groupSize) {
        if (groupSize == 1) {
            return true;
        }
        final int len = hand.length;
        if (len % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }
        for (int i = 0; i < len; ) {
            int firstCard = hand[i];
            int countFirst = countMap.getOrDefault(firstCard, 0);
            if (countFirst == 0) {
                i++;
                continue;
            }
            for (int j = 0; j < groupSize; j++) {
                int card = firstCard + j;
                if (countMap.getOrDefault(card, 0) < countFirst) {
                    return false;
                }
                countMap.put(card, countMap.get(card) - countFirst);
                if (countMap.get(card) == 0) {
                    countMap.remove(card);
                }
            }
            i += countFirst;
        }
        return countMap.isEmpty();
    }

}