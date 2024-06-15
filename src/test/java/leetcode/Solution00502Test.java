package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00502Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaximizedCapital2Heaps(int k, int w, String profitsStr, String capitalStr, int expected) {
        int[] profits = ArrayUtils.stringToIntArray(profitsStr);
        int[] capital = ArrayUtils.stringToIntArray(capitalStr);
        int result = new Solution00502().findMaximizedCapital2Heaps(k, w, profits, capital);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaximizedCapitalArrayPlusHeap(int k, int w, String profitsStr, String capitalStr, int expected) {
        int[] profits = ArrayUtils.stringToIntArray(profitsStr);
        int[] capital = ArrayUtils.stringToIntArray(capitalStr);
        int result = new Solution00502().findMaximizedCapitalArrayPlusHeap(k, w, profits, capital);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, 0, "[1,2,3]", "[0,1,1]", 4),
                Arguments.of(3, 0, "[1,2,3]", "[0,1,2]", 6)
        );
    }

}