package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2191. Sort the Jumbled Numbers
 * <a href="https://leetcode.com/problems/sort-the-jumbled-numbers">Web link</a> |
 * Medium
 */

public class Solution02191 {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .mapToObj(num -> new Data(num, getValueForSort(num, mapping)))
                .sorted(Comparator.comparingInt(Data::forSort))
                .mapToInt(Data::original)
                .toArray();
    }

    private static int getValueForSort(int num, int[] mapping) {
        int newNum = 0;
        int multiplier = 1;
        do {
            int digit = num % 10;
            newNum += mapping[digit] * multiplier;
            multiplier *= 10;
            num /= 10;
        } while (num > 0);
        return newNum;
    }

    private record Data(int original, int forSort) {
    }

}