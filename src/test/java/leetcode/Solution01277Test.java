package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01277Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countSquares(String matrixStr, int expected) {
        Solution01277 solution = new Solution01277();
        int[][] matrix = ArrayUtils.stringTo2DIntArray(matrixStr);
        assertEquals(expected, solution.countSquares(matrix));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("""
                        [
                          [0,1,1,1],
                          [1,1,1,1],
                          [0,1,1,1]
                        ]""", 15),
                Arguments.of("""
                        [
                          [1,0,1],
                          [1,1,0],
                          [1,1,0]
                        ]""", 7)
        );
    }

}