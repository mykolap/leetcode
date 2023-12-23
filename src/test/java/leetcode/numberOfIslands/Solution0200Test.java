package leetcode.numberOfIslands;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0200Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'1', '1', '1', '1', '0'},
                                {'1', '1', '0', '1', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '0', '0', '0'}
                        },
                        1
                ),
                Arguments.of(
                        new char[][]{
                                {'1', '1', '0', '0', '0'},
                                {'1', '1', '0', '0', '0'},
                                {'0', '0', '1', '0', '0'},
                                {'0', '0', '0', '1', '1'}
                        },
                        3
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numIslandsDfsBased(char[][] grid, int expected) {
        assertEquals(expected, new Solution0200().numIslandsDfsBased(grid));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numIslandsBfsBased(char[][] grid, int expected) {
        assertEquals(expected, new Solution0200().numIslandsBfsBased(grid));
    }

}