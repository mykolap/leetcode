package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00778Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void swimInWater(String gridStr, int expected) {
        int[][] grid = ArrayUtils.stringToInt2DArray(gridStr);
        int result = new Solution00778().swimInWater(grid);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[0,2],[1,3]]", 3),
                Arguments.of("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]", 16),
                Arguments.of("[[3,2],[0,1]]", 3)
        );
    }

}