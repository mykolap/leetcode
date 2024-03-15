package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00274Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void hIndex(int[] citations, int expected) {
        int result = new Solution00274().hIndex(citations);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void hIndexSorting(int[] citations, int expected) {
        int result = new Solution00274().hIndexSorting(citations);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 6, 1, 5}, 3),
                Arguments.of(new int[]{1, 3, 1}, 1)
        );
    }

}