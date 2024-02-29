package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00054Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        List<Integer> result = new Solution00054().spiralOrder(matrix);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),
                Arguments.of(new int[][]{
                                {7},
                                {9},
                                {6}
                        },
                        List.of(7, 9, 6)),
                Arguments.of(new int[][]{
                                {2, 5, 8},
                                {4, 0, -1}
                        },
                        List.of(2, 5, 8, -1, 0, 4)),
                Arguments.of(new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5))
        );
    }

}