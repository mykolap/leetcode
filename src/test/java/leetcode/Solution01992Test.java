package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution01992Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findFarmland(int[][] land, int[][] expected) {
        int[][] actual = new Solution01992().findFarmland(land);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 0, 0},
                                {0, 1, 1},
                                {0, 1, 1}
                        },
                        new int[][]{
                                {0, 0, 0, 0},
                                {1, 1, 2, 2}
                        }),
                Arguments.of(new int[][]{
                                {1, 1},
                                {1, 1}},
                        new int[][]{
                                {0, 0, 1, 1}
                        }),
                Arguments.of(new int[][]{{0}},
                        new int[][]{})
        );
    }
}