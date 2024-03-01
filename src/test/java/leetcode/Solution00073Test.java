package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00073Test {

    @Test
    void setZeroes() {
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        new Solution00073().setZeroes(matrix);

        int[][] expected = {{1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};

        assertArrayEquals(expected, matrix);
    }

}