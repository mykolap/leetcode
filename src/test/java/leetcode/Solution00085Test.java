package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00085Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximalRectangle(char[][] matrix, int expected) {
        int result = new Solution00085().maximalRectangle(matrix);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 6),
                Arguments.of(new char[][]{
                        {'0', '1'},
                        {'1', '0'}
                }, 1),
                Arguments.of(new char[][]{
                        {'0'}
                }, 0),
                Arguments.of(new char[][]{
                        {'1'}
                }, 1),
                Arguments.of(new char[][]{
                        {'0', '0'},
                        {'0', '0'}
                }, 0),
                Arguments.of(new char[][]{
                        {'1', '1'},
                        {'1', '1'}
                }, 4)
        );
    }

}
