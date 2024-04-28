package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03127Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canMakeSquare(char[][] grid, boolean expected) {
        boolean result = new Solution03127().canMakeSquare(grid);
        assertEquals(expected, result);
    }

    private static Object[][] casesProvider() {
        return new Object[][]{
                {new char[][]{{'B', 'W', 'B'},
                        {'B', 'W', 'W'},
                        {'B', 'W', 'B'}}, true},
                {new char[][]{{'B', 'W', 'B'},
                        {'W', 'B', 'W'},
                        {'B', 'W', 'B'}}, false},
                {new char[][]{{'B', 'W', 'B'},
                        {'B', 'W', 'W'},
                        {'B', 'W', 'W'}}, true}
        };
    }
}