package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00119Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getRowOptimized(int rowIndex, List<Integer> expected) {
        List<Integer> result = new Solution00119().getRowOptimized(rowIndex);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getRow(int rowIndex, List<Integer> expected) {
        List<Integer> result = new Solution00119().getRow(rowIndex);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, List.of(1, 3, 3, 1)),
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1, 1)),
                Arguments.of(2, List.of(1, 2, 1)),
                Arguments.of(4, List.of(1, 4, 6, 4, 1))
        );
    }

}