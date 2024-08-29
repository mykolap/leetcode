package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00947Test {

    @Test
    void removeStones() {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int expected = 5;
        int result = new Solution00947().removeStones(stones);
        assertEquals(expected, result);
    }

}